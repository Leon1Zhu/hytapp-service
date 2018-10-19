package com.hyt.domain;

import javax.persistence.*;

@Entity
@Table(name = "hyt_person_tel")
public class HytPersonTel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(name = "tel_origin")
    private Boolean telOrigin;

    @Column(name = "tel_number")
    private Boolean telNumber;

    @Column(name = "tel_time")
    private Boolean temTime;

    @ManyToOne
    @JoinColumn(name = "tel_house",referencedColumnName = "id")
    private HytHouse hytHouse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getTelOrigin() {
        return telOrigin;
    }

    public void setTelOrigin(Boolean telOrigin) {
        this.telOrigin = telOrigin;
    }

    public Boolean getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Boolean telNumber) {
        this.telNumber = telNumber;
    }

    public Boolean getTemTime() {
        return temTime;
    }

    public void setTemTime(Boolean temTime) {
        this.temTime = temTime;
    }

    public HytHouse getHytHouse() {
        return hytHouse;
    }

    public void setHytHouse(HytHouse hytHouse) {
        this.hytHouse = hytHouse;
    }
}
