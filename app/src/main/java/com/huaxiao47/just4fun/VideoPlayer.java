//package com.huaxiao47.just4fun;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.media.AudioManager;
//import android.util.AttributeSet;
//import android.view.Gravity;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.widget.FrameLayout;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.Map;
//
//import tv.danmaku.ijk.media.player.IMediaPlayer;
//
//public class VideoPlayer extends FrameLayout {
//
//    private IMediaPlayer mediaPlayer;
//
//    private String url;
//
//    private Map<String,String> mHeader;
//
//    private SurfaceView mSurfaceView;
//
//    private AudioManager mAudioManager;
//
//    private Context mContext;
//    public VideoPlayer(@NonNull Context context) {
//        super(context);
//    }
//
//    public VideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public VideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public VideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        init(context);
//    }
//
//    private void init(Context context) {
//        mContext = context;
//        setBackgroundColor(Color.BLACK);
//        createSurfaceView();
//        mAudioManager = (AudioManager)mContext.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
//        mAudioFocusHelper = new AudioFocusHelper();
//    }
//
//
//    //创建surfaceView
//    private void createSurfaceView() {
//        mSurfaceView = new SurfaceView(mContext);
//        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder surfaceHolder) {
//
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
//                if (mMediaPlayer != null) {
//                    mMediaPlayer.setDisplay(surfaceHolder);
//                }
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
//
//            }
//        });
//        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT
//                , LayoutParams.MATCH_PARENT, Gravity.CENTER);
////        mSurfaceView.setLayoutParams(layoutParams);
//        addView(mSurfaceView,0,layoutParams);
//    }
//}
