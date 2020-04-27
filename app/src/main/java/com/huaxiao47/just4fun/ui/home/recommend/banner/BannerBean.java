package com.huaxiao47.just4fun.ui.home.recommend.banner;

import java.util.ArrayList;
import java.util.List;

public class BannerBean {
    public String imgUrl;
    public String title;
    public String gotoUrl;

    public BannerBean(String imgUrl, String title, String gotoUrl) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.gotoUrl = gotoUrl;
    }

    private static List<BannerBean> banners;

    public static List<BannerBean> getTestData(){
       if (banners == null){
           banners = new ArrayList<>();
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","lla","sdf"));
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","lla","sdf"));
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","lla","sdf"));
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","lla","sdf"));

       }


       return banners;

    }

}
