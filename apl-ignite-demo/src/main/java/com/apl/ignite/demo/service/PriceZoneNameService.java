package com.apl.ignite.demo.service;

import com.apl.ignite.demo.entity.PriceZoneNamePo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hjr start
 * @Classname TestService
 * @Date 2020/12/11 16:15
 */

public interface PriceZoneNameService extends IService<PriceZoneNamePo> {

    void createTab();

    void add(Long forEachNum);

    void del(int id);

    PriceZoneNamePo mySelect();

    PriceZoneNamePo get(Long id);
}
