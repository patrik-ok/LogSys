package com.patrik.logsdk.log;

import android.util.Log;

import com.patrik.logsdk.BuildConfig;
import com.patrik.logsdk.callback.ILogType;
import com.patrik.logsdk.tools.FileUtils;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

public class LogUtilsImpl implements ILogType {
    protected LinkedBlockingQueue<String[]> mLogLinkedBlockingQueue = new LinkedBlockingQueue(1001);
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
     * @param targetDirectory
     * @param fileName
     * @param logTxt
     * @return
     */
    private String write2LogQueue(String targetDirectory, String fileName, String logTxt) {
        String targetFilePath = FileUtils.getLogRealStoragePath(LogMonster.getInstance().mContext, LogConstants.GLOBAL_GROUP_DIRECTORY_DEFAULT, targetDirectory, fileName,
                "LogUtilsImpl.write2File(...)");
        if (!BuildConfig.isProduct) {
            logWarning(targetFilePath);
        }

        //判断是否存储有问题，是:直接上传到网络
//        case 1:存储空间太小
//        case 2:路径不合法
//        case 3:没有读写权限
//        case 4:文件过大
        String error = "获取文件路径失败/logsdk/" + targetDirectory + "/" + fileName;
        if (!targetFilePath.startsWith("/")) {

        }
        // TODO: 2019/2/28 log2Cloud.

        //将日志添加到队列
        mLogLinkedBlockingQueue.add(new String[]{logTxt, targetFilePath});

        return targetFilePath;
    }


    private <T> String logFormat(String logTag, T logTxt) {
        return logTag + logFormat(logTxt);
    }

    private <T> String logFormat(T logTxt) {
        StringBuilder stringBuilder = new StringBuilder();
        Log.d(LogConstants.GLOBAL_LOG_TAG_DEFAULT, Thread.currentThread().getName());
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        final int skipDepth = 2;
        final StackTraceElement trace = elements[skipDepth];
        stringBuilder.append(trace.getFileName());
        stringBuilder.append(":line->");
        stringBuilder.append(trace.getLineNumber());
        stringBuilder.append(":\n");

        String tempLogTxt = "";
        if (logTxt instanceof String) {
            tempLogTxt = (String) logTxt;
        } else if (logTxt instanceof Throwable) {
            tempLogTxt = Log.getStackTraceString((Throwable) logTxt);
        }
        stringBuilder.append(tempLogTxt);
        stringBuilder.append("\n<----------->\n");


        return stringBuilder.toString();
    }

    private String getFileName(String actionCode) {
        return actionCode + "_" + System.currentTimeMillis() + ".txt";
    }

    @Override
    public void log(String logTxt) {
        Log.d(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logFormat(logTxt));
    }

    @Override
    public void logWarning(String logTxt) {
        Log.w(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logFormat(logTxt));
    }

    @Override
    public void logError(String logTxt) {
        Log.e(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logFormat(logTxt));
    }

    @Override
    public void log(Throwable tr) {
        Log.d(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logFormat(tr));
    }

    @Override
    public void logWarning(Throwable tr) {
        Log.w(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logFormat(tr));
    }

    @Override
    public void logError(Throwable tr) {
        Log.e(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logFormat(tr));
    }

    @Override
    public void log(String actionCode, String logTxt) {
        Log.d(actionCode, logFormat(logTxt));
    }

    @Override
    public void logWarning(String actionCode, String logTxt) {
        Log.w(actionCode, logFormat(logTxt));
    }

    @Override
    public void logError(String actionCode, String logTxt) {
        Log.e(actionCode, logFormat(logTxt));
    }

    @Override
    public void log(String actionCode, Throwable tr) {
        Log.d(actionCode, logFormat(tr));
    }

    @Override
    public void logWarning(String actionCode, Throwable tr) {
        Log.w(actionCode, logFormat(tr));
    }

    @Override
    public void logError(String actionCode, Throwable tr) {
        Log.e(actionCode, logFormat(tr));
    }

    @Override
    public String log2File(String logTxt) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL, getFileName(LogConstants.GLOBAL_LOG_TAG_DEFAULT), logFormat(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logTxt));
    }

    @Override
    public String logWarning2File(String logTxt) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING, getFileName(LogConstants.GLOBAL_LOG_TAG_DEFAULT), logFormat(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logTxt));
    }

    @Override
    public String logError2File(String logTxt) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR, getFileName(LogConstants.GLOBAL_LOG_TAG_DEFAULT), logFormat(LogConstants.GLOBAL_LOG_TAG_DEFAULT, logTxt));
    }

    @Override
    public String log2File(Throwable tr) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL, getFileName(LogConstants.GLOBAL_LOG_TAG_DEFAULT), logFormat(LogConstants.GLOBAL_LOG_TAG_DEFAULT, tr));
    }

    @Override
    public String logWarning2File(Throwable tr) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING, getFileName(LogConstants.GLOBAL_LOG_TAG_DEFAULT), logFormat(LogConstants.GLOBAL_LOG_TAG_DEFAULT, tr));
    }

    @Override
    public String logError2File(Throwable tr) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL, getFileName(LogConstants.GLOBAL_LOG_TAG_DEFAULT), logFormat(LogConstants.GLOBAL_LOG_TAG_DEFAULT, tr));
    }

    @Override
    public String log2File(String actionCode, String logTxt) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL, getFileName(actionCode), logFormat(actionCode, logTxt));
    }

    @Override
    public String logWarning2File(String actionCode, String logTxt) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING, getFileName(actionCode), logFormat(actionCode, logTxt));
    }

    @Override
    public String logError2File(String actionCode, String logTxt) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR, getFileName(actionCode), logFormat(actionCode, logTxt));
    }

    @Override
    public String log2File(String actionCode, Throwable tr) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_NORMAL, getFileName(actionCode), logFormat(actionCode, tr));
    }

    @Override
    public String logWarning2File(String actionCode, Throwable tr) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_WARNING, getFileName(actionCode), logFormat(actionCode, tr));
    }

    @Override
    public String logError2File(String actionCode, Throwable tr) {
        return write2LogQueue(LogConstants.GLOBAL_TARGET_DIRECTORY_ERROR, getFileName(actionCode), logFormat(actionCode, tr));
    }
}
