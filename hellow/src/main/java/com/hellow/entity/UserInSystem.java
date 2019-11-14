package com.hellow.entity;

public class UserInSystem {

    private static String userName = "";

    public static void setUserName(String userName) {
        UserInSystem.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public UserInSystem(){

    }
}
