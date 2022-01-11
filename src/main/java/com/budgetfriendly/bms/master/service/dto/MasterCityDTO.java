package com.budgetfriendly.bms.master.service.dto;


import java.util.Date;

public class MasterCityDTO {

    private Long id;
    private String cityName;
    private String cityCode;
    private Boolean status;
    private Date createdAt;
    private Date updatedAt;
    private MasterStateDTO masterStateDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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

    public MasterStateDTO getMasterStateDTO() {
        return masterStateDTO;
    }

    public void setMasterStateDTO(MasterStateDTO masterStateDTO) {
        this.masterStateDTO = masterStateDTO;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
