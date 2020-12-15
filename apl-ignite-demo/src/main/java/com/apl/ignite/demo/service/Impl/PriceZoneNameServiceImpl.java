package com.apl.ignite.demo.service.Impl;

import com.apl.ignite.demo.dao.PriceZoneNameDao;
import com.apl.ignite.demo.entity.PriceZoneNamePo;
import com.apl.ignite.demo.mapper.PriceZoneNameMapper;
import com.apl.ignite.demo.service.PriceZoneNameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author hjr start
 * @Classname TestServiceImpl
 * @Date 2020/12/11 16:23
 */
@Service
public class PriceZoneNameServiceImpl extends ServiceImpl<PriceZoneNameMapper, PriceZoneNamePo> implements PriceZoneNameService {

    @Autowired
    PriceZoneNameDao priceZoneNameDao;

    @Override
    public void createTab() {
        priceZoneNameDao.createTab();
    }

    @Override
    public void add(Long forEachNum) {

        priceZoneNameDao.put(forEachNum);
    }


    @Override
    public void del(int id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PriceZoneNamePo mySelect() {

        priceZoneNameDao.mySelect();
        return null;
    }

    @Override
    public PriceZoneNamePo get(Long id) {

        priceZoneNameDao.get(id);
        return null;
    }
}
