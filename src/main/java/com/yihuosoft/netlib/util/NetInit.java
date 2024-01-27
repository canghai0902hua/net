package com.yihuosoft.netlib.util;

import android.app.Application;

public class NetInit {
    public static NetInit instance;
    public static NetInit getInstance(Application application) {
        if (instance == null) {
            synchronized (NetInit.class) {
                if (instance == null) {
                    instance = new NetInit(application);
                }
            }
        }
        return instance;
    }

    private NetInit(Application application) {
        ShareUtils.getInstance(application);
        NetWorkUtil.getInstance(application);
    }


}
