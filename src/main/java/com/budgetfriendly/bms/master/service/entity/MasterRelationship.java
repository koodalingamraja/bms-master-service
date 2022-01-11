package com.budgetfriendly.bms.master.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "master_relationship")
public class MasterRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "relationship_name")
    private String relationshipName;
    @Column(name = "relationship_code")
    private String relationshipCode;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public String getRelationshipCode() {
        return relationshipCode;
    }

    public void setRelationshipCode(String relationshipCode) {
        this.relationshipCode = relationshipCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
