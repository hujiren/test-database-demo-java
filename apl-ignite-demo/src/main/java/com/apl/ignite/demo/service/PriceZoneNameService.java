package com.apl.ignite.demo.service;

import com.apl.ignite.demo.entity.student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hjr start
 * @Classname TestService
 * @Date 2020/12/11 16:15
 */

public interface PriceZoneNameService extends IService<student> {

    void createTab();

    void add(Long forEachNum, String val) throws Exception;

    void del(int id);

    student mySelect();

    student get(Long id);
}
