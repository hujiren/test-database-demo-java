package com.apl.postgres.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/6/10 - 11:08
 */
@Data
public class PgData implements Serializable {

    private String project;

    private String waybill;

    private Driver driver;

    private Payment payment;
}
