package com.example.dagger2_eventbus.data.bean;

public class Bean {
    private String userName;
    private String userPwd;

    public Bean(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Bean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
