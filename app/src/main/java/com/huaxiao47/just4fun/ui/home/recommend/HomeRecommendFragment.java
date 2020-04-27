package com.huaxiao47.just4fun.ui.home.recommend;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huaxiao47.just4fun.R;


//推荐主界面
public class HomeRecommendFragment extends Fragment {
    private static final String TAG ="HomeRecommendFragment";
    private HomeRecommendViewModel mViewModel;
    private SwipeRefreshLayout mRefreshLayout;
    private RecommendRecyclerViewAdapter adapter;
    private RecyclerView mRecyclerView;
    private Context mContext;
    public static HomeRecommendFragment newInstance() {
        return new HomeRecommendFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_recommend_fragment, container, false);

        mRefreshLayout = root.findViewById(R.id.swipe_refresh);
        mRecyclerView = root.findViewById(R.id.recycler_view);
        initRefreshLayout();
        initRecyclerView();


        return root;


    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources( R.color.materialBlue,
                R.color.colorAccent,
                R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    private void initRecyclerView() {

        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position ==0)
                    return 2;
                return 1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(10));
        adapter = new RecommendRecyclerViewAdapter();
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeRecommendViewModel.class);

    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.getInfos().observe(this, new Observer<RecommendInfo>() {
            @Override
            public void onChanged(RecommendInfo recommendInfo) {
                adapter.setNewData(recommendInfo);
                Log.d(TAG, "onChanged: "+recommendInfo.items.size());
            }
        });


        mViewModel.loadData();

    }


    class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }


}
