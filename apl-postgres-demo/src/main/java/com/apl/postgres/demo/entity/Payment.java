package com.apl.postgres.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/6/11 - 12:02
 */
@Data
public class Payment implements Serializable {

    private  String oilAmount;

    private  String cashAmount;
}
