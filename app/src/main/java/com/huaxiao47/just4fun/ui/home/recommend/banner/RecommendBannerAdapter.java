package com.huaxiao47.just4fun.ui.home.recommend.banner;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huaxiao47.just4fun.R;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class RecommendBannerAdapter extends BannerAdapter<BannerBean, RecommendBannerAdapter.BannerViewHolder> {
    public static final String TAG = "RecommendBannerAdapter";
    public RecommendBannerAdapter(List<BannerBean> datas) {
        super(datas);
    }

    @Override
    public RecommendBannerAdapter.BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item, parent, false);
        Log.d(TAG, "onCreateHolder: ");
        return new BannerViewHolder(layout);
    }

    @Override
    public void onBindView(RecommendBannerAdapter.BannerViewHolder holder, BannerBean data, int position, int size) {
        Glide.with(holder.imageView.getContext()).load(data.imgUrl).into(holder.imageView);
//        holder.imageView.setImageURI(Uri.parse(data.imgUrl));
        holder.textView.setText(data.title);
        Log.d(TAG, "onBindView: ");
    }


    class BannerViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView textView;

        public BannerViewHolder(@NonNull View  itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.banner_img);
            textView = itemView.findViewById(R.id.banner_title);
        }
    }




}
