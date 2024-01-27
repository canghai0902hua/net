package com.yihuosoft.netlib.http;

import android.content.Context;

import com.yihuosoft.netlib.BuildConfig;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager  {
    public volatile static HttpManager httpManager;
    private ApiService apiService;
    private Context context;
    private HttpManager() {
        if (apiService == null) {
            apiService = create(ApiService.class);
        }
    }


    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

    public static HttpManager getInstance() {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }

    private OkHttpClient okHttpClient = new OkHttpClient.Builder().
            connectTimeout(30, TimeUnit.SECONDS).
            readTimeout(30, TimeUnit.SECONDS).
            writeTimeout(30, TimeUnit.SECONDS).
            addInterceptor(new TokenInterceptor()).                                                                    //刷新token拦截器
                    addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).          //绑定日志拦截器
                    build();

    private Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();

}
