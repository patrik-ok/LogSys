package com.patrik.logsdk.log;

import android.os.Environment;
import android.util.Log;

import com.patrik.logsdk.action.LogTypeInterface;

import java.io.File;

public class LogUtils implements LogTypeInterface {
    /**
     * 默认行为码(log tag)
     */
    public static final String ACTION_CODE_DEFAULT = "#com.patrik.logsdk#!==";
    /**
     * 普通型日志文件夹名
     */
    private static final String PATH_LOG_NORMAL = "normal";
    /**
     * 警告型日志文件夹名
     */
    private static final String PATH_LOG_WARNING = "warning";
    /**
     * 错误型日志文件夹名
     */
    private static final String PATH_LOG_ERROR = "warning";

    /**
     * 获取默认存储路径
     *
     * @return
     */
    private String getDiskCacheDir(String targetDirectory) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = LogMonster.getInstance().mContext.getExternalCacheDir().getPath();
        } else {
            cachePath = LogMonster.getInstance().mContext.getCacheDir().getPath();
        }
        if (cachePath == null || "".equals(cachePath)) {
            return "";
        }
        return cachePath + File.separator + "logsdk" + File.separator + targetDirectory;
    }

    /**
     * 将日志写入文件
     *
     * @param actionCode
     * @param logTxt
     * @param targetDirectory
     * @return
     */
    private String write2File(String actionCode, String logTxt, String targetDirectory) {
        String targetPath = getDiskCacheDir(targetDirectory);
        return targetPath;
    }

    @Override
    public void log(String logTxt) {
        Log.d(ACTION_CODE_DEFAULT, logTxt);
    }

    @Override
    public void logWarning(String logTxt) {
        Log.w(ACTION_CODE_DEFAULT, logTxt);
    }

    @Override
    public void logError(String logTxt) {
        Log.e(ACTION_CODE_DEFAULT, logTxt);
    }

    @Override
    public void log(Throwable tr) {
        Log.d(ACTION_CODE_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void logWarning(Throwable tr) {
        Log.w(ACTION_CODE_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void logError(Throwable tr) {
        Log.e(ACTION_CODE_DEFAULT, Log.getStackTraceString(tr));
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
        return write2File(ACTION_CODE_DEFAULT, logTxt, PATH_LOG_NORMAL);
    }

    @Override
    public String logWarning2File(String logTxt) {
        return write2File(ACTION_CODE_DEFAULT, logTxt, PATH_LOG_WARNING);
    }

    @Override
    public String logError2File(String logTxt) {
        return write2File(ACTION_CODE_DEFAULT, logTxt, PATH_LOG_ERROR);
    }

    @Override
    public String log2File(Throwable tr) {
        return write2File(ACTION_CODE_DEFAULT, Log.getStackTraceString(tr), PATH_LOG_NORMAL);
    }

    @Override
    public String logWarning2File(Throwable tr) {
        return write2File(ACTION_CODE_DEFAULT, Log.getStackTraceString(tr), PATH_LOG_WARNING);
    }

    @Override
    public String logError2File(Throwable tr) {
        return write2File(ACTION_CODE_DEFAULT, Log.getStackTraceString(tr), PATH_LOG_ERROR);
    }

    @Override
    public String logFile(String actionCode, String logTxt) {
        return write2File(actionCode, logTxt, PATH_LOG_NORMAL);
    }

    @Override
    public String logFileWarning(String actionCode, String logTxt) {
        return write2File(actionCode, logTxt, PATH_LOG_WARNING);
    }

    @Override
    public String logFileError(String actionCode, String logTxt) {
        return write2File(actionCode, logTxt, PATH_LOG_ERROR);
    }

    @Override
    public String logFile(String actionCode, Throwable tr) {
        return write2File(actionCode, Log.getStackTraceString(tr), PATH_LOG_NORMAL);
    }

    @Override
    public String logFileWarning(String actionCode, Throwable tr) {
        return write2File(actionCode, Log.getStackTraceString(tr), PATH_LOG_WARNING);
    }

    @Override
    public String logFileError(String actionCode, Throwable tr) {
        return write2File(actionCode, Log.getStackTraceString(tr), PATH_LOG_ERROR);
    }
}
