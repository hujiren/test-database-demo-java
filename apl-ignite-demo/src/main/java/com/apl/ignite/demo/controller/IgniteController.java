package com.apl.ignite.demo.controller;
import com.apl.ignite.demo.entity.PriceZoneNameVo;
import com.apl.ignite.demo.entity.TestPo;
import com.apl.ignite.demo.service.IgniteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:34
 */
@RestController
@RequestMapping(value = "/ignite")
@Api(value = "ignite",tags = "ignite")
public class IgniteController {

    @Autowired
    private IgniteService igniteService;

    @PostMapping(value = "/select")
    public void queryStu(Long num){

        igniteService.queryStu(num);
    }

    @PostMapping(value = "/update")
    @ApiImplicitParam(name = "num", value = "num", paramType = "query", required = true)
    public Integer updateStu(Long num){
        return igniteService.updateStu(num);
    }

    @PostMapping(value = "/insert")
    public Integer insertStu(){
        return igniteService.insertStu();
    }

    @PostMapping(value = "/delete")
    public Integer deleteStu(Integer id){
        return igniteService.deleteStu(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加", notes = "添加")
    public void add(PriceZoneNameVo priceZoneNameVo){
        igniteService.add(priceZoneNameVo);
    }
}
