package com.apl.postgres.demo.controller;

import com.apl.postgres.demo.entity.PgWayBill;
import com.apl.postgres.demo.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @date 2020/6/10 - 10:38
 */
@RequestMapping(value = "/demo")
@RestController
@Api(value = "postgres", tags = "test")
public class DemoController {

    @Autowired
    private DemoService demoService;


    @RequestMapping(value = "/findDemo")
    @ResponseBody
    public PgWayBill findDemo(Integer id){
        return demoService.findDemo(id);
    }


    @RequestMapping(value = "/insertDemo")
    @ResponseBody
    public Integer insertDemo(PgWayBill pgWayBill){
        return demoService.insertDemo(pgWayBill);
    }


    @ResponseBody
    @RequestMapping("/updateDemo")
    public Integer updateDemo(PgWayBill pgWayBill){
        return demoService.updateDemo(pgWayBill);
    }


    @ResponseBody
    @RequestMapping("/deleteDemo")
    public Integer deleteDemo(Integer id){
        return demoService.deleteDemo(id);
    }
}
