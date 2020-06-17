package com.apl.postgres.demo.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/6/11 - 10:58
 */
@Data
@TableName(value = "j_waybill")
public class PgWayBill implements Serializable {

    @TableId
    private Integer id;

    private String name;

    private PgData pgData;

}
