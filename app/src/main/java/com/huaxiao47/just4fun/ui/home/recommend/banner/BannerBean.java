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
       if (banners != null){
           banners = new ArrayList<>();
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/sycp/creative_img/202004/fdf8c91955f9eec641b3759cebcaed37.jpg@880w_388h_1c_95q","lla","sdf"));
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/sycp/creative_img/202004/fdf8c91955f9eec641b3759cebcaed37.jpg@880w_388h_1c_95q","lla","sdf"));
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/sycp/creative_img/202004/fdf8c91955f9eec641b3759cebcaed37.jpg@880w_388h_1c_95q","lla","sdf"));
           banners.add(new BannerBean("https://i0.hdslb.com/bfs/sycp/creative_img/202004/fdf8c91955f9eec641b3759cebcaed37.jpg@880w_388h_1c_95q","lla","sdf"));

       }


       return banners;

    }

}
