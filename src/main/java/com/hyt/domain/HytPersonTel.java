package com.hyt.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "hyt_person_tel")
public class HytPersonTel {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;


    @Column(name = "tel_origin")
    private String telOrigin;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "tel_time")
    private Date telTime;

    @ManyToOne
    @JoinColumn(name = "tel_house",referencedColumnName = "id")
    private HytHouse hytHouse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelOrigin() {
        return telOrigin;
    }

    public void setTelOrigin(String telOrigin) {
        this.telOrigin = telOrigin;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Date getTemTime() {
        return telTime;
    }

    public void setTemTime(Date temTime) {
        this.telTime = temTime;
    }

    public HytHouse getHytHouse() {
        return hytHouse;
    }

    public void setHytHouse(HytHouse hytHouse) {
        this.hytHouse = hytHouse;
    }
}
