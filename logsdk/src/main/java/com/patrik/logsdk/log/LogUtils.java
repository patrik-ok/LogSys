package com.patrik.logsdk.log;

import com.patrik.logsdk.BuildConfig;
import com.patrik.logsdk.tools.FileUtils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 供外部调用
 * 方法名注释详见ILogType.java
 */
public class LogUtils {
    public static void log(String logTxt) {
        LogUtilsImpl.getInstance().log(logTxt);
    }

    public static void logWarning(String logTxt) {
        LogUtilsImpl.getInstance().logWarning(logTxt);
    }

    public static void logError(String logTxt) {
        LogUtilsImpl.getInstance().logError(logTxt);
    }

    public static void log(Throwable tr) {
        LogUtilsImpl.getInstance().log(tr);
    }

    public static void logWarning(Throwable tr) {
        LogUtilsImpl.getInstance().logWarning(tr);
    }

    public static void logError(Throwable tr) {
        LogUtilsImpl.getInstance().logError(tr);
    }


    public static void log(String actionCode, String logTxt) {
        LogUtilsImpl.getInstance().log(actionCode, logTxt);
    }

    public static void logWarning(String actionCode, String logTxt) {
        LogUtilsImpl.getInstance().logWarning(actionCode, logTxt);
    }

    public static void logError(String actionCode, String logTxt) {
        LogUtilsImpl.getInstance().logError(actionCode, logTxt);
    }

    public static void log(String actionCode, Throwable tr) {
        LogUtilsImpl.getInstance().log(actionCode, tr);
    }

    public static void logWarning(String actionCode, Throwable tr) {
        LogUtilsImpl.getInstance().logWarning(actionCode, tr);
    }

    public static void logError(String actionCode, Throwable tr) {
        LogUtilsImpl.getInstance().logError(actionCode, tr);
    }

    public static String log2File(String logTxt) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(logTxt);
        }
        return LogUtilsImpl.getInstance().log2File(logTxt);
    }

    public static String logWarning2File(String logTxt) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(logTxt);
        }
        return LogUtilsImpl.getInstance().logWarning2File(logTxt);
    }

    public static String logError2File(String logTxt) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(logTxt);
        }
        return LogUtilsImpl.getInstance().logError2File(logTxt);
    }

    public static String log2File(Throwable tr) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(tr);
        }
        return LogUtilsImpl.getInstance().log2File(tr);
    }

    public static String logWarning2File(Throwable tr) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(tr);
        }
        return LogUtilsImpl.getInstance().logWarning2File(tr);
    }

    public static String logError2File(Throwable tr) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(tr);
        }
        return LogUtilsImpl.getInstance().logError2File(tr);
    }

    public static String log2File(String actionCode, String logTxt) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(actionCode, logTxt);
        }
        return LogUtilsImpl.getInstance().log2File(actionCode, logTxt);
    }

    public static String logWarning2File(String actionCode, String logTxt) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(actionCode, logTxt);
        }
        return LogUtilsImpl.getInstance().logWarning2File(actionCode, logTxt);
    }

    public static String logError2File(String actionCode, String logTxt) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(actionCode, logTxt);
        }
        return LogUtilsImpl.getInstance().logError2File(actionCode, logTxt);
    }

    public static String log2File(String actionCode, Throwable tr) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(actionCode, tr);
        }
        return LogUtilsImpl.getInstance().log2File(actionCode, tr);
    }

    public static String logWarning2File(String actionCode, Throwable tr) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(actionCode, tr);
        }
        return LogUtilsImpl.getInstance().logWarning2File(actionCode, tr);
    }

    public static String logError2File(String actionCode, Throwable tr) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(actionCode, tr);
        }
        return LogUtilsImpl.getInstance().logError2File(actionCode, tr);
    }


    public static String getLogStoragePath() {
        return !"".equals(LogMonster.getInstance().mLogStoragePath) ? LogMonster.getInstance().mLogStoragePath : FileUtils.getDiskCacheDirDefault(LogMonster.getInstance().mContext, "LogUtils.getLogStoragePath()");
    }

    public static String getUploadPath() {
        return LogMonster.getInstance().mUploadPath;
    }

    protected static LinkedBlockingQueue getLogQueue() {
        return LogUtilsImpl.getInstance().mLogLinkedBlockingQueue;
    }

    protected static Semaphore getSemaphore() {
        return LogUtilsImpl.getInstance().mSemaphore;
    }

}
