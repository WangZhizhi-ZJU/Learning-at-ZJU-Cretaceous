package com.melodic.pojo.account;

import java.io.Serializable;

public class LoginRawData implements Account, Serializable {

    String accountName;
    String password;
    String captcha;
    Boolean remember;

    public LoginRawData() {}

    public LoginRawData(String accountName, String password, String captcha, Boolean remember) {
        this.accountName = accountName;
        this.password = password;
        this.captcha = captcha;
        this.remember = remember;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "LoginRawData{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", captcha='" + captcha + '\'' +
                ", remember=" + remember +
                '}';
    }
}
