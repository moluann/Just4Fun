//
// Created by admin on 2020/6/4.
//


#include <jni.h>
#include <string>
#include "opencv2/opencv.hpp"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_huaxiao47_just4fun_MainActivity_stringFromjni(JNIEnv *env, jclass clazz) {
    std::string h= cv::getVersionString();
    return env->NewStringUTF(h.c_str());
}

