package com.hongfans.plugin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hongfans.common.log.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtil.i("onCreate ");

        setTitle("Plugin");
    }
}
