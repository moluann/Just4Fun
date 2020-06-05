package com.huaxiao47.just4fun.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;

public class HxUtil {




    /**
     * 检查是否有网络
     */
    public static boolean isNetworkAvailable(@NonNull Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return info != null && info.isAvailable();
    }

    private static NetworkInfo getNetworkInfo(@NonNull Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == cm)return null;
        return cm.getActiveNetworkInfo();
    }


}
