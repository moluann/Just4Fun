//
// Created by admin on 2020/4/21.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_huaxiao47_videoplayer_Test_stringFromjni(JNIEnv *env,jobject thiz){

    std::string h = "cao si ni ge da zui";
    return env->NewStringUTF(h.c_str());
}