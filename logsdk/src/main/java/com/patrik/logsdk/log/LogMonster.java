package com.patrik.logsdk.log;

import android.content.Context;

import com.patrik.logsdk.callback.ILogConfig;
import com.patrik.logsdk.tools.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 日志系统初始化工作
 */
public class LogMonster implements ILogConfig {
    private static volatile LogMonster mLogMonster = null;
    protected Context mContext;
    /**
     * 将日志上送到云端,地址;http
     */
    protected String mUploadPath = "";
    /**
     * 自设定log存储路径
     */
    protected String mLogStoragePath = "";

    public static LogMonster getInstance() {
        if (mLogMonster == null) {
            synchronized (LogMonster.class) {
                if (mLogMonster == null) {
                    mLogMonster = new LogMonster();
                }
            }
        }
        return mLogMonster;
    }

    public void init(Context context) {
        if (context == null) {
            // TODO: 2019/2/20 add log;
            LogUtils.logWarning("context is null,日志写入文件的工作将无法进行", Thread.currentThread().getStackTrace());
            mLogMonster = null;
            return;
        }
        mContext = context.getApplicationContext();
        Thread logThread = new Thread("LogWrite2FileThread") {
            public void run() {
                super.run();
                while (true) {
                    while (true) {
                        try {
                            if (LogUtils.getLogQueue() == null) {
                                LogUtils.log("logQueue 为null，鼾睡15秒", Thread.currentThread().getStackTrace());
                                Thread.sleep(15000L);
                            } else {
                                String[] logInfo = (String[]) LogUtils.getLogQueue().poll(30L, TimeUnit.MINUTES);
                                if (logInfo != null && logInfo.length >= 2) {
                                    String logTxt = logInfo[0];
                                    String finalFilePath = logInfo[1];
//                                    log开始写入文件
                                    FileUtils.writeString(new File(finalFilePath), logTxt);
                                }
                            }
                        } catch (Exception var1) {
                            LogUtils.logError2File(var1, Thread.currentThread().getStackTrace());
                        }
                    }
                }
            }
        };
        logThread.start();
    }

    @Override
    public LogMonster setUploadPath(String uploadPath) {
        mUploadPath = uploadPath;
        return mLogMonster;
    }

    @Override
    public LogMonster setLogStoragePath(String path) {
        mLogStoragePath = path;
        return mLogMonster;
    }
}
