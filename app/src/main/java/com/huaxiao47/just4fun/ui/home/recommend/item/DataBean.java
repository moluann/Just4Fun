package com.huaxiao47.just4fun.ui.home.recommend.item;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    public String imgUrl;

    public DataBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static List<DataBean> getTestData(){
        ArrayList<DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg"));
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg"));
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg"));
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg"));
        return dataBeans;
    }
}
