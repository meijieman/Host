package com.hongfans.host;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;
import com.hongfans.common.log.LogUtil;
import com.hongfans.usage.Andy;

import java.io.File;

public class HostActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PACKAGE_NAME = "com.hongfans.plugin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        findViewById(R.id.btn_load).setOnClickListener(this);
        findViewById(R.id.btn_start).setOnClickListener(this);

        LogUtil.w("Host 调用公用库 " + Andy.getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load:
                if (isLoaded(this, PACKAGE_NAME)) {
                    Toast.makeText(HostActivity.this, "插件已加载", Toast.LENGTH_SHORT).show();
                } else {
                    final File apk = new File(Environment.getExternalStorageDirectory(), "zzz.apk");
                    Log.i("tag_host", "apk " + apk.getAbsolutePath() + ", " + apk.exists());
                    if (!apk.exists()) {
                        Toast.makeText(HostActivity.this, "插件不存在", Toast.LENGTH_SHORT).show();
                    } else {
                        final PluginManager pluginManager = PluginManager.getInstance(this);
                        try {
                            pluginManager.loadPlugin(apk);
                            Toast.makeText(HostActivity.this, "插件加载成功", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case R.id.btn_start:
                if (isLoaded(this, PACKAGE_NAME)) {
                    Intent intent = new Intent();
                    intent.setClassName(PACKAGE_NAME, PACKAGE_NAME + ".MainActivity");
                    startActivity(intent);
                    Toast.makeText(this, "跳转成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "插件未加载", Toast.LENGTH_SHORT).show();
                }
                break;
            default:

                break;
        }
    }

    public static boolean isLoaded(Context context, String pkgName){
         return PluginManager.getInstance(context).getLoadedPlugin(pkgName) != null;
    }
}
