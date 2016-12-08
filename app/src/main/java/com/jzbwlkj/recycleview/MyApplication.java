package com.jzbwlkj.recycleview;

import android.app.Application;
import android.view.View;

/**
 * 作者：admin on 2016/12/7 08:54
 */

public class MyApplication extends Application {
    //用于保存oldview防止每次退出该页面的时候,再次进入出现空指针异常
    public static View oldView;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
