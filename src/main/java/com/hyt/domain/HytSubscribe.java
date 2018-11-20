package com.hyt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hyt_subscribe")
public class HytSubscribe {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;


    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_tel")
    private String personTel;

    @Column(name = "type")
    private String type;

    @Column(name = "origin")
    private String origin;

    @Column(name = "order_time")
    private Date orderTime;

    @ManyToOne
    @JoinColumn(name = "order_house",referencedColumnName = "id")
    private HytHouse hytHouse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonTel() {
        return personTel;
    }

    public void setPersonTel(String personTel) {
        this.personTel = personTel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public HytHouse getHytHouse() {
        return hytHouse;
    }

    public void setHytHouse(HytHouse hytHouse) {
        this.hytHouse = hytHouse;
    }
}
