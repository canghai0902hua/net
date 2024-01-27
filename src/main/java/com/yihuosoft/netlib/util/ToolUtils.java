package com.yihuosoft.netlib.util;


import com.google.gson.Gson;
import com.yihuosoft.netlib.BuildConfig;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class ToolUtils {
    public static String getHost(String mMethod){
        String host= BuildConfig.HOST+mMethod;
        if(mMethod.startsWith("/auth/")){
            host=BuildConfig.HOST.replace("api","auth")+mMethod;
        }
        return host;
    }

    public static RequestBody getRefreshBody(){
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("client_id", "niuess");
        builder.add("grant_type", "refresh_token");
        builder.add("scope", "address phone openid email profile");
        builder.add("refresh_token",ShareUtils.getString(Constant.REFRESH_TOKEN_KEY_CONSTANT,""));
        RequestBody body = builder.build();
        return body;
    }

    //对象转字符串
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }


    /**
     * 解析JsonObject数据
     *
     * @param jsonString Json格式字符串
     * @param cls        封装类
     */
    public static <T> T toObject(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = new Gson().fromJson(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


}
