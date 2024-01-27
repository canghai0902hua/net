package com.yihuosoft.netlib.http;

import androidx.annotation.NonNull;

import com.yihuosoft.netlib.BuildConfig;
import com.yihuosoft.netlib.util.Constant;
import com.yihuosoft.netlib.bean.TokenModel;
import com.yihuosoft.netlib.util.ShareUtils;
import com.yihuosoft.netlib.util.ToolUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    private static final String TAG = "TokenInterceptor";

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response;
        Request.Builder builder = request.newBuilder();
        if (request.url().encodedPath().startsWith("/auth/")) {
            String host = BuildConfig.HOST.replace("api", "auth").split("//")[1];
            HttpUrl newFullUrl = request.url()
                    .newBuilder()
                    .host(host)//更换主机名
                    .encodedPath(request.url().encodedPath().replace("/auth/","/"))
                    .build();
            response = chain.proceed(builder.url(newFullUrl).build());
        }else{
            response = chain.proceed(request);
        }
        for (String name : request.headers().names()) {
            if (name.contains("Authorization")) {
                builder.removeHeader("Authorization");
                builder.header("Authorization", ShareUtils.getString(Constant.TOKEN_KEY_CONSTANT, "")).build();
                break;
            }
        }
        //判断token过期
//        if (isTokenExpired(response)) {
//            //同步请求方获取最新的Token
//            getNewToken();
//            //使用新的Token，创建新的请求
//            builder.removeHeader("Authorization");
//            Request newRequest = builder.header("Authorization", ShareUtils.getString(Constant.TOKEN_KEY_CONSTANT, "")).build();
//            //重新请求
//            response.close();
//            return chain.proceed(newRequest);
//        }
        return response;
    }


    /**
     * 根据Response，判断Token是否失效
     *
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        if (response.code() == 401) {
            return true;
        }
        return false;
    }

    /**
     * 同步请求方式，获取最新的Token
     *
     * @return
     */
    public static synchronized void getNewToken() {
        Request request = new Request.Builder()
                .url(ToolUtils.getHost(Constant.TOKEN_KEY_URL))
                .post(ToolUtils.getRefreshBody())
                .build();
        Call call = new OkHttpClient().newCall(request);//301失效
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                TokenModel tokenModel = ToolUtils.toObject(response.body().string(), TokenModel.class);
                if (0 != tokenModel.getCode()) {
//                    Log.e(TAG, ShareUtils.getString(Constact.REFRESH_TOKEN_KEY,""));
//                    ShareUtils.deleShare(BaseApplication.getContext(),Constact.REFRESH_TOKEN_KEY);
//                    ShareUtils.deleShare(BaseApplication.getContext(),Constact.TOKEN_KEY);
//                    Intent intent = new Intent(ACTION_LOGIN_TIMEOUT);
//                    LocalBroadcastManager.getInstance(BaseApplication.getContext()).sendBroadcast(intent);
                } else {
//                    if(!TextUtils.isEmpty(tokenModel.getData().getAccess_token())){
//                        ShareUtils.putString(Constact.TOKEN_KEY,"Bearer "+tokenModel.getData().getAccess_token());
//                    }
//                    if (!TextUtils.isEmpty(tokenModel.getData().getRefresh_token())){
//                        ShareUtils.putString(Constact.REFRESH_TOKEN_KEY, tokenModel.getData().getRefresh_token());
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
