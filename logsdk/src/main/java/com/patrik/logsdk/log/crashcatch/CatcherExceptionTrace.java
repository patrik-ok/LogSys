package com.patrik.logsdk.log.crashcatch;

import android.os.Process;

public class CatcherExceptionTrace implements Thread.UncaughtExceptionHandler {
    private CatcherExceptionTrace() {

    }

    private static CatcherExceptionTrace mInstance = null;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;//系统的默认异常处理类
    private OnCatcherExceptionTraceListener mListener;

    public static CatcherExceptionTrace init(OnCatcherExceptionTraceListener listener) {
        if (mInstance == null) {
            synchronized (CatcherExceptionTrace.class) {
                if (mInstance == null) {
                    mInstance = new CatcherExceptionTrace();
                }
            }
        }
        mInstance.mListener = listener;
        return mInstance.innerInit();
    }

    private CatcherExceptionTrace innerInit() {
        mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        return mInstance;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (mListener != null) {
            try {
                mListener.onSaveLogInChildThreadPlease(t, e);
            } catch (Exception innerException) {

            }
        }
//        如果系统提供了异常处理类，则交给系统去处理
        if (mDefaultExceptionHandler != null) {
            mDefaultExceptionHandler.uncaughtException(t, e);
        } else {
            //否则我们自己处理，自己处理通常是让app退出
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }


}
