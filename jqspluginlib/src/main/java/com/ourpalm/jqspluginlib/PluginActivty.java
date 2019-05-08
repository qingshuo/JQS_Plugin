package com.ourpalm.jqspluginlib;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * 作者：liqingshuo on 2019-05-08 21:28
 *
 * @author liqingshuo
 */
public class PluginActivty extends Activity implements IPlugin {

    /**
     * 用于区分apk是直接安装到手机上， 还是用作于插件。
     */
    private int mForm = FROM_INTERNAL;

    private Activity mProxyActivty;

    @Override
    public void attach(Activity proxyActivity) {
        mProxyActivty = proxyActivity;
    }

    @Override
    public void onCreate(Bundle saveInstancState) {
        if (saveInstancState != null) {
            mForm = saveInstancState.getInt("FROM");
        }

        if (mForm == FROM_INTERNAL) {
            super.onCreate(saveInstancState);
            mProxyActivty = this;
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (mForm == FROM_INTERNAL) {
            super.setContentView(layoutResID);
        } else {
            mProxyActivty.setContentView(layoutResID);
        }

    }

    @Override
    public void onStart() {
        if (mForm == FROM_INTERNAL) {
            super.onStart();
        }
    }

    @Override
    public void onRestart() {
        if (mForm == FROM_INTERNAL) {
            super.onRestart();
        }
    }

    @Override
    public void onActivityResult(int resquestCode, int resultCode, Intent data) {
        if (mForm == FROM_INTERNAL) {
            super.onActivityResult(resquestCode, resultCode, data);
        }
    }

    @Override
    public void onResume() {
        if (mForm == FROM_INTERNAL) {
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if (mForm == FROM_INTERNAL) {
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mForm == FROM_INTERNAL) {
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if (mForm == FROM_INTERNAL) {
            super.onDestroy();
        }
    }
}
