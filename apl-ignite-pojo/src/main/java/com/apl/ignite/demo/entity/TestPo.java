package com.apl.ignite.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @Classname TestPo
 * @Date 2020/12/11 16:16
 */
@Data
@ApiModel(value = "test", description = "test")
public class TestPo implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    private Integer id;

    @ApiModelProperty(name = "name", value = "名称")
    private String name;

    @ApiModelProperty(name = "countryCode", value = "国家简码")
    private String countryCode;

    @ApiModelProperty(name = "district", value = "")
    private String district;

    @ApiModelProperty(name = "population", value = "")
    private Integer population;
}
