package com.yihuosoft.netlib.util;

import android.content.Context;
import android.content.res.Resources;

import com.yihuosoft.netlib.BuildConfig;
import com.yihuosoft.netlib.R;
import com.yihuosoft.netlib.bean.FileStorage;
import com.yihuosoft.netlib.bean.UploadReq;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

//json数据提交参数实体类
public class RequestBodyUtil {
    //发送短信验证码请求参数
    public static RequestBody sendSmsMessage(Resources res, @Constant.SendType String type, String account) {
        Map<String, Object> map = new HashMap<>();
        map.put("clientId", BuildConfig.API_KEY);
        map.put("recipient", account);
        map.put("channelType", new String[]{Constant.SEND_CHANNEL_TYPE_TENCENT_SMS});
        map.put("scenarioKey", res.getString(R.string.scenario_key_verification_code));
        map.put("type", new String[]{Constant.SEND_TYPE_LOGIN});
        if (type.equals(Constant.SEND_TYPE_CHANGE_PASSWORD)) {
            map.put("type", new String[]{Constant.SEND_TYPE_CHANGE_PASSWORD});
        }else if(type.equals(Constant.SEND_TYPE_DELETE_ACCOUNT)){
            map.put("type", new String[]{Constant.SEND_TYPE_DELETE_ACCOUNT});
        }else if(type.equals(Constant.SEND_TYPE_CHANGE_PHONE)){
            map.put("type", new String[]{Constant.SEND_TYPE_CHANGE_PHONE});
        }else if(type.equals(Constant.SEND_TYPE_BIND_PHONE)){
            map.put("type", new String[]{Constant.SEND_TYPE_BIND_PHONE});
        }
        return RequestBody.create(ToolUtils.toJson(map), MediaType.parse("application/json; charset=utf-8"));
    }

    //发送邮箱验证码请求参数
    public static Map<String, Object> sendSmsEmail(Context context, @Constant.SendType String type, String subject, String operation, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("recipient", email);
        map.put("scenarioKey", context.getString(R.string.scenario_key_verification_code));
        map.put("type", type);
        map.put("clientId",BuildConfig.API_KEY);
        map.put("channelType", new String[]{Constant.SEND_CHANNEL_TYPE_EMAIL});
        map.put("mailSubject", subject);
        Map<String, String> variableParam = new HashMap<>();
        variableParam.put("operation", operation);
        map.put("variableParam", variableParam);
        return map;
    }

    public static RequestBody preUploadBody(UploadReq uploadReq){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), ToolUtils.toJson(uploadReq));
    }

    public static RequestBody saveReturnId(FileStorage storage){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), ToolUtils.toJson(storage));
    }
}
