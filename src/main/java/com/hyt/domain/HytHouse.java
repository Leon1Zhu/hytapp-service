package com.hyt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hyt_house")
public class HytHouse {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(name = "is_recommend")
    private Boolean isRecommend;

    @Column(name = "is_like")
    private Boolean isLike;

    @Column(name = "is_highquality")
    private Boolean isHighquality;

    @Column(name = "is_specialcar")
    private Boolean isSpecialcar;


    @Column(name = "regin")
    private String regin;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private String price;

    @Column(name = "cover_photo")
    private String coverPhoto;

    @Column(name = "renovation")
    private String renovation;

    @Column(name = "housetype")
    private String houseType;

    @Column(name = "area")
    private String area;

    @Column(name = "characteristic")
    private String characteristic;

    @Column(name = "building_type")
    private String buildingType;

    @Column(name = "sales_status")
    private String salesStatus;

    @Column(name = "open_time")
    private Date openTime;

    @Column(name = "create_time")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public Boolean getLike() {
        return isLike;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }

    public Boolean getHighquality() {
        return isHighquality;
    }

    public void setHighquality(Boolean highquality) {
        isHighquality = highquality;
    }

    public Boolean getSpecialcar() {
        return isSpecialcar;
    }

    public void setSpecialcar(Boolean specialcar) {
        isSpecialcar = specialcar;
    }

    public String getRegin() {
        return regin;
    }

    public void setRegin(String regin) {
        this.regin = regin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getRenovation() {
        return renovation;
    }

    public void setRenovation(String renovation) {
        this.renovation = renovation;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
