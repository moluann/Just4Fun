package com.huaxiao47.just4fun.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.huaxiao47.just4fun.ui.home.live.HomeLiveFragment;
import com.huaxiao47.just4fun.ui.home.recommend.HomeRecommendFragment;

public class HomePageAdapter extends FragmentPagerAdapter {

    private final String[] titles;
    private Fragment[] fragments;

    public HomePageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        titles = new String[]{"直播","推荐","热门","追番","影视","抗击肺炎","学习"};
        fragments = new Fragment[titles.length];
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragments[position] = HomeLiveFragment.newInstance();
                break;
            case 1:
                fragments[position] = HomeRecommendFragment.newInstance();
                break;
            case 2:
                fragments[position] = HomeRecommendFragment.newInstance();
                break;
            case 3:
                fragments[position] = HomeRecommendFragment.newInstance();
                break;
            case 4:
                fragments[position] = HomeRecommendFragment.newInstance();
                break;
            case 5:
                fragments[position] = HomeRecommendFragment.newInstance();
                break;
            case 6:
                fragments[position] = HomeRecommendFragment.newInstance();
                break;
        }

        return fragments[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
