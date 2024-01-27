package com.yihuosoft.netlib.util;


import java.util.HashMap;
import java.util.Map;

//表单数据提交参数实体类
public class FormBodyUtil {

    //手机、邮箱通过账号密码的形式登录的请求参数
    public static Map<String,String> tokenFormByPassword(String account,String pwd){
        Map<String,String> map=new HashMap<>();
        map.put("grant_type", "password");
        map.put("scope", "address phone openid email profile");
        map.put("username", account);
        map.put("password", pwd);
        map.put("type", "basic");
        map.put("client_id", "niuess");
        return map;
    }
    //手机、邮箱验证码的形式登录的请求参数
    public static Map<String,String> tokenFormBySms(String account,String code){
        Map<String,String> map=new HashMap<>();
        map.put("grant_type", "password");
        map.put("scope", "address phone openid email profile");
        map.put("phone_number", account);
        map.put("code", code);
        map.put("type", "sms");
        map.put("client_id", "niuess");
        return map;
    }
    //微信登录的请求参数
    public static Map<String,String> tokenFormByWx(String appId,String code){
        Map<String,String> map=new HashMap<>();
        map.put("grant_type", "password");
        map.put("scope", "address phone openid email profile");
        map.put("appid", appId);
        map.put("code", code);
        map.put("type", "wx_unionid");
        map.put("client_id", "niuess");
        return map;
    }
}
