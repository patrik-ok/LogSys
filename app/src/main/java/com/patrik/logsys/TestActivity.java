package com.patrik.logsys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.patrik.logsdk.log.LogUtils;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.log(Thread.currentThread().getName());
        setContentView(R.layout.activity_test);
        LogUtils.log("patrik",Thread.currentThread().getStackTrace());
    }
}
