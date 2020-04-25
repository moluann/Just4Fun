package com.huaxiao47.just4fun.ui.home.recommend;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.huaxiao47.just4fun.ui.home.recommend.banner.BannerBean;
import com.huaxiao47.just4fun.ui.home.recommend.item.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class HomeRecommendViewModel extends ViewModel {
    private MutableLiveData<RecommendInfo> infos = new MutableLiveData<>();


    public void loadData(){
        //假数据
        RecommendInfo recommendInfo = new RecommendInfo();

        List<BannerBean> banners = new ArrayList<>();

        recommendInfo.banners = BannerBean.getTestData();
        recommendInfo.items = ItemBean.getTestData();

        infos.setValue(recommendInfo);
    }

    public MutableLiveData<RecommendInfo> getInfos() {
        return infos;
    }

    @Override
    protected void onCleared() {
        super.onCleared();


    }
}
