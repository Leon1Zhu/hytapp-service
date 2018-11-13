package com.hyt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hyt_imgs")
public class HytImgs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "imgs_id")
    private String imgsId;

    @Column(name = "house_id")
    private String houseId;

    @Column(name = "imgs_url")
    private String imgsUrl;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_top")
    private Boolean isTop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgsId() {
        return imgsId;
    }

    public void setImgsId(String imgsId) {
        this.imgsId = imgsId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getImgsUrl() {
        return imgsUrl;
    }

    public void setImgsUrl(String imgsUrl) {
        this.imgsUrl = imgsUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }
}
