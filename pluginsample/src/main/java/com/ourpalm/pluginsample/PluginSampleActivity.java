package com.ourpalm.pluginsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ourpalm.jqspluginlib.PluginActivty;

public class PluginSampleActivity extends PluginActivty {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
