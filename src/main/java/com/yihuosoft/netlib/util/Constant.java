package com.yihuosoft.netlib.util;

import androidx.annotation.StringDef;

public  class Constant {
    public static final String TOKEN_KEY_CONSTANT="TOKEN_KEY";
    public static final String REFRESH_TOKEN_KEY_CONSTANT="REFRESH_TOKEN_KEY";

    public static final String TOKEN_KEY_URL="/auth/oauth2/token";

    @StringDef({SEND_TYPE_LOGIN, SEND_TYPE_CHANGE_PASSWORD, SEND_TYPE_ACTIVATE, SEND_TYPE_CHANGE_PHONE, SEND_TYPE_BIND_PHONE, SEND_TYPE_DELETE_ACCOUNT,SEND_CHANNEL_TYPE_EMAIL,SEND_CHANNEL_TYPE_TENCENT_SMS})
    public @interface SendType {
    }


    @StringDef({LOGIN_TYPE_PASSWORD, LOGIN_TYPE_CODE})
    public @interface LoginType {
    }

    public static final String LOGIN_TYPE_PASSWORD = "LOGIN_TYPE_PASSWORD"; //密码登录方式
    public static final String LOGIN_TYPE_CODE = "LOGIN_TYPE_CODE";         //验证码登录方式

    public static final String SEND_CHANNEL_TYPE_EMAIL = "EMAIL";
    public static final String SEND_CHANNEL_TYPE_TENCENT_SMS = "TENCENT_SMS";
    public static final String SEND_TYPE_LOGIN = "login";
    public static final String SEND_TYPE_CHANGE_PASSWORD = "changePw";
    public static final String SEND_TYPE_ACTIVATE = "activate";
    public static final String SEND_TYPE_CHANGE_PHONE = "changePhone";
    public static final String SEND_TYPE_BIND_PHONE = "bindPhone";
    public static final String SEND_TYPE_DELETE_ACCOUNT = "deleteUser";


}
