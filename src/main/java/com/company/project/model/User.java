package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    @Column(name = "passWord")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickname;

    /**
     * 1男，0女
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像地址
     */
    @Column(name = "photoUrl")
    private String photourl;

    /**
     * 注册时间
     */
    @Column(name = "registerTime")
    private Date registertime;

    /**
     * 1是，0不是
     */
    @Column(name = "isAdmin")
    private Integer isadmin;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return passWord - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return nickName - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取1男，0女
     *
     * @return sex - 1男，0女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置1男，0女
     *
     * @param sex 1男，0女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取头像地址
     *
     * @return photoUrl - 头像地址
     */
    public String getPhotourl() {
        return photourl;
    }

    /**
     * 设置头像地址
     *
     * @param photourl 头像地址
     */
    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    /**
     * 获取注册时间
     *
     * @return registerTime - 注册时间
     */
    public Date getRegistertime() {
        return registertime;
    }

    /**
     * 设置注册时间
     *
     * @param registertime 注册时间
     */
    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    /**
     * 获取1是，0不是
     *
     * @return isAdmin - 1是，0不是
     */
    public Integer getIsadmin() {
        return isadmin;
    }

    /**
     * 设置1是，0不是
     *
     * @param isadmin 1是，0不是
     */
    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }
}