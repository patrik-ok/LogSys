package com.patrik.logsdk.log;

import com.patrik.logsdk.BuildConfig;
import com.patrik.logsdk.tools.FileUtils;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 供外部调用
 * 方法名注释详见ILogType.java
 */
public class LogUtils {
    public static void log(String logTxt, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().log(logTxt, stackTraceElement);
    }

    public static void logWarning(String logTxt, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logWarning(logTxt, stackTraceElement);
    }

    public static void logError(String logTxt, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logError(logTxt, stackTraceElement);
    }

    public static void log(Throwable tr, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().log(tr, stackTraceElement);
    }

    public static void logWarning(Throwable tr, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logWarning(tr, stackTraceElement);
    }

    public static void logError(Throwable tr, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logError(tr, stackTraceElement);
    }


    public static void log(String actionCode, String logTxt, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().log(actionCode, logTxt, stackTraceElement);
    }

    public static void logWarning(String actionCode, String logTxt, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logWarning(actionCode, logTxt, stackTraceElement);
    }

    public static void logError(String actionCode, String logTxt, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logError(actionCode, logTxt, stackTraceElement);
    }

    public static void log(String actionCode, Throwable tr, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().log(actionCode, tr, stackTraceElement);
    }

    public static void logWarning(String actionCode, Throwable tr, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logWarning(actionCode, tr, stackTraceElement);
    }

    public static void logError(String actionCode, Throwable tr, StackTraceElement[] stackTraceElement) {
        LogUtilsImpl.getInstance().logError(actionCode, tr, stackTraceElement);
    }

    public static String log2File(String logTxt, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(logTxt, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().log2File(logTxt, stackTraceElement);
    }

    public static String logWarning2File(String logTxt, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(logTxt, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logWarning2File(logTxt, stackTraceElement);
    }

    public static String logError2File(String logTxt, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(logTxt, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logError2File(logTxt, stackTraceElement);
    }

    public static String log2File(Throwable tr, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(tr, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().log2File(tr, stackTraceElement);
    }

    public static String logWarning2File(Throwable tr, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(tr, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logWarning2File(tr, stackTraceElement);
    }

    public static String logError2File(Throwable tr, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(tr, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logError2File(tr, stackTraceElement);
    }

    public static String log2File(String actionCode, String logTxt, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(actionCode, logTxt, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().log2File(actionCode, logTxt, stackTraceElement);
    }

    public static String logWarning2File(String actionCode, String logTxt, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(actionCode, logTxt, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logWarning2File(actionCode, logTxt, stackTraceElement);
    }

    public static String logError2File(String actionCode, String logTxt, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(actionCode, logTxt, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logError2File(actionCode, logTxt, stackTraceElement);
    }

    public static String log2File(String actionCode, Throwable tr, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().log(actionCode, tr, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().log2File(actionCode, tr, stackTraceElement);
    }

    public static String logWarning2File(String actionCode, Throwable tr, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logWarning(actionCode, tr, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logWarning2File(actionCode, tr, stackTraceElement);
    }

    public static String logError2File(String actionCode, Throwable tr, StackTraceElement[] stackTraceElement) {
        if (!BuildConfig.isProduct) {
            LogUtilsImpl.getInstance().logError(actionCode, tr, stackTraceElement);
        }
        return LogUtilsImpl.getInstance().logError2File(actionCode, tr, stackTraceElement);
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
}
