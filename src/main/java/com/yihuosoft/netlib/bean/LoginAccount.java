package com.yihuosoft.netlib.bean;


import java.util.List;

//用户登录账号相关信息
public class LoginAccount extends BaseResponse<List<LoginAccount.Result>> {


    public class Result {
        private String userId;
        private String account;
        private String type;
        private boolean enabled;
        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "userId='" + userId + '\'' +
                    ", account='" + account + '\'' +
                    ", type='" + type + '\'' +
                    ", enabled=" + enabled +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

}
