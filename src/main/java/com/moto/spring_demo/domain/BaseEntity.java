package com.moto.spring_demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("created_at")
    @Column(name = "created_at")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("updated_at")
    @Column(name = "updated_at")
    private Date lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    @PrePersist
    public void setCreated() {
        this.created = new Date();
        this.lastUpdated = created;
    }

    public void setCreated(Date createdDate) {
        this.created = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated == null ? created : lastUpdated;
    }

    @PreUpdate
    public void setLastUpdated() {
        this.lastUpdated = new Date();
    }


}

