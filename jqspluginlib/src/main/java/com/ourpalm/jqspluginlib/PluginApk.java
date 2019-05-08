package com.ourpalm.jqspluginlib;


import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * 作者：liqingshuo on 2019-05-08 20:45
 *
 * @author liqingshuo
 */
public class PluginApk {

    public PackageInfo mPackageInfo;
    public Resources mResources;
    public AssetManager mAssetManager;
    public DexClassLoader mDexClassLoader;


    public PluginApk(PackageInfo mPackageInfo, Resources mResources, DexClassLoader mDexClassLoader) {
        this.mPackageInfo = mPackageInfo;
        this.mResources = mResources;
        this.mDexClassLoader = mDexClassLoader;

        mAssetManager = mResources.getAssets();
    }
}
