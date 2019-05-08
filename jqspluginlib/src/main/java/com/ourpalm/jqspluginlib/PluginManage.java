package com.ourpalm.jqspluginlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;
import java.net.ContentHandler;

import dalvik.system.DexClassLoader;

/**
 * 作者：liqingshuo on 2019-05-08 20:51
 *
 * @author liqingshuo
 */
public class PluginManage {

    public static final PluginManage instance = new PluginManage();

    private Context mContext;

    private PluginApk mPluginApk;

    public static PluginManage getInstance() {
        return instance;
    }

    private PluginManage() {
    }

    public void init(Context context) {
        this.mContext = context;
    }

    /**
     * 加载APK
     */
    public void loadApk(String apkPath) {
        PackageInfo packageInfo = mContext.getPackageManager().getPackageArchiveInfo(apkPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);

        if (packageInfo == null) {
            return;
        }

        DexClassLoader classLoader = createDexClassLoader(apkPath);
        AssetManager am = createAssetManager(apkPath);
        Resources resources = createResources(am);

        mPluginApk = new PluginApk(packageInfo, resources, classLoader);
    }


    private DexClassLoader createDexClassLoader(String apkPath) {

        File file = mContext.getDir("dex", Context.MODE_PRIVATE);

        return new DexClassLoader(apkPath, file.getAbsolutePath(),
                null, mContext.getClassLoader());
    }

    private AssetManager createAssetManager(String apkPath) {

        AssetManager am = null;
        try {
            am = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.invoke(am, apkPath);
            return am;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return am;
    }


    private Resources createResources(AssetManager am) {
        Resources res = mContext.getResources();

        return new Resources(am, res.getDisplayMetrics(), res.getConfiguration());
    }


    public PluginApk getmPluginApk() {
        return mPluginApk;
    }
}
