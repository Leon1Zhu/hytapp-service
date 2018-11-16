package com.hyt.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by zhuliang on 2017/6/9.
 */
@Entity
@Table(name = "subscribe_user")
public class SubscribeUser {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;


    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "origin")
    private String origin;

    @Column(name = "subscribe_time")
    private Date subscribeTime;


    @Column(name = "pro_name")
    private String proName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
