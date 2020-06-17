package com.apl.ignite.demo.service.Impl;

import com.apl.ignite.demo.entity.Student;
import com.apl.ignite.demo.mapper.IgniteMapper;
import com.apl.ignite.demo.service.IgniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:36
 */
@Service
public class IgniteServiceImpl implements IgniteService {

    @Autowired
    private IgniteMapper igniteMapper;

    @Override
    public Student queryStu(Integer id) {
        System.out.println(
                "************************************************"
        );
        return igniteMapper.selectById(id);
    }

    @Override
    public Integer updateStu() {
        Student student = new Student();
        student.setName("李四");
        student.setAge(28);
        student.setGender("女");
        student.setId(1);
        return igniteMapper.updateById(student);
    }

    @Override
    public Integer insertStu() {
        Student student = new Student();
        student.setName("王五");
        student.setAge(38);
        student.setGender("女");
        student.setId(2);
        return igniteMapper.insert(student);
    }

    @Override
    public Integer deleteStu(Integer id) {
        return igniteMapper.deleteById(id);
    }
}
