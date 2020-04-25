package com.huaxiao47.videoplayer;

public class Test {

    static {
        System.loadLibrary("native-lib");
    }

    public native static String stringFromjni();
}
