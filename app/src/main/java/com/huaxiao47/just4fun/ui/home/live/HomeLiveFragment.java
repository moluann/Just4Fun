package com.huaxiao47.just4fun.ui.home.live;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huaxiao47.just4fun.R;

public class HomeLiveFragment extends Fragment {

    private HomeLiveViewModel mViewModel;

    public static HomeLiveFragment newInstance() {
        return new HomeLiveFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_live_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeLiveViewModel.class);
        // TODO: Use the ViewModel


    }

}
