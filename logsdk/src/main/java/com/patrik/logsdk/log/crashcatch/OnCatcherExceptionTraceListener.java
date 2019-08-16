package com.patrik.logsdk.log.crashcatch;

public interface OnCatcherExceptionTraceListener {
    void onSaveLogInChildThreadPlease(Thread t, Throwable e);
}