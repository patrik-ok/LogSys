package com.patrik.logsdk.log;
import android.util.Log;

import com.patrik.logsdk.BuildConfig;
import com.patrik.logsdk.callback.ILogType;
import com.patrik.logsdk.tools.FileUtils;

import java.io.File;

public class LogUtilsImpl implements ILogType {

    private static volatile LogUtilsImpl mInstance = null;

    protected static LogUtilsImpl getInstance() {
        if (mInstance == null) {
            synchronized (LogUtilsImpl.class) {
                if (mInstance == null) {
                    mInstance = new LogUtilsImpl();
                }
            }
        }
        return mInstance;
    }

    /**
     * 日志写入文件
     *
     * @param actionCode
     * @param logTxt
     * @param targetDirectory
     * @return
     */
    private String write2File(String actionCode, String logTxt, String targetDirectory) {
        String fileName = actionCode + "_" + System.currentTimeMillis() + ".txt";
        String targetFilePath = FileUtils.getDiskCacheDir(LogMonster.getInstance().mContext, LogConstants.GLOBAL_GROUP_DIRECTORY_DEFAULT, targetDirectory, fileName,
                "LogUtilsImpl.write2File(...)");
        if (!BuildConfig.isProduct) {
            logWarning(targetFilePath);
        }
        if ("".equals(targetFilePath)) {
            //存储有问题，直接上传到网络
            String error = "获取文件路径失败/logsdk/" + targetDirectory + "/" + fileName;
            // TODO: 2019/2/28 log2Cloud.
            return error;
        }
        //开始写入文件
        FileUtils.writeString(new File(targetFilePath), actionCode + "\n" + logTxt);

        return targetFilePath;
    }


    @Override
    public void log(String logTxt) {
        Log.d(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, logTxt);
    }

    @Override
    public void logWarning(String logTxt) {
        Log.w(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, logTxt);
    }

    @Override
    public void logError(String logTxt) {
        Log.e(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, logTxt);
    }

    @Override
    public void log(Throwable tr) {
        Log.d(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void logWarning(Throwable tr) {
        Log.w(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void logError(Throwable tr) {
        Log.e(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void log(String actionCode, String logTxt) {
        Log.d(actionCode, logTxt);
    }

    @Override
    public void logWarning(String actionCode, String logTxt) {
        Log.w(actionCode, logTxt);
    }

    @Override
    public void logError(String actionCode, String logTxt) {
        Log.e(actionCode, logTxt);
    }

    @Override
    public void log(String actionCode, Throwable tr) {
        Log.d(actionCode, Log.getStackTraceString(tr));
    }

    @Override
    public void logWarning(String actionCode, Throwable tr) {
        Log.w(actionCode, Log.getStackTraceString(tr));
    }

    @Override
    public void logError(String actionCode, Throwable tr) {
        Log.e(actionCode, Log.getStackTraceString(tr));
    }

    @Override
    public String log2File(String logTxt) {
        return write2File(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, logTxt, LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL);
    }

    @Override
    public String logWarning2File(String logTxt) {
        return write2File(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, logTxt, LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING);
    }

    @Override
    public String logError2File(String logTxt) {
        return write2File(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, logTxt, LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR);
    }

    @Override
    public String log2File(Throwable tr) {
        return write2File(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, Log.getStackTraceString(tr), LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL);
    }

    @Override
    public String logWarning2File(Throwable tr) {
        return write2File(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, Log.getStackTraceString(tr), LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING);
    }

    @Override
    public String logError2File(Throwable tr) {
        return write2File(LogConstants.GLOBAL_ACTION_CODE_DEFAULT, Log.getStackTraceString(tr), LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR);
    }

    @Override
    public String log2File(String actionCode, String logTxt) {
        return write2File(actionCode, logTxt, LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL);
    }

    @Override
    public String logWarning2File(String actionCode, String logTxt) {
        return write2File(actionCode, logTxt, LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING);
    }

    @Override
    public String logError2File(String actionCode, String logTxt) {
        return write2File(actionCode, logTxt, LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR);
    }

    @Override
    public String log2File(String actionCode, Throwable tr) {
        return write2File(actionCode, Log.getStackTraceString(tr), LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL);
    }

    @Override
    public String logWarning2File(String actionCode, Throwable tr) {
        return write2File(actionCode, Log.getStackTraceString(tr), LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING);
    }

    @Override
    public String logError2File(String actionCode, Throwable tr) {
        return write2File(actionCode, Log.getStackTraceString(tr), LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR);
    }
}
