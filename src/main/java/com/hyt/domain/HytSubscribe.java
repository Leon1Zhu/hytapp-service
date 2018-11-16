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
    private Boolean personName;

    @Column(name = "person_tel")
    private Boolean personTel;

    @Column(name = "type")
    private Boolean type;

    @Column(name = "origin")
    private Boolean origin;

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

    public Boolean getPersonName() {
        return personName;
    }

    public void setPersonName(Boolean personName) {
        this.personName = personName;
    }

    public Boolean getPersonTel() {
        return personTel;
    }

    public void setPersonTel(Boolean personTel) {
        this.personTel = personTel;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getOrigin() {
        return origin;
    }

    public void setOrigin(Boolean origin) {
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
