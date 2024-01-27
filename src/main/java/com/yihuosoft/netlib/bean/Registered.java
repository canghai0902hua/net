package com.yihuosoft.netlib.bean;

//判断账号是否已经注册实体
public class Registered extends BaseResponse<Registered.Result> {
    public static class Result{
        private boolean isRegistered;     //是否已经注册

        public boolean isRegistered() {
            return isRegistered;
        }

        public void setRegistered(boolean registered) {
            isRegistered = registered;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "isRegistered=" + isRegistered +
                    '}';
        }
    }
}
