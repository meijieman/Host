package com.hongfans.plugin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hongfans.common.log.LogUtil;
import com.hongfans.usage.Andy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtil.i("onCreate ");

        setTitle("Plugin");

        LogUtil.w("插件 调用公用库 " + Andy.getName());
    }
}
