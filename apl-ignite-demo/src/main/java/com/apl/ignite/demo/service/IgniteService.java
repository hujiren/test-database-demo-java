package com.apl.ignite.demo.service;

import com.apl.ignite.demo.entity.Student;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:35
 */
public interface IgniteService {

    Student queryStu(Integer id);

    Integer updateStu();

    Integer insertStu();

    Integer deleteStu(Integer id);
}
