package com.example.z_chao.jpushdemo;

import com.google.gson.Gson;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by Z-chao on 2017/3/8 22:54
 */

public interface API {
    @Headers(
            "Content-Type: application/json"
            //"Authorization: Basic NTM0ZTc3Y2U2MjBjZTJlZTkzMTBmMThhOjM3NzZmMWMxMTQ4MjkxMjgxYmZiZDBkOA=="
    )
    @POST("v3/push")
    Call<String> push(@Header("Authorization") String authorization,@Body PushBean push);

}
