package com.yihuosoft.netlib.http;


import com.yihuosoft.netlib.bean.BaseResponse;
import com.yihuosoft.netlib.bean.LoginAccount;
import com.yihuosoft.netlib.bean.Registered;
import com.yihuosoft.netlib.bean.TokenModel;
import com.yihuosoft.netlib.bean.UploadRealAddress;
import com.yihuosoft.netlib.bean.UserInfo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    @POST("/auth/oauth2/token")
    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Observable<BaseResponse<TokenModel.Result>> getToken(@FieldMap Map<String,String> map);


    //发送验证码
    @POST("/captcha/verification-code/send")
    @Headers({"Content-Type:application/json"})
    Observable<BaseResponse<BaseResponse>> sendMessage(@Body RequestBody requestBody);


    @POST("/captcha/verification-code/verify")
    @FormUrlEncoded
    @Headers({"Content-Type: application/json;UTF-8","Authorization:''"})
    Observable<BaseResponse<String>> verifyMessageCode(@FieldMap Map<String, String> map);

    //检查当前登录手机号是否已经注册过，返回true则表示已注册。手机号注册第一步调用接口
    @POST("/auth/accounts/check")
    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Observable<BaseResponse<Registered.Result>> accountCheck(@Field("username") String userName);



    @GET("/auth/my-accounts")
    @Headers({"Authorization:''"})
    Observable<BaseResponse<LoginAccount.Result>> getAccountInfo();


    @GET("/platform/my-profile")
    @Headers({"Authorization:''"})
    Observable<BaseResponse<UserInfo.Result>> getUserInfo();


    //预上传头像接口,拿真实的上传图片的地址
    @POST("/storage/fileStorage/preUpload")
    Observable<BaseResponse<UploadRealAddress.Result>> preUpload(@Body RequestBody body);

    //保存文件到cz-storage接口
    @POST("/storage/fileStorage/saveReturnId?isNamed=0&existFileId=0")
    Observable<BaseResponse<String>> fileStorage(@Body RequestBody body);

    //上传文件
    @PUT
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody file);



}
