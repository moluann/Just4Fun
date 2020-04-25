package com.huaxiao47.just4fun.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.huaxiao47.just4fun.MainActivity;
import com.huaxiao47.just4fun.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private MainActivity activity;
    private TabLayout tab;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutCompat navLayout = root.findViewById(R.id.navigation_layout);
        tab = root.findViewById(R.id.home_tabs);
        viewPager = root.findViewById(R.id.home_view_pager);
        navLayout.setOnClickListener(v -> toggleDrawer());

        initViewPager();
        return root;
    }

    private void initViewPager() {
        viewPager.setAdapter(new HomePageAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        viewPager.setOffscreenPageLimit(7);
        tab.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }

    //打开抽屉
    private void toggleDrawer() {
        if (activity != null){
            activity.toggleDrawer();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }


}