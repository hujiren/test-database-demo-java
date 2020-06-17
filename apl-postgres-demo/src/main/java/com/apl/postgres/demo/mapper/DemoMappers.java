package com.apl.postgres.demo.mapper;
import com.apl.postgres.demo.entity.PgWayBill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author hjr start
 * @date 2020/6/10 - 11:11
 */
@Repository
@Mapper
public interface DemoMappers extends BaseMapper<PgWayBill> {

    PgWayBill findDemo(Integer id);

    Integer insertDemo(@Param(value = "id") Integer id , @Param(value = "name") String name, @Param(value = "data") String data);

    Integer updateDemo(@Param("id") Integer id, @Param("name") String name, @Param("data") String data);
}
