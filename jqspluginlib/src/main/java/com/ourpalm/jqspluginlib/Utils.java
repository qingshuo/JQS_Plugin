package com.ourpalm.jqspluginlib;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：liqingshuo on 2019-05-08 21:54
 *
 * @author liqingshuo
 */
public class Utils {

    public static String copyAssetsAndWrite(Context context, String fileName) {

        try {


            File cacheDir = context.getCacheDir();
            if (!cacheDir.exists()) {
                cacheDir.exists();
            }

            File outFile = new File(cacheDir, fileName);
            if (!outFile.exists()) {
                boolean res = outFile.createNewFile();
                if (res) {
                    InputStream is = context.getAssets().open(fileName);
                    FileOutputStream fos = new FileOutputStream(outFile);
                    byte[] buffer = new byte[is.available()];

                    int byteCount;
                    while ((byteCount = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, byteCount);
                    }


                    fos.flush();
                    is.close();
                    fos.close();
                    System.out.println("utils >>> 文件拷贝成功  ");
                    return outFile.getAbsolutePath();
                } else {
                    System.out.println("utils >>> 文件已经存在  ");
                    return outFile.getAbsolutePath();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
