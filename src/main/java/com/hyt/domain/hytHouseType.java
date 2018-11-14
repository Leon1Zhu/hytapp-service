package com.hyt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hyt_house_type")
public class hytHouseType {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "type_id")
    private String typeId;

    @Column(name = "hyt_house_id")
    private String hytHouseId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_img")
    private String typeImg;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "type_measure")
    private String typeMeasure;

    @Column(name = "type_direction")
    private String typeDirection;

    @Column(name = "is_hot")
    private Boolean isHot;

    @Column(name = "type_label")
    private String typeLabel;

    @Column(name = "type_price")
    private String typePrice;

    public String getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(String typePrice) {
        this.typePrice = typePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getHytHouseId() {
        return hytHouseId;
    }

    public void setHytHouseId(String hytHouseId) {
        this.hytHouseId = hytHouseId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeMeasure() {
        return typeMeasure;
    }

    public void setTypeMeasure(String typeMeasure) {
        this.typeMeasure = typeMeasure;
    }

    public String getTypeDirection() {
        return typeDirection;
    }

    public void setTypeDirection(String typeDirection) {
        this.typeDirection = typeDirection;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }
}
