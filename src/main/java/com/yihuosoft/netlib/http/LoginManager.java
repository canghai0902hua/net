package com.yihuosoft.netlib.http;

import com.yihuosoft.netlib.bean.BaseResponse;
import com.yihuosoft.netlib.bean.LoginAccount;
import com.yihuosoft.netlib.bean.Registered;
import com.yihuosoft.netlib.bean.UserInfo;
import com.yihuosoft.netlib.util.Constant;
import com.yihuosoft.netlib.bean.TokenModel;
import com.yihuosoft.netlib.util.FormBodyUtil;
import com.yihuosoft.netlib.util.RequestBodyUtil;
import com.yihuosoft.netlib.util.ShareUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class LoginManager {

    public interface IRequestResult<T> {
        void success(T content);                            //成功返回的数据

        void failure(Throwable error, String content);      //http请求失败原因

        void errorReason(int code, String message);         //服务器请求失败
    }

    /**
     * @param loginType             登录方式，主要是指验证码登录还是密码登录
     * @param account               登录账号
     * @param codeOrPwd             登录的验证码或者密码
     * @param requestResultListener 请求回调
     */
    public static void login(@Constant.LoginType String loginType, String account, String codeOrPwd, IRequestResult<TokenModel.Result> requestResultListener) {
        Map<String, String> map = FormBodyUtil.tokenFormByPassword(account, codeOrPwd);
        if (loginType.equals(Constant.LOGIN_TYPE_CODE)) {
            map = FormBodyUtil.tokenFormBySms(account, codeOrPwd);
        }
        HttpManager.getInstance().create(ApiService.class).getToken(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<TokenModel.Result>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<TokenModel.Result> baseResponse) {
                        if (baseResponse.getCode() == 0) {
                            ShareUtils.putString(Constant.TOKEN_KEY_CONSTANT, "Bearer " + baseResponse.getData().getAccess_token());
                            ShareUtils.putString(Constant.REFRESH_TOKEN_KEY_CONSTANT, "Bearer " + baseResponse.getData().getRefresh_token());
                            requestResultListener.success(baseResponse.getData());
                        } else {
                            requestResultListener.errorReason(baseResponse.getCode(), baseResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ShareUtils.deleteShare(Constant.TOKEN_KEY_CONSTANT);
                        ShareUtils.deleteShare(Constant.REFRESH_TOKEN_KEY_CONSTANT);
                        requestResultListener.failure(e, e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    //发送短信
    public static void sendMessage(RequestBody requestBody, IRequestResult<BaseResponse> iRequestResult) {
        HttpManager.getInstance().create(ApiService.class).sendMessage(requestBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse response) {
                iRequestResult.success(response);
            }

            @Override
            public void onError(Throwable e) {
                iRequestResult.failure(e, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    public static void verifyMessageCode(Map<String, String> map, IRequestResult<String> iRequestResult) {
        HttpManager.getInstance().create(ApiService.class).verifyMessageCode(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<String> response) {
                if (response.getCode() == 0) {
                    iRequestResult.success(response.getData());
                } else {
                    iRequestResult.errorReason(response.getCode(), response.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                iRequestResult.failure(e, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    //检查当前登录手机号是否已经注册过，返回true则表示已注册
    public static void accountCheck(String userName, IRequestResult<Registered.Result> iRequestResult) {
        HttpManager.getInstance().create(ApiService.class).accountCheck(userName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse<Registered.Result>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<Registered.Result> response) {
                if (response.getCode() == 0) {
                    iRequestResult.success(response.getData());
                } else {
                    iRequestResult.errorReason(response.getCode(), response.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                iRequestResult.failure(e, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    //获取当前登录用户账号相关信息，比如手机号、微信号等
    public static void getAccountInfo(IRequestResult<LoginAccount.Result> iRequestResult) {
        HttpManager.getInstance().create(ApiService.class).getAccountInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse<LoginAccount.Result>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<LoginAccount.Result> response) {
                if (response.getCode() == 0) {
                    iRequestResult.success(response.getData());
                } else {
                    iRequestResult.errorReason(response.getCode(), response.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                iRequestResult.failure(e, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    public static void getUserInfo(IRequestResult<UserInfo.Result> iRequestResult) {
        HttpManager.getInstance().create(ApiService.class).getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse<UserInfo.Result>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<UserInfo.Result> response) {
                if (response.getCode() == 0) {
                    iRequestResult.success(response.getData());
                } else {
                    iRequestResult.errorReason(response.getCode(), response.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                iRequestResult.failure(e, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
