package com.patrik.logsdk.log;

import android.os.Environment;
import android.util.Log;

import com.patrik.logsdk.action.LogTypeInterface;

public class LogUtils implements LogTypeInterface {
    private static final String TAG_DEFAULT = "#com.patrik.logsdk#==";

    /**
     * 获取默认存储路径
     *
     * @return
     */
    private String getDiskCacheDir() {
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
        return cachePath;
    }

    @Override
    public void logError(String logTxt) {
        Log.e(TAG_DEFAULT, logTxt);
    }

    @Override
    public void log(String logTxt) {
        Log.d(TAG_DEFAULT, logTxt);
    }

    @Override
    public void logWarning(String logTxt) {
        Log.w(TAG_DEFAULT, logTxt);
    }

    @Override
    public void logFileError(String logTxt) {

    }

    @Override
    public void logFile(String logTxt) {

    }

    @Override
    public void logFileWarning(String logTxt) {

    }

    //    -----------------------------------------------------------
    @Override
    public void logError(Throwable tr) {
        Log.e(TAG_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void log(Throwable tr) {
        Log.d(TAG_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void logWarning(Throwable tr) {
        Log.w(TAG_DEFAULT, Log.getStackTraceString(tr));
    }

    @Override
    public void logFileError(Throwable tr) {

    }

    @Override
    public void logFile(Throwable tr) {

    }

    @Override
    public void logFileWarning(Throwable tr) {

    }

    //    -----------------------------------------------------------
    @Override
    public void logError(String action, String logTxt) {
        Log.e(action, logTxt);
    }

    @Override
    public void log(String action, String logTxt) {
        Log.d(action, logTxt);
    }

    @Override
    public void logWarning(String action, String logTxt) {
        Log.w(action, logTxt);
    }

    @Override
    public void logFileError(String action, String logTxt) {

    }

    @Override
    public void logFile(String action, String logTxt) {

    }

    @Override
    public void logFileWarning(String action, String logTxt) {

    }

    //    -----------------------------------------------------------
    @Override
    public void logError(String action, Throwable tr) {
        Log.e(action, Log.getStackTraceString(tr));
    }

    @Override
    public void log(String action, Throwable tr) {
        Log.d(action, Log.getStackTraceString(tr));
    }

    @Override
    public void logWarning(String action, Throwable tr) {
        Log.w(action, Log.getStackTraceString(tr));
    }

    @Override
    public void logFileError(String action, Throwable tr) {

    }

    @Override
    public void logFile(String action, Throwable tr) {

    }

    @Override
    public void logFileWarning(String action, Throwable tr) {

    }
}
