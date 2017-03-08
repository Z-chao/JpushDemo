package com.example.z_chao.jpushdemo;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by Z-chao on 2017/3/8 22:54
 */

public interface API {
    @Headers({
            "Content-Type: application/json",
            "Authorization: Basic NTM0ZTc3Y2U2MjBjZTJlZTkzMTBmMThhOm1hc3RlclNlY3JldA=="
    })

    @POST("push")
    Call<String> push(@Body String push);

}
