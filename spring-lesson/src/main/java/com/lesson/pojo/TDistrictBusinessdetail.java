package com.lesson.pojo;


import java.util.Date;

public class TDistrictBusinessdetail {

  private String id;
  private String districtBusinessId;
  private String districtId;
  private String districtName;
  private String districtLevel;
  private String districtCityId;
  private String districtCityName;
  private Date createTime;
  private Date updateTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getDistrictBusinessId() {
    return districtBusinessId;
  }

  public void setDistrictBusinessId(String districtBusinessId) {
    this.districtBusinessId = districtBusinessId;
  }


  public String getDistrictId() {
    return districtId;
  }

  public void setDistrictId(String districtId) {
    this.districtId = districtId;
  }


  public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }


  public String getDistrictLevel() {
    return districtLevel;
  }

  public void setDistrictLevel(String districtLevel) {
    this.districtLevel = districtLevel;
  }


  public String getDistrictCityId() {
    return districtCityId;
  }

  public void setDistrictCityId(String districtCityId) {
    this.districtCityId = districtCityId;
  }


  public String getDistrictCityName() {
    return districtCityName;
  }

  public void setDistrictCityName(String districtCityName) {
    this.districtCityName = districtCityName;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

}
