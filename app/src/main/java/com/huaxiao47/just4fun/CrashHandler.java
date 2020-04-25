package com.huaxiao47.just4fun;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private Context mContext;

    private static CrashHandler INSTANCE = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context ctx) {
        mContext = ctx;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull final Throwable e) {
        Log.d(TAG, "uncaughtException: "+e.getMessage());
        new Thread(new Runnable() {
            @Override
            public void run() {
//                Looper.prepare();
//                new AlertDialog.Builder(mContext).setTitle("提示")
//                        .setCancelable(false).setMessage("Error...\n" + e.toString())
//                        .setNeutralButton("I know",new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//                                e.printStackTrace();
//                                System.exit(0);
//                            }
//                        }).create().show();
//
//                Looper.loop();
            }
        }).start();
    }
}
