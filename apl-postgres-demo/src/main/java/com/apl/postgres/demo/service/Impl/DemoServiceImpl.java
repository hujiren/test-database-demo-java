package com.apl.postgres.demo.service.Impl;
import com.apl.postgres.demo.entity.Driver;
import com.apl.postgres.demo.entity.Payment;
import com.apl.postgres.demo.entity.PgData;
import com.apl.postgres.demo.entity.PgWayBill;
import com.apl.postgres.demo.mapper.DemoMappers;
import com.apl.postgres.demo.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hjr start
 * @date 2020/6/10 - 10:47
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private DemoMappers demoMapper;

    @Override
    public PgWayBill findDemo(Integer id) {
        return demoMapper.findDemo(id);
    }


    @Override
    public Integer deleteDemo(Integer id) {
        return demoMapper.deleteById(id);
    }


    @Override
    public Integer insertDemo(PgWayBill pgWayBill) {

        ObjectMapper objectMapper = new ObjectMapper();
        Driver driver = new Driver();
        Payment payment = new Payment();
        PgData pgData = new PgData();
        pgWayBill = new PgWayBill();
        String str = null;
        try {
            driver.setMobile("13261785567");
            driver.setName("西乡坪洲商务酒店");

            payment.setCashAmount("www.fireFox.com");
            payment.setOilAmount("www.google.com");

            pgData.setProject("hello world");
            pgData.setWaybill("discover4 of Land Rover");
            pgData.setDriver(driver);
            pgData.setPayment(payment);

            pgWayBill.setPgName("王五");
            pgWayBill.setPgData(pgData);
            pgWayBill.setId(6);

            str = objectMapper.writeValueAsString(pgData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return demoMapper.insertDemo(pgWayBill.getId(), pgWayBill.getPgName(), str);
    }


    @Override
    public Integer updateDemo(PgWayBill pgWayBill) {
        ObjectMapper objectMapper = new ObjectMapper();
        Driver driver = new Driver();
        Payment payment = new Payment();
        PgData pgData = new PgData();
        pgWayBill = new PgWayBill();
        String str = null;
        try {
            driver.setMobile("18865654545");
            driver.setName("湖北武汉果子狸");

            payment.setCashAmount("www.souhu.com");
            payment.setOilAmount("www.wangjinshan.com");

            pgData.setProject("i can not breathe");
            pgData.setWaybill("database connection failed");
            pgData.setDriver(driver);
            pgData.setPayment(payment);

            pgWayBill.setPgName("乔巴");
            pgWayBill.setPgData(pgData);
            pgWayBill.setId(1);

            str = objectMapper.writeValueAsString(pgData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return demoMapper.updateDemo(pgWayBill.getId(), pgWayBill.getPgName(), str);
    }
}
