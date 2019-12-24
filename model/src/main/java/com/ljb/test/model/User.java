package com.ljb.test.model;

public class User {
    public int id;
    public String userName;
    public String passWord;
    public String nickName;
    public int age;
    public String headUrl;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickname='" + nickName + '\'' +
                ", age=" + age +
                ", headurl='" + headUrl + '\'' +
                '}';
    }
}
