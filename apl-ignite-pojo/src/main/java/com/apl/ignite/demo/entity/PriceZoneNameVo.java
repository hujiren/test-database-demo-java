package com.apl.ignite.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author hjr start
 * @date 2020/8/6 - 14:13
 */
@Data

@ApiModel(value="快递分区名称-持久化对象", description="快递分区名称-持久化对象")
@TableName("price_zone_name")
public class PriceZoneNameVo extends Model<PriceZoneNameVo> {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(name = "id" , value = "快递分区id", required = true)
    private Long id;

    @ApiModelProperty(name = "channelCategory" , value = "渠道类型" , required = true)
    private String channelCategory;

    @ApiModelProperty(name = "address" , value = "地址" , required = true)
    private String address;

    @ApiModelProperty(name = "telephone" , value = "电话" , required = true)
    private String telephone;

    @ApiModelProperty(name = "firstName" , value = "姓名" , required = true)
    private String firstName;

    @ApiModelProperty(name = "remark" , value = "备注" , required = true)
    private String remark;

    @ApiModelProperty(name = "code" , value = "编号" , required = true)
    private String code;

    //@ApiModelProperty(name = "startDate" , value = "起始日期" , required = true)
    //private Timestamp startDate;

   // @ApiModelProperty(name = "endDate" , value = "截止日期" , required = true)
    //private Timestamp endDate;

    @ApiModelProperty(name = "balance" , value = "余额" , required = true)
    private Double balance;
}
