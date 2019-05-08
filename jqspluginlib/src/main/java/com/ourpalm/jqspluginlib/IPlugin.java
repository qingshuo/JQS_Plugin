package com.ourpalm.jqspluginlib;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * 作者：liqingshuo on 2019-05-08 21:19
 *
 * @author liqingshuo
 */
public interface IPlugin {

    /**
     * 用于区分apk是直接安装到手机上， 还是用作于插件。
     * FROM_INTERNAL 直接安装与手机上
     * FROM_EXTERNAL  用作于插件
     */
    int FROM_INTERNAL = 0;
    int FROM_EXTERNAL = 1;

    void attach(Activity proxyActivity);

    void onCreate(Bundle saveInstancState);

    void onStart();

    void onRestart();

    void onActivityResult(int resquestCode, int resultCode, Intent data);

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();


}
