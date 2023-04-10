package com.melodic.pojo.account;

import java.io.Serializable;

public class Administrator implements Account, Serializable {

    String accountID;
    String accountName;
    String password;
    String name;

    public Administrator() {}

    public Administrator(String accountID, String accountName, String password, String name) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.password = password;
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "accountID='" + accountID + '\'' +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
