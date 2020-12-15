package com.apl.ignite.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author hjr start
 * @Classname TestPo
 * @Date 2020/12/11 16:16
 */
@ApiModel(value = "priceZoneNamePo", description = "priceZoneNamePo")
@TableName("price_zone_name")
public class PriceZoneNamePo implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    private long id;

    @ApiModelProperty(name = "firstName", value = "名称")
    private String firstName;

    @ApiModelProperty(name = "country", value = "国家")
    private String country;

    @ApiModelProperty(name = "address", value = "")
    private String address;

    @ApiModelProperty(name = "telephone", value = "")
    private String telephone;

    @ApiModelProperty(name = "remark", value = "")
    private String remark;

    @ApiModelProperty(name = "city", value = "")
    private String city;

    @ApiModelProperty(name = "idNum", value = "")
    private String idNum;

    @ApiModelProperty(name = "company", value = "")
    private String company;

    @ApiModelProperty(name = "endDate", value = "")
    private Timestamp endDate;

//    private long id;
//    private String firstName;
//    private String country;
//    private String address;
//    private String telephone;
//    private String remark;
//    private String city;
//    private String idNum;
//    private String company;
//    private Timestamp endDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
