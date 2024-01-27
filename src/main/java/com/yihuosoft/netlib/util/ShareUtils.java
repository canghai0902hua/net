package com.yihuosoft.netlib.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Method;

public class ShareUtils {
    public static final String NAME = "shareConfigV1";
    public static volatile SharedPreferences sharedPreferences;

    private  ShareUtils(Context context){
        sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public static ShareUtils shareUtils;
    public static ShareUtils getInstance(Context context){
        if(shareUtils==null){
            synchronized (ShareUtils.class){
                if(shareUtils==null){
                    shareUtils=new ShareUtils(context);
                }
            }
        }
        return shareUtils;
    }
    /**
     * 存储String类型的值
     *
     * @param key   key值
     * @param value 要存储的String值
     */
    public static void putString(String key, String value) {
        Log.e("aaaaaaaaa===putString",String.valueOf(System.currentTimeMillis()));
            sharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * 获取String类型的值
     *
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    public static String getString(String key, String defValue) {
        Log.e("aaaaaaaaa===getString",String.valueOf(System.currentTimeMillis()));
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * 存储String类型的值
     *
     * @param key   key值
     * @param value 要存储的String值
     */
    public static void putString(String shareName, String key, String value) {
        sharedPreferences.edit().putString(key, value).commit();
    }


    /**
     * 获取String类型的值
     *
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    public static String getString(String shareName, String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }


    /**
     * 存储Int类型的值
     *
     * @param key   key
     * @param value 要存储的Int值
     */
    public static void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    /**
     * 存储Iong类型的值
     *
     * @param key   key
     * @param value 要存储的Long值
     */
    public static void putLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    /**
     * 获取Int类型的值
     *
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    public static int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }


    /**
     * 获取Long类型的值
     *
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    public static Long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }


    /**
     * 存储Boolean类型的值
     *
     * @param key   key
     * @param value 要存储Boolean值
     */
    public static void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    /**
     * 获取Boolean类型的值
     *
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    public static boolean getBoolean(String key, Boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    //删除 单个 key
    public static void deleteShare(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    //删除全部 key
    public static void deleteAll() {
        sharedPreferences.edit().clear().apply();
    }


    private Application getApplication()  {
        Application application = null;
        Class<?> activityThreadClass;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            final Method method2 = activityThreadClass.getMethod(
                    "currentActivityThread", new Class[0]);
            // 得到当前的ActivityThread对象
            Object localObject = method2.invoke(null, (Object[]) null);

            final Method method = activityThreadClass
                    .getMethod("getApplication");
            application = (Application) method.invoke(localObject, (Object[]) null);

            return application;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
