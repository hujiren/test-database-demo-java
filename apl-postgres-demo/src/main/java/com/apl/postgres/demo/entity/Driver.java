package com.apl.postgres.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/6/11 - 12:04
 */
@Data
public class Driver implements Serializable {

    private String name;

    private String mobile;
}
