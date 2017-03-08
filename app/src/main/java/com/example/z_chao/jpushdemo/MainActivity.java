package com.example.z_chao.jpushdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBt_aaa;
    private Button mBt_bbb;
    private Button mBt_ccc;
    private Button mBt_ddd;
    private Retrofit mRetrofit;
    private API mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mBt_aaa = (Button) findViewById(R.id.bt_aaa);
        mBt_bbb = (Button) findViewById(R.id.bt_bbb);
        mBt_ccc = (Button) findViewById(R.id.bt_ccc);
        mBt_ddd = (Button) findViewById(R.id.bt_ddd);
        mBt_aaa.setOnClickListener(this);
        mBt_bbb.setOnClickListener(this);
        mBt_ccc.setOnClickListener(this);
        mBt_ddd.setOnClickListener(this);
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.jpush.cn/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = mRetrofit.create(API.class);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_aaa:
                String aaa = "534e77ce620ce2ee9310f18a:masterSecret";
                String aaa64 = new String(Base64.encode(aaa.getBytes(), Base64.DEFAULT));
                Log.i("zc", "initView:   加密后的东西" + aaa64);
                Log.i("zc", "onClick:   走了 我是管理员, 我要推送给用户");

                Gson gson = new Gson();
                List<String> tag = new ArrayList<>();
                tag.add("bbb");
                PushBean pushBean = new PushBean("android",new PushBean.AudienceBean(tag),new PushBean.NotificationBean("管理员推送给用户的同志"));
                String s = gson.toJson(pushBean);
                Log.i("zc", "onClick:  将bean 转换为 string" + s);
                Call<String> push = mApi.push( s);
                push.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                        if (response.body() != null) {
                            Log.i("zc", "onResponse:     看看是什么消息" + response.message());
                        } else {
                            Log.i("zc", "onResponse: 请求到的数据为空" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.i("zc", "onResponse: " + t);
                    }
                });
                break;
            case R.id.bt_bbb:
                //变成用户的标签
                Log.i("zc", "onClick:   走了 我是用户,我要推送给用户的用户");
                break;
            case R.id.bt_ccc:
                //设置标签为用户
                Log.i("zc", "onClick:   走了 我是用户");
                Set<String> tags = new HashSet<>();
                tags.add("bbb");
                setTag(tags);
                break;
            case R.id.bt_ddd:
                //设置标签为 用户的用户
                Log.i("zc", "onClick:   走了 我是用户的用户");
                Set<String> tag1 = new HashSet<>();
                tag1.add("ddd");
                setTag(tag1);
                break;
        }
    }

    private void setTag(Set<String> tags) {
        JPushInterface.setTags(this, tags, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                if (i == 0) {
                    Log.i("zc", "gotResult:    设置标签成功"  + i  +  set.size());
                } else {
                    Log.i("zc", "gotResult:    设置标签失败 ------" + i);
                }
            }
        });
    }

}
