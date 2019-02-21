package com.patrik.logsdk.action;

public interface LogTypeInterface {
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
     * 错误型日志,仅console打印
     *
     * @param logTxt
     */
    void logError(String logTxt);


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
     * 错误型日志,仅console打印
     *
     * @param tr
     */
    void logError(Throwable tr);

    /**
     * 普通型日志,仅console打印
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param logTxt
     */
    void log(String actionCode, String logTxt);

    /**
     * 警告型日志,仅console打印
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logWarning(String actionCode, String logTxt);

    /**
     * 错误型日志,仅console打印
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param logTxt
     */
    void logError(String actionCode, String logTxt);

    /**
     * 普通型日志,仅console打印
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param tr
     */
    void log(String actionCode, Throwable tr);

    /**
     * 警告型日志,仅console打印
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param tr
     */
    void logWarning(String actionCode, Throwable tr);

    /**
     * 错误型日志,仅console打印
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param tr
     */
    void logError(String actionCode, Throwable tr);

//    -----------------------------------------------------------

    /**
     * 普通型日志,写入文件
     *
     * @param logTxt
     * @return storagePath
     */
    String log2File(String logTxt);

    /**
     * 警告型日志,写入文件
     *
     * @param logTxt
     * @return storagePath
     */
    String logWarning2File(String logTxt);

    /**
     * 错误型日志,写入文件
     *
     * @param logTxt
     * @return storagePath
     */
    String logError2File(String logTxt);

    /**
     * 普通型日志,写入文件
     *
     * @param tr
     * @return storagePath
     */
    String log2File(Throwable tr);

    /**
     * 警告型日志,写入文件
     *
     * @param tr
     * @return storagePath
     */
    String logWarning2File(Throwable tr);

    /**
     * 错误型日志,写入文件
     *
     * @param tr
     * @return storagePath
     */
    String logError2File(Throwable tr);

    /**
     * 普通型日志,写入文件
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param logTxt
     * @return storagePath
     */
    String logFile(String actionCode, String logTxt);

    /**
     * 警告型日志,写入文件
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param logTxt
     * @return storagePath
     */
    String logFileWarning(String actionCode, String logTxt);

    /**
     * 错误型日志,写入文件
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param logTxt
     * @return storagePath
     */
    String logFileError(String actionCode, String logTxt);

    /**
     * 普通型日志,写入文件
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param tr
     * @return storagePath
     */
    String logFile(String actionCode, Throwable tr);

    /**
     * 警告型日志,写入文件
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param tr
     * @return storagePath
     */
    String logFileWarning(String actionCode, Throwable tr);

    /**
     * 错误型日志,写入文件
     *
     * @param actionCode 行为码(以便查问题筛选)
     * @param tr
     * @return storagePath
     */
    String logFileError(String actionCode, Throwable tr);
}
