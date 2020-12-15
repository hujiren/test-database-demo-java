package com.apl.ignite.demo.controller;

import com.apl.ignite.demo.entity.PriceZoneNamePo;
import com.apl.ignite.demo.service.PriceZoneNameService;
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
@RequestMapping("/test2")
@Api(value = "test2", produces = "test2")
public class PriceZoneNameController {

    @Autowired
    PriceZoneNameService priceZoneNameService;

    @PostMapping("/createTab")
    @ApiOperation(value = "createTab", notes = "createTab")
    public void createTab(){
        priceZoneNameService.createTab();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加", notes = "添加")
    public void add(Long forEachNum){
        priceZoneNameService.add(forEachNum);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除", notes = "删除")
    @ApiImplicitParam(name = "id", value = "id", paramType = "delete", required = true)
    public void del(int id){
        priceZoneNameService.del(id);
    }

    @PostMapping("/query")
    @ApiOperation(value = "查询", notes = "查询")
    public PriceZoneNamePo query(){
        return priceZoneNameService.mySelect();
    }

    @PostMapping("/get")
    @ApiOperation(value = "获取详细", notes = "获取详细")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true)
    public PriceZoneNamePo get(Long id){
        return priceZoneNameService.get(id);
    }
}
