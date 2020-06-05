package com.huaxiao47.just4fun.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.huaxiao47.just4fun.R;
import com.huaxiao47.videoplayer.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;


//内置ijkplayer 和 烈焰弹幕库
public class HVideoPlayer extends FrameLayout implements View.OnTouchListener {

    //横竖屏状态
    private boolean fullScreen;
    private Activity activity;
    private IjkVideoView mVideoView;
    private boolean canSwitch;

    public HVideoPlayer(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public HVideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public HVideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        initView(context);

    }



    private void initView(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.hx_videoplayer_layout, null);

        mVideoView = v.findViewById(R.id.video_view);
        mVideoView.setOnPreparedListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                mVideoView.setBackground(getResources().getDrawable(R.color.black_overlay,null));
            }
        });
        mVideoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                mVideoView.setBackground(null);

            }
        });
        setOnTouchListener(this);
    }

    public HVideoPlayer setOrientationSwitch(boolean canSwitch,Activity activity){
        this.canSwitch = canSwitch;
        this.activity = activity;

        return this;
    }


    //全屏
    public void setFullScreen(boolean isFull){
        if (!canSwitch || activity == null) return;
        if (isFull){
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }


    public void showTopBar(boolean show){

    }

    public void showBottomBar(boolean show){

    }


    public void setVideoProgress(int i){

    }

    public void stop(){
       mVideoView.stopPlayback();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
//            case MotionEvent.
        }

        return false;
    }
}
