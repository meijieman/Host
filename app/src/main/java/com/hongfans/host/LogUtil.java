package com.hongfans.host;

import android.util.Log;

/**
 * TODO
 * Created by MEI on 2018/3/13.
 */

public class LogUtil {

    private static final String TAG = "tag_lu";

    public static void e(Object msg){
        Log.e(TAG, "" + msg);
    }

    public static void w(Object msg){
        Log.w(TAG, "" + msg);
    }

    public static void i(Object msg){
        Log.i(TAG, "" + msg);
    }

    public static void init(String packageName, String tag_ele_host, boolean b, boolean b1) {

    }
}
