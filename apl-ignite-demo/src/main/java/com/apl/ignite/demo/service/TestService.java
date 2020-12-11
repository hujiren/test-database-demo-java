package com.apl.ignite.demo.service;

import com.apl.ignite.demo.entity.TestPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hjr start
 * @Classname TestService
 * @Date 2020/12/11 16:15
 */

public interface TestService extends IService<TestPo> {

    void createTab();

    void add(TestPo testPo);

    void del(int id);

    TestPo mySelect();

    TestPo get(int id);
}
