package com.huaxiao47.just4fun.ui.paly;

import androidx.lifecycle.ViewModelProviders;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;


import com.google.android.material.tabs.TabLayout;
import com.huaxiao47.just4fun.R;
import com.huaxiao47.videoplayer.media.IRenderView;
import com.huaxiao47.videoplayer.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayFragment extends Fragment {

    private PlayViewModel mViewModel;
    private IjkVideoView mVideoView;
    public static PlayFragment newInstance() {
        return new PlayFragment();
    }

    private String url5 = "http://220.189.192.24/youku/697437f8d3b4e720643d13669/03000801005EA00BB196D40003E88064AA5DA1-437C-48A8-8689-AA66964823D6.mp4?sid=158797445900010009398_00_B65e61a3b68604369f754ecb8afe312b4&sign=cc812c95401294a1e292274763313551&ctype=50&ali_redirect_domain=vali.cp31.ott.cibntv.net&ali_redirect_ex_ftag=50d0498af4c78ca6cdf2d270dd75ad7c479cf7c771150f2c&ali_redirect_ex_tmining_ts=1587974461&ali_redirect_ex_tmining_expire=3600&ali_redirect_ex_hot=11";
    private String url = "http://115.231.155.220/youku/6975c328925317143130048b5/03000801005EA0473B78D1B189768922B4893B-AACE-4251-B7F3-32EE376C0517.mp4?sid=158797445900010001133_00_B0a3f9b85261bc09d7907e9b4602f57ac&sign=9a0f560f14442d5a7e06c3eafccdeda1&ctype=50&ali_redirect_domain=vali.cp31.ott.cibntv.net&ali_redirect_ex_ftag=1d087432308c70cf62994f7908e3a0f4462b4d3254e82ef3&ali_redirect_ex_tmining_ts=1587974461&ali_redirect_ex_tmining_expire=3600&ali_redirect_ex_hot=11";
    private String url1 = "https://js.wshls.acgvideo.com/live-js/331934/live_7734200_bs_1348183.m3u8?wsSecret=a60410a763cb0ff1fda253f3325b158a&wsTime=1587978207&trid=80352d2e6385412a9e49d343b2526f77&pt=h5&oi=2061746964&order=0&sig=no";
    private String url2 = "http://oss.zhiyun-tech.com/zyplay/sitelayout/84896/2019-08-09-18:05:05.mp4";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.play_fragment, container, false);
        IjkVideoView mVideoView = root.findViewById(R.id.video_view);
        mVideoView.setAspectRatio(IRenderView.AR_ASPECT_WRAP_CONTENT);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mVideoView.getBufferPercentage();
        mVideoView.setVideoURI(Uri.parse(url2));
        Button stopBtn = root.findViewById(R.id.stop);
        View layout = (LinearLayout) inflater.inflate(R.layout.tablelayout_xxx, null);
        TableLayout table = layout.findViewById(R.id.table_layout);
        mVideoView.setHudView(table);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mVideoView.isPlaying()){
                   mVideoView.pause();
               }else {
                   mVideoView.start();
               }


            }
        });
        mVideoView.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {



                return false;
            }
        });
        mVideoView.start();
        mVideoView.showMediaInfo();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlayViewModel.class);
        // TODO: Use the ViewModel

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }
}
