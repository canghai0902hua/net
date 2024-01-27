package com.yihuosoft.netlib.bean;

import java.io.Serializable;

/**
 * 登录返回获取的token
 */
public class TokenModel extends BaseResponse<TokenModel.Result> {
    public static class Result implements Serializable {
        private String access_token;
        private String token_type;
        private String refresh_token;
        private String expires_in;
        private String scope;
        private String openid;
        private String domain;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getToken_type() {
            return token_type;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        public String getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(String expires_in) {
            this.expires_in = expires_in;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        @Override
        public String toString() {
            return "TokenModel{" +
                    "access_token='" + access_token + '\'' +
                    ", token_type='" + token_type + '\'' +
                    ", refresh_token='" + refresh_token + '\'' +
                    ", expires_in='" + expires_in + '\'' +
                    ", scope='" + scope + '\'' +
                    ", openid='" + openid + '\'' +
                    ", domain='" + domain + '\'' +
                    '}';
        }

    }
}
