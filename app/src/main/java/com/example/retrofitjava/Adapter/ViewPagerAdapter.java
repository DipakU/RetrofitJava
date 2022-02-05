package com.example.retrofitjava.Adapter;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.retrofitjava.Entity.GetDataEntity;
import com.example.retrofitjava.Fragment.FragmentView;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<GetDataEntity.Results> arr_list_results;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, ArrayList<GetDataEntity.Results> results) {
        super(supportFragmentManager);
        this.arr_list_results = results;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FragmentView.newInstance(position, Color.WHITE, arr_list_results.get(position));
    }

    @Override
    public int getCount() {
        return arr_list_results.size();
    }
}
