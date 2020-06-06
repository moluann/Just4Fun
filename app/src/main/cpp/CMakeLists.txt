cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_STANDARD 11)

#下面的opencv路径改成自己本地的路径
set(OpenCV_DIR /home/huaxiao/OpenCV-android-sdk/sdk/native/jni)


find_package(OpenCV REQUIRED)
include_directories(${OpenCV_DIR}/include )





add_library(
        native-lib
        SHARED
        native-lib.cpp
        tldTracker.cpp
        tldModel.cpp
        tldUtils.cpp
        tracker.cpp
        tldEnsembleClassifier.cpp
        feature.cpp
        tldDataset.cpp
        trackerFeature.cpp
        trackerFeatureSet.cpp
        trackerMedianFlow.cpp
        tracking_utils.cpp
        tldDetector.cpp
        trackerSampler.cpp
        trackerModel.cpp
        trackerSamplerAlgorithm.cpp
        trackerStateEstimator.cpp
        onlineBoosting.cpp
        onlineMIL.cpp
)

target_link_libraries(native-lib
        ${OpenCV_LIBS}
        # included in the NDK.
        jnigraphics

        android
        log)