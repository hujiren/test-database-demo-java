package com.apl.ignite.demo.controller;

import com.apl.ignite.demo.entity.TestPo;
import com.apl.ignite.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @Classname TestControlelr
 * @Date 2020/12/11 16:14
 */
@RestController
@RequestMapping("/test")
@Api(value = "test", produces = "test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/createTab")
    @ApiOperation(value = "createTab", notes = "createTab")
    public void createTab(){
        testService.createTab();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加", notes = "添加")
    public void add(TestPo testPo){
        testService.add(testPo);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除", notes = "删除")
    @ApiImplicitParam(name = "id", value = "id", paramType = "delete", required = true)
    public void del(int id){
        testService.del(id);
    }

    @PostMapping("/query")
    @ApiOperation(value = "查询", notes = "查询")
    public TestPo query(){
        return testService.mySelect();
    }

    @PostMapping("/get")
    @ApiOperation(value = "获取详细", notes = "获取详细")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true)
    public TestPo get(int id){
        return testService.get(id);
    }
}
