package com.hongfans.host;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;
import com.hongfans.common.log.LogUtil;

/**
 * TODO
 * Created by MEI on 2018/3/5.
 */

public class HostApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.i("onCreate ");

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        LogUtil.init(getPackageName(), "tag_ele_host", true, false);
        LogUtil.i("attachBaseContext start " + this);
        PluginManager.getInstance(base).init();
        LogUtil.i("attachBaseContext end");
    }
}
