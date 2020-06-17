package com.apl.ignite.demo.mapper;
import com.apl.ignite.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:36
 */
@Mapper
@Repository
public interface IgniteMapper extends BaseMapper<Student> {

}
