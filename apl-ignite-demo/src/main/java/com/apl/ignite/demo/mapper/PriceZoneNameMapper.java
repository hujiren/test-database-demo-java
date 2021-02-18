package com.apl.ignite.demo.mapper;

import com.apl.ignite.demo.entity.student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hjr start
 * @Classname TestMapper
 * @Date 2020/12/11 16:24
 */
@Mapper
@Repository
public interface PriceZoneNameMapper extends BaseMapper<student> {
}
