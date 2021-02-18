package com.apl.ignite.demo.service.Impl;

import com.apl.ignite.demo.dao.PriceZoneNameDao;
import com.apl.ignite.demo.entity.student;
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
public class PriceZoneNameServiceImpl extends ServiceImpl<PriceZoneNameMapper, student> implements PriceZoneNameService {

    @Autowired
    PriceZoneNameDao priceZoneNameDao;

    @Override
    public void createTab() {
        priceZoneNameDao.createTab();
    }

    @Override
    public void add(Long forEachNum, String val) {

        priceZoneNameDao.put(forEachNum, val);
    }


    @Override
    public void del(int id) {
        baseMapper.deleteById(id);
    }

    @Override
    public student mySelect() {

        priceZoneNameDao.mySelect();
        return null;
    }

    @Override
    public student get(Long id) {

        priceZoneNameDao.get(id);
        return null;
    }
}
