package com.ourpalm.jqs_plugin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ourpalm.jqspluginlib.PluginManage;
import com.ourpalm.jqspluginlib.ProxyActivity;
import com.ourpalm.jqspluginlib.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PluginManage.getInstance().init(this);
    }

    public void loadApk(View view) {
        String ApkPath = Utils.copyAssetsAndWrite(this, "aa.apk");
        PluginManage.getInstance().loadApk(ApkPath);

    }

    public void JumpActivty(View view) {

        Intent intent = new Intent();
        intent.putExtra("className", "com.ourpalm.pluginsample.PluginSampleActivity");
        intent.setClass(this, ProxyActivity.class);
        startActivity(intent);

    }
}
