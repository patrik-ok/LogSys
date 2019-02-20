package com.patrik.logsdk.action;

public interface LogTypeInterface {
    /**
     * 错误型日志,仅console打印
     *
     * @param logTxt
     */
    void logError(String logTxt);

    /**
     * 普通型日志,仅console打印
     *
     * @param logTxt
     */
    void log(String logTxt);

    /**
     * 警告型日志,仅console打印
     *
     * @param logTxt
     */
    void logWarning(String logTxt);

    /**
     * 错误型日志,写入文件
     *
     * @param logTxt
     */
    void logFileError(String logTxt);

    /**
     * 普通型日志,写入文件
     *
     * @param logTxt
     */
    void logFile(String logTxt);

    /**
     * 警告型日志,写入文件
     *
     * @param logTxt
     */
    void logFileWarning(String logTxt);

//    -----------------------------------------------------------

    /**
     * 错误型日志,仅console打印
     *
     * @param tr
     */
    void logError(Throwable tr);

    /**
     * 普通型日志,仅console打印
     *
     * @param tr
     */
    void log(Throwable tr);

    /**
     * 警告型日志,仅console打印
     *
     * @param tr
     */
    void logWarning(Throwable tr);

    /**
     * 错误型日志,写入文件
     *
     * @param tr
     */
    void logFileError(Throwable tr);

    /**
     * 普通型日志,写入文件
     *
     * @param tr
     */
    void logFile(Throwable tr);

    /**
     * 警告型日志,写入文件
     *
     * @param tr
     */
    void logFileWarning(Throwable tr);

//    -----------------------------------------------------------

    /**
     * 错误型日志,仅console打印
     *
     * @param action 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logError(String action, String logTxt);

    /**
     * 普通型日志,仅console打印
     *
     * @param action 行为码(以便查问题筛选)
     * @param logTxt
     */
    void log(String action, String logTxt);

    /**
     * 警告型日志,仅console打印
     *
     * @param action 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logWarning(String action, String logTxt);

    /**
     * 错误型日志,写入文件
     *
     * @param action 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logFileError(String action, String logTxt);

    /**
     * 普通型日志,写入文件
     *
     * @param action 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logFile(String action, String logTxt);

    /**
     * 警告型日志,写入文件
     *
     * @param action 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logFileWarning(String action, String logTxt);
//    -----------------------------------------------------------

    /**
     * 错误型日志,仅console打印
     *
     * @param action 行为码(以便查问题筛选)
     * @param tr
     */
    void logError(String action, Throwable tr);

    /**
     * 普通型日志,仅console打印
     *
     * @param action 行为码(以便查问题筛选)
     * @param tr
     */
    void log(String action, Throwable tr);

    /**
     * 警告型日志,仅console打印
     *
     * @param action 行为码(以便查问题筛选)
     * @param tr
     */
    void logWarning(String action, Throwable tr);

    /**
     * 错误型日志,写入文件
     *
     * @param action 行为码(以便查问题筛选)
     * @param tr
     */
    void logFileError(String action, Throwable tr);

    /**
     * 普通型日志,写入文件
     *
     * @param action 行为码(以便查问题筛选)
     * @param tr
     */
    void logFile(String action, Throwable tr);

    /**
     * 警告型日志,写入文件
     *
     * @param action 行为码(以便查问题筛选)
     * @param tr
     */
    void logFileWarning(String action, Throwable tr);
}
