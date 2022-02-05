package com.example.retrofitjava.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.retrofitjava.Entity.GetDataEntity;
import com.example.retrofitjava.R;
import com.example.retrofitjava.databinding.FragmentViewPagerBinding;

public class FragmentView extends Fragment {
    private static GetDataEntity.Results data_results;
    private FragmentViewPagerBinding fragmentViewPagerBinding;

    public static Fragment newInstance(int position, int white, GetDataEntity.Results results) {
        FragmentView f = new FragmentView();
        data_results = results;
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentViewPagerBinding = FragmentViewPagerBinding.inflate(inflater, container, false);
        View view = fragmentViewPagerBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UIComponent(getView());
    }

    private void UIComponent(View view) {
        Glide.with(getActivity())
                .load(data_results.getPicture().getMedium())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(fragmentViewPagerBinding.imageProfile);
        fragmentViewPagerBinding.tvName.setText(data_results.getName().getFirst() + " " + data_results.getName().getFirst() + " " + data_results.getName().getLast());
        fragmentViewPagerBinding.tvAddress.setText(data_results.getLocation().getStreet().getNumber().toString() + "," + data_results.getLocation().getStreet().getName() +
                "," + data_results.getLocation().getCity() + "," + data_results.getLocation().getState() + "," + data_results.getLocation().getCountry() + "," + data_results.getLocation().getPostcode() + ",");
        fragmentViewPagerBinding.tvGender.setText(data_results.getGender());
    }
}
