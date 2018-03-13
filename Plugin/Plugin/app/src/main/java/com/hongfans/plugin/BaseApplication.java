package com.hongfans.plugin;

import android.app.Application;

/**
 * TODO
 * Created by MEI on 2018/3/9.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.init(getPackageName(), "tag_ele", true, false);

        LogUtil.i("初始化 BaseApplication " + this);
    }
}
