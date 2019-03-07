package com.patrik.logsdk.log;

import android.app.Activity;
import android.content.Context;

import com.patrik.logsdk.callback.ILogConfig;

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
            mLogMonster = null;
            return;
        }
        if (context instanceof Activity) {
            mContext = context.getApplicationContext();
        } else {
            mContext = context;
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
