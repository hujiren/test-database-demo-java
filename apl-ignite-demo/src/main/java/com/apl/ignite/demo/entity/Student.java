package com.apl.ignite.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/6/16 - 16:17
 */
@Data
@TableName(value = "student")
public class Student implements Serializable {

    @TableId(value = "id")
    private Integer id;

    private String name;

    private String gender;

    private Integer age;
}
