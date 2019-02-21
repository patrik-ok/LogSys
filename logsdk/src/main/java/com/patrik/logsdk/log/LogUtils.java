package com.patrik.logsdk.log;

/**
 * 供外部调用，详情见LogUtilsImpl.java
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
        return LogUtilsImpl.getInstance().log2File(logTxt);
    }

    public static String logWarning2File(String logTxt) {
        return LogUtilsImpl.getInstance().logWarning2File(logTxt);
    }

    public static String logError2File(String logTxt) {
        return LogUtilsImpl.getInstance().logError2File(logTxt);
    }

    public static String log2File(Throwable tr) {
        return LogUtilsImpl.getInstance().log2File(tr);
    }

    public static String logWarning2File(Throwable tr) {
        return LogUtilsImpl.getInstance().logWarning2File(tr);
    }

    public static String logError2File(Throwable tr) {
        return LogUtilsImpl.getInstance().logError2File(tr);
    }

    public static String logFile(String actionCode, String logTxt) {
        return LogUtilsImpl.getInstance().logFile(actionCode, logTxt);
    }

    public static String logFileWarning(String actionCode, String logTxt) {
        return LogUtilsImpl.getInstance().logFileWarning(actionCode, logTxt);
    }

    public static String logFileError(String actionCode, String logTxt) {
        return LogUtilsImpl.getInstance().logFileError(actionCode, logTxt);
    }

    public static String logFile(String actionCode, Throwable tr) {
        return LogUtilsImpl.getInstance().logFile(actionCode, tr);
    }

    public static String logFileWarning(String actionCode, Throwable tr) {
        return LogUtilsImpl.getInstance().logFileWarning(actionCode, tr);
    }

    public static String logFileError(String actionCode, Throwable tr) {
        return LogUtilsImpl.getInstance().logFileError(actionCode, tr);
    }
}
