package com.huaxiao47.just4fun.ui.home.recommend.item;

import java.util.ArrayList;
import java.util.List;

public class ItemBean {
    public String imgUrl;
    public String description;

    public ItemBean(String imgUrl, String description) {
        this.imgUrl = imgUrl;
        this.description = description;
    }

    public static List<ItemBean> getTestData(){
        List<ItemBean> items = new ArrayList<>();
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        items.add(new ItemBean("https://i0.hdslb.com/bfs/archive/6c472210a2f0f3be44ba4428dd40037d1a0d70a2.jpg@412w_232h_1c_100q.jpg","test111111"));
        return items;
    }
}
