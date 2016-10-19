package com.app.cczhr.easyweather;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;

// 请在AndroidManifest.xml中application标签下android:name中指定该类
public class MyApplication extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        ApiStoreSDK.init(this, "ad8cbf37295ccb92a35c9c5ce11ce755");
    }
}
