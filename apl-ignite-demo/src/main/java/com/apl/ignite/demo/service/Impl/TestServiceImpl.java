package com.apl.ignite.demo.service.Impl;

import com.apl.ignite.demo.dao.TestDao;
import com.apl.ignite.demo.entity.TestPo;
import com.apl.ignite.demo.mapper.TestMapper;
import com.apl.ignite.demo.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author hjr start
 * @Classname TestServiceImpl
 * @Date 2020/12/11 16:23
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestPo> implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public void createTab() {
        testDao.createTab();
    }

    @Override
    public void add(TestPo testPo) {

        testDao.put(testPo);
    }


    @Override
    public void del(int id) {
        baseMapper.deleteById(id);
    }

    @Override
    public TestPo mySelect() {

        testDao.mySelect();
        return null;
    }

    @Override
    public TestPo get(int id) {

        testDao.get(id);
        return null;
    }
}
