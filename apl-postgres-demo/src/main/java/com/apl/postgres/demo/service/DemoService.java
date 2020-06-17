package com.apl.postgres.demo.service;
import com.apl.postgres.demo.entity.PgWayBill;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author hjr start
 * @date 2020/6/10 - 10:46
 */
public interface DemoService{

    PgWayBill findDemo(Integer id);

    Integer insertDemo(PgWayBill pgWayBill);

    Integer updateDemo(PgWayBill pgWayBill);

    Integer deleteDemo(Integer id);
}
