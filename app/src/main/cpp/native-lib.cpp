//
// Created by admin on 2020/6/4.
//


#include <jni.h>
#include <string>

#include "opencv2/opencv.hpp"
#include "precomp.hpp"
#include "tldTracker.hpp"
#include "tracker.hpp"


extern "C"
JNIEXPORT jstring JNICALL
Java_com_huaxiao47_just4fun_MainActivity_stringFromjni(JNIEnv *env, jclass clazz) {
    std::string h= cv::getVersionString();


//    cv::Ptr<cv::Tracker> tracker = cv::TrackerTLD::create();



    return env->NewStringUTF(h.c_str());
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_huaxiao47_just4fun_MainActivity_createTld(JNIEnv *env, jclass clazz) {
    std::string h= cv::getVersionString();


    cv::Ptr<cv::Tracker> tracker = cv::TrackerTLD::create();


    return env->NewStringUTF("ok");


}

//extern "C"
//JNIEXPORT jstring JNICALL



