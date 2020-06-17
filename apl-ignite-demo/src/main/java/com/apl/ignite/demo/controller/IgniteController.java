package com.apl.ignite.demo.controller;
import com.apl.ignite.demo.entity.Student;
import com.apl.ignite.demo.service.IgniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:34
 */
@RestController
@RequestMapping(value = "/ignite")
public class IgniteController {

    @Autowired
    private IgniteService igniteService;

    @ResponseBody
    @RequestMapping(value = "/select")
    public Student queryStu(Integer id){

        return igniteService.queryStu(id);
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public Integer updateStu(){
        return igniteService.updateStu();
    }

    @ResponseBody
    @RequestMapping(value = "/insert")
    public Integer insertStu(){
        return igniteService.insertStu();
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public Integer deleteStu(Integer id){
        return igniteService.deleteStu(id);
    }

}
