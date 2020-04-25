package com.huaxiao47.just4fun.ui.home.recommend;

import android.util.Log;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huaxiao47.just4fun.ui.home.recommend.banner.BannerBean;
import com.huaxiao47.just4fun.ui.home.recommend.banner.RecommendBannerAdapter;
import com.youth.banner.Banner;


import static com.huaxiao47.just4fun.ui.home.recommend.banner.RecommendBannerAdapter.TAG;


public class RecommendRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NO_DATA = -1;
    private static final int BANNER = 0;
    private static final int ITEM = 1;

    private RecommendBannerAdapter adapter;
    private RecommendInfo info;

    public RecommendRecyclerViewAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case NO_DATA:
                return new EmptyViewHolder(parent);
            default :
//                View bannerLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_banner, parent, false);
                adapter = new RecommendBannerAdapter(BannerBean.getTestData());
//                Banner<BannerBean, RecommendBannerAdapter> banner = (Banner<BannerBean, RecommendBannerAdapter>) bannerLayout.findViewById(R.id.banner_view);
//                banner.setAdapter(adapter);
                Log.d(TAG, "onCreateViewHolder: ");
                Banner<BannerBean,RecommendBannerAdapter> banner = new Banner<>(parent.getContext());
                banner.setAdapter(adapter);
                return new BannerViewHolder(banner);

        }




    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder){


            adapter.setDatas(BannerBean.getTestData());
        }


    }



    @Override
    public int getItemViewType(int position) {
        if (info == null)return NO_DATA;

        switch (position){
            case 0:
                return BANNER;
             default:
                 return ITEM;
        }

    }

    @Override
    public int getItemCount() {
        if (info == null)
            return 0;
        else
            return 1;
    }

    public void setNewData(RecommendInfo info) {
        this.info = info;
        notifyDataSetChanged();
        if (adapter != null){
            adapter.setDatas(info.banners);
            adapter.notifyDataSetChanged();
        }
    }


    class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{
       final Banner<BannerBean,RecommendBannerAdapter> banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = (Banner<BannerBean, RecommendBannerAdapter>) itemView;
        }
    }




}
