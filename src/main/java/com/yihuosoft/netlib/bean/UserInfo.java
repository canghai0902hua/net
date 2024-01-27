package com.yihuosoft.netlib.bean;

import java.io.Serializable;

public class UserInfo extends BaseResponse<UserInfo.Result> implements Serializable {


    public static class Result implements Serializable {

        private String id;
        private String name;
        private String familyName;
        private String middleName;
        private String nickname;
        private String preferredUsername;
        private String profile;
        private String picture;
        private String website;
        private String email;
        private String emailVerified;
        private String gender;
        private String birthdate;
        private String zoneinfo;
        private String locale;
        private String phoneNumber;
        private String phoneNumberVerified;
        private String updatedAt;
        private String sourceId;
        private String certificateType;
        private String certificateNumber;
        private String address;
        private String createdAt;

//        private String userId;
//        private String username;
//        private boolean accountNonLocked;
//        private boolean accountNonExpired;
//        private boolean enabled;
//        private boolean credentialsNonExpired;
//        private String clientId;
//        private String domain;
//        private String nickName;
//        private String avatar;
//        private String accountId;
//        private String accountType;
//        private Attrs attrs;
//        private String tid;
//        private String deptId;
//        private String sex;
//        private String jnumber;
//        private String phone;
//        private String mobile;
//        private String deptName;
//        private String creditType;
//        private String creditNumber;
//        private String statusAct;
//        private String birthday;
//        private boolean clientOnly;
//        private boolean hasRenter;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPreferredUsername() {
            return preferredUsername;
        }

        public void setPreferredUsername(String preferredUsername) {
            this.preferredUsername = preferredUsername;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(String emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }

        public String getZoneinfo() {
            return zoneinfo;
        }

        public void setZoneinfo(String zoneinfo) {
            this.zoneinfo = zoneinfo;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPhoneNumberVerified() {
            return phoneNumberVerified;
        }

        public void setPhoneNumberVerified(String phoneNumberVerified) {
            this.phoneNumberVerified = phoneNumberVerified;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }

        public String getCertificateType() {
            return certificateType;
        }

        public void setCertificateType(String certificateType) {
            this.certificateType = certificateType;
        }

        public String getCertificateNumber() {
            return certificateNumber;
        }

        public void setCertificateNumber(String certificateNumber) {
            this.certificateNumber = certificateNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", familyName='" + familyName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", preferredUsername='" + preferredUsername + '\'' +
                    ", profile='" + profile + '\'' +
                    ", picture='" + picture + '\'' +
                    ", website='" + website + '\'' +
                    ", email='" + email + '\'' +
                    ", emailVerified='" + emailVerified + '\'' +
                    ", gender='" + gender + '\'' +
                    ", birthdate='" + birthdate + '\'' +
                    ", zoneinfo='" + zoneinfo + '\'' +
                    ", locale='" + locale + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", phoneNumberVerified='" + phoneNumberVerified + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", sourceId='" + sourceId + '\'' +
                    ", certificateType='" + certificateType + '\'' +
                    ", certificateNumber='" + certificateNumber + '\'' +
                    ", address='" + address + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    '}';
        }
    }
}
