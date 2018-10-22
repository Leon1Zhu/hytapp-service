package com.hyt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hyt_house_advantage")
public class HytHouseAdvantage {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "advantage_id")
    private String advantageId;

    @Column(name = "hyt_house_id")
    private String hytHouseId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private Date createTime;

    public String getId() {
        return id;
    }

    public String getAdvatageId() {
        return advantageId;
    }

    public void setAdvatageId(String advatageId) {
        this.advantageId = advatageId;
    }

    public String getHytHouseId() {
        return hytHouseId;
    }

    public void setHytHouseId(String hytHouseId) {
        this.hytHouseId = hytHouseId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
