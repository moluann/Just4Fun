cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_STANDARD 11)

#下面的opencv路径改成自己本地的路径
set(OpenCV_DIR E:/clib/OpenCV-android-sdk/sdk/native/jni)


find_package(OpenCV REQUIRED)
include_directories(${OpenCV_DIR}/include)




add_library(
        native-lib
        SHARED
        native-lib.cpp
)

target_link_libraries(native-lib
        ${OpenCV_LIBS}
        # included in the NDK.
        jnigraphics

        android
        log)