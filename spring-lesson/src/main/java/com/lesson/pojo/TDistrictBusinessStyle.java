package com.lesson.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Objects;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-03-02 14:02
 */
public class TDistrictBusinessStyle {
    private String id;
    private String categoryFiled;
    private String viewField;
    private String selectColor;
    private Long diaphaneity;
    private String viewSite;
    private String userCode;
    private String userName;
    private Time createTime;
    private Time updateTime;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getCategoryFiled(){
        return categoryFiled;
    }

    public void setCategoryFiled(String categoryFiled){
        this.categoryFiled=categoryFiled;
    }

    public String getViewField(){
        return viewField;
    }

    public void setViewField(String viewField){
        this.viewField=viewField;
    }

    public String getSelectColor(){
        return selectColor;
    }

    public void setSelectColor(String selectColor){
        this.selectColor=selectColor;
    }

    public Long getDiaphaneity(){
        return diaphaneity;
    }

    public void setDiaphaneity(Long diaphaneity){
        this.diaphaneity=diaphaneity;
    }

    public String getViewSite(){
        return viewSite;
    }

    public void setViewSite(String viewSite){
        this.viewSite=viewSite;
    }

    public String getUserCode(){
        return userCode;
    }

    public void setUserCode(String userCode){
        this.userCode=userCode;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public Time getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Time createTime){
        this.createTime=createTime;
    }

    public Time getUpdateTime(){
        return updateTime;
    }

    public void setUpdateTime(Time updateTime){
        this.updateTime=updateTime;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        TDistrictBusinessStyle that=(TDistrictBusinessStyle) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryFiled, that.categoryFiled) &&
                Objects.equals(viewField, that.viewField) &&
                Objects.equals(selectColor, that.selectColor) &&
                Objects.equals(diaphaneity, that.diaphaneity) &&
                Objects.equals(viewSite, that.viewSite) &&
                Objects.equals(userCode, that.userCode) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode(){

        return Objects.hash(id, categoryFiled, viewField, selectColor, diaphaneity, viewSite, userCode, userName, createTime, updateTime);
    }
}
