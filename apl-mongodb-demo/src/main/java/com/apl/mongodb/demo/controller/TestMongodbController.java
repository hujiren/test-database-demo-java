package com.apl.mongodb.demo.controller;

import com.apl.mongodb.demo.Service.TestMongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @date 2020/6/5 - 18:15
 */
@RestController
@RequestMapping(value = "/test")
public class TestMongodbController {

    @Autowired
    private TestMongodbService testMongodbService;

    @RequestMapping("/insertEmp")
    @ResponseBody
    public Integer addEmp(){
        return testMongodbService.addEmp();
    }
}
