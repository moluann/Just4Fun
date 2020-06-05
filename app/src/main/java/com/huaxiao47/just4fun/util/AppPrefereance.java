package com.huaxiao47.just4fun.util;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefereance {


    //存储布尔值
    public static void saveBoolean(Context context, String stringKey, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(stringKey, value);
        editor.apply();
    }

    //获取布尔值
    public static boolean getBoolean(Context context, String stringKey,boolean defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        if (null != preferences) {
            return preferences.getBoolean(stringKey, defaultValue);
        } else {
            return false;
        }
    }


}
