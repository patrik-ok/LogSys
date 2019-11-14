package com.patrik.logsdk.log;

import android.content.Context;

import com.patrik.logsdk.callback.ILogConfig;
import com.patrik.logsdk.tools.FileUtils;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 日志系统初始化工作
 */
public class LogMonster implements ILogConfig {
    private static volatile LogMonster mLogMonster = null;
    private ExecutorService mLogExecutorService = null;
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
            // TODO: 2019/4/19 upload log 2 could
            LogUtils.log("context is null,日志写入文件的工作将无法进行");
            mLogMonster = null;
            return;
        }
        mContext = context.getApplicationContext();
        if (mLogExecutorService == null) {
            mLogExecutorService = Executors.newFixedThreadPool(50);
        }
        mLogExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        LogUtils.log("log正在监听...");
                        //https://www.jianshu.com/p/89c3031eb117
                        LogUtils.getSemaphore().acquire();
                        final String[] logInfo = (String[]) LogUtils.getLogQueue().poll(30L, TimeUnit.MINUTES);
                        LogUtils.log("log准备写入文件...");
                        if (logInfo != null && logInfo.length >= 2) {
                            mLogExecutorService.execute(new Runnable() {
                                @Override
                                public void run() {
                                    String finalFilePath = logInfo[0];
                                    String logTxt = logInfo[1];
                                    LogUtils.log("log正在写入文件...");
//                                    log开始写入文件
                                    FileUtils.writeString(new File(finalFilePath), logTxt);
                                }
                            });
                        }
                    } catch (Exception var1) {
                        LogUtils.logError2File(var1);
                    }
                }
            }
        });
    }


    public void shutdown() {
        if (mLogExecutorService != null) {
            mLogExecutorService.shutdownNow();
        }
        if (mLogMonster != null) {
            mLogMonster = null;
        }
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
