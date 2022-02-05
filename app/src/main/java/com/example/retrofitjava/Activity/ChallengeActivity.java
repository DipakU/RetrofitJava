package com.example.retrofitjava.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.retrofitjava.Adapter.RecycleListAdapter;
import com.example.retrofitjava.Adapter.ViewPagerAdapter;
import com.example.retrofitjava.Entity.GetDataEntity;
import com.example.retrofitjava.R;
import com.example.retrofitjava.WebService.Api;
import com.example.retrofitjava.databinding.ActivityChallengeBinding;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChallengeActivity extends AppCompatActivity implements View.OnClickListener, RecycleListAdapter.OnClickList {

    private Activity CurrentActivity = ChallengeActivity.this;
    private ActivityChallengeBinding activityChallengeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_challenge);
        activityChallengeBinding = ActivityChallengeBinding.inflate(getLayoutInflater());
        View view = activityChallengeBinding.getRoot();
        setContentView(view);
        UIComponent();
    }

    private void UIComponent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CurrentActivity);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        activityChallengeBinding.rvMainList.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager_h = new LinearLayoutManager(CurrentActivity);
        linearLayoutManager_h.setOrientation(RecyclerView.HORIZONTAL);
        activityChallengeBinding.imgNext.setOnClickListener(this);
        activityChallengeBinding.imgPrevious.setOnClickListener(this);
        activityChallengeBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        GetListData();
    }

    private void GetListData() {
        // display a progress dialog
        try {
            final ProgressDialog progressDialog = new ProgressDialog(CurrentActivity);
            progressDialog.setCancelable(false); // set cancelable to false
            progressDialog.setMessage("Please Wait"); // set message
            progressDialog.show(); // show progress dialog

            Api.getClient().createPost().enqueue(new Callback<GetDataEntity>() {
                @Override
                public void onResponse(Call<GetDataEntity> call, Response<GetDataEntity> response) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("responseGET", response.body().toString());
                            progressDialog.dismiss(); //dismiss progress dialog
                            //Gson gson = Smart.GetGSON();
                            Gson gson = new Gson();
                            //Gson customGson = new GsonBuilder().registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64Adapter()).create();
                            /*Gson customGson = new GsonBuilder().registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64Adapter()).create();
                            GetDataEntity getDataEntity = customGson.fromJson(response.body().toString(), GetDataEntity.class);*/
                            RecycleListAdapter recycleListAdapter = new RecycleListAdapter(CurrentActivity, response.body().getResults());
                            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), response.body().getResults());
                            activityChallengeBinding.rvMainList.setAdapter(recycleListAdapter);
                            activityChallengeBinding.viewPager.setAdapter(viewPagerAdapter);
                        }
                    });
                }

                @Override
                public void onFailure(Call<GetDataEntity> call, Throwable t) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(CurrentActivity, t.toString(), Toast.LENGTH_LONG).show();
                            progressDialog.dismiss(); //dismiss progress dialog
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_next:
                activityChallengeBinding.viewPager.setCurrentItem(activityChallengeBinding.viewPager.getCurrentItem() + 1);
                break;
            case R.id.img_previous:
                activityChallengeBinding.viewPager.setCurrentItem(activityChallengeBinding.viewPager.getCurrentItem() - 1);
                break;
        }
    }

    @Override
    public void OnClickList(GetDataEntity.Results results, int position) {
        activityChallengeBinding.viewPager.setCurrentItem(position);
    }
}