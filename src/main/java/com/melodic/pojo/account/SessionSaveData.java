package com.melodic.pojo.account;

import java.io.Serializable;

public class SessionSaveData implements Account, Serializable {

    Integer accountType;
    String accountID;
    String accountName;
    String name;

    public SessionSaveData() {}

    public SessionSaveData(Integer accountType, String accountID, String accountName, String name) {
        this.accountType = accountType;
        this.accountID = accountID;
        this.accountName = accountName;
        this.name = name;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SessionSaveData{" +
                "accountType=" + accountType +
                ", accountID='" + accountID + '\'' +
                ", accountName='" + accountName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
