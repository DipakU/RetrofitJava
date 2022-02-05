package com.example.retrofitjava.WebService;

import com.example.retrofitjava.Entity.GetDataEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("https://randomuser.me/api/?inc=gender,name,nat,location,picture,email&results=20")
    public
        // API's endpoints
    Call<GetDataEntity> createPost();
}
