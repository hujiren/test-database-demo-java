package com.apl.ignite.demo.dao;

import com.apl.ignite.demo.entity.TestPo;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientTransaction;
import org.apache.ignite.client.ClientTransactions;
import org.apache.ignite.client.IgniteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hjr start
 * @Classname IgniteDao
 * @Date 2020/12/11 22:23
 */
@Component
public class TestDao {

    @Autowired
    IgniteClient igniteClient;

    @Autowired
    NamedParameterJdbcTemplate nameJdbcTemplate;

    final String tabName = "TEST";

    public void createTab(){
        String sql = "CREATE TABLE "+tabName+" (\n" +
                "  ID INT(11),\n" +
                "  Name CHAR(35),\n" +
                "  CountryCode CHAR(3),\n" +
                "  District CHAR(20),\n" +
                "  Population INT(11),\n" +
                "  PRIMARY KEY (ID)\n" +
                ") WITH \"backups=1, CACHE_NAME="+tabName+"\";";

        nameJdbcTemplate.update(sql, new HashMap<>());

        System.out.println("create table:"+tabName);
    }


    public void put(TestPo testPo){

        ClientCache<Object, Object> cache = igniteClient.cache(tabName);
        cache.putIfAbsent(testPo.getId(), testPo);
        System.out.println("putIfAbsent");
    }

    public void get(int id){
        ClientCache<Object, Object> cache = igniteClient.cache(tabName);
        Object o = cache.get(id);
        //使用get() 可以获取正确结果

        System.out.println(o);
    }

    public void mySelect(){

        List<Map<String, Object>> list = nameJdbcTemplate.queryForList("select * from "+tabName, new HashMap<>());
        //已执行put(), 但使用Sql查询表的结果为空

        System.out.println(list.toString());
    }
}
