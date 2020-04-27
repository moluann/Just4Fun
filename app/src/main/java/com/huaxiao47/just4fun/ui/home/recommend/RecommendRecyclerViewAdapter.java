package com.huaxiao47.just4fun.ui.home.recommend;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huaxiao47.just4fun.R;
import com.huaxiao47.just4fun.ui.home.recommend.banner.BannerBean;
import com.huaxiao47.just4fun.ui.home.recommend.banner.RecommendBannerAdapter;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;


import static com.huaxiao47.just4fun.ui.home.recommend.banner.RecommendBannerAdapter.TAG;


public class RecommendRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NO_DATA = -1;
    private static final int BANNER = 0;
    private static final int ITEM = 1;
    private static final int LOADMORE = 2;
    private static final int FOOTER = 3;
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
            case BANNER :
                View bannerLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_banner,parent,false);
                adapter = new RecommendBannerAdapter(BannerBean.getTestData());
                Banner<BannerBean, RecommendBannerAdapter> banner = (Banner<BannerBean, RecommendBannerAdapter>) bannerLayout.findViewById(R.id.banner_view);
//                banner.setAdapter(adapter);
                Log.d(TAG, "onCreateViewHolder: ");

//                Banner<BannerBean,RecommendBannerAdapter> banner = new Banner<>(parent.getContext());
                banner.setAdapter(adapter);
                banner.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) BannerUtils.dp2px(200)));
                banner.setBannerRound(BannerUtils.dp2px(10));
                banner.setIndicator(new CircleIndicator(parent.getContext()));
                banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
                banner.isAutoLoop(true);
                banner.setIndicatorWidth(10,10);
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object data, int position) {
                        Toast.makeText(parent.getContext(),"点击"+position,Toast.LENGTH_LONG).show();

                    }
                });
                banner.start();
                return new BannerViewHolder(banner);

            case ITEM:
//                GridLayoutManager manager = new GridLayoutManager(parent.getContext(),2);
//                ((RecyclerView) parent).setLayoutManager(manager);
                View itemLayout = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recommend_item, parent, false);



                return new ItemViewHolder(itemLayout);
        }

        return new EmptyViewHolder(parent);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder){


//            adapter.setDatas(BannerBean.getTestData());
        }else if (holder instanceof ItemViewHolder){
            ItemViewHolder itemHolder = (ItemViewHolder) holder;
            Glide.with(itemHolder.img.getContext()).load(info.items.get(position-1).imgUrl).into(itemHolder.img);
            itemHolder.text.setText(info.items.get(position-1).description);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

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
            return 1+info.items.size();
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

    class ItemViewHolder extends RecyclerView.ViewHolder{
        final ImageView img;
        final TextView text;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.recommend_item_img);
            text = itemView.findViewById(R.id.item_description);
        }
    }




}
