package com.budgetfriendly.bms.master.service.dto;

import java.util.Date;

public class MasterExpenseCategoryDTO {

    private Long id;

    private String expensiveCategoryName;

    private String expensiveCategoryCode;

    private Boolean status;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpensiveCategoryName() {
        return expensiveCategoryName;
    }

    public void setExpensiveCategoryName(String expensiveCategoryName) {
        this.expensiveCategoryName = expensiveCategoryName;
    }

    public String getExpensiveCategoryCode() {
        return expensiveCategoryCode;
    }

    public void setExpensiveCategoryCode(String expensiveCategoryCode) {
        this.expensiveCategoryCode = expensiveCategoryCode;
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
