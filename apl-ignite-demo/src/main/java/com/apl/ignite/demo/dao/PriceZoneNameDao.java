package com.apl.ignite.demo.dao;

import com.apl.ignite.demo.entity.PriceZoneNamePo;
import org.apache.ignite.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hjr start
 * @Classname IgniteDao
 * @Date 2020/12/11 22:23
 */
@Component
public class PriceZoneNameDao {

    @Autowired
    IgniteClient igniteClient;

    @Autowired
    NamedParameterJdbcTemplate nameJdbcTemplate;

    final String tabName = "PriceZoneNamePo";
    final String cacheName = "price_zone_name";
    final String schemaName = "TEST";//schemaName  大写

    public void createTab(){
        String sql = "CREATE TABLE "+tabName+" (\n" +
                "  id BIGINT(30),\n" +
                "  address VARCHAR(20),\n" +
                "  city VARCHAR(100),\n"+
                "  company VARCHAR(100),\n" +
                "  country VARCHAR(20),\n" +
                "  firstName VARCHAR(35),\n" +
                "  idNum VARCHAR(50),\n" +
                "  remark VARCHAR (1000),\n" +
                "  telephone VARCHAR (20),\n" +
                "  endDate TIMESTAMP (3),\n" +
                "  PRIMARY KEY (id)\n" +
                ") WITH \"backups=1, KEY_TYPE=java.lang.Long, VALUE_TYPE=com.apl.ignite.demo.entity.Test2Po, CACHE_NAME="+tabName+"\";";

        nameJdbcTemplate.update(sql, new HashMap<>());
        String sql2 = "CREATE INDEX IF NOT EXISTS " + tabName + "_id_index ON "+tabName+"(id ASC, endDate ASC);";
        nameJdbcTemplate.update(sql2, new HashMap<>());
        System.out.println("create table:"+tabName);
    }


    public void put(Long forEachNum){
        ClientCache<Long, PriceZoneNamePo> cache = igniteClient.cache(cacheName);
        PriceZoneNamePo priceZoneNamePo = new PriceZoneNamePo();
        priceZoneNamePo.setId(1L);
        priceZoneNamePo.setAddress("深圳市宝安区福永街道福中工业园");
        priceZoneNamePo.setCity("广东省深圳市");
        priceZoneNamePo.setCompany("深圳市爱普伦科技有限公司");
        priceZoneNamePo.setCountry("中国");
        priceZoneNamePo.setFirstName("胡继仁");
        priceZoneNamePo.setIdNum("232103199610052837");
        priceZoneNamePo.setRemark("当原子化模式配置为TRANSACTIONAL时，Ignite对事务支持乐观和悲观的并发模型。并发模型决定了何时获得一个条目级的事务锁-在访问数据时或者在prepare阶段。" +
                "锁定可以防止对一个对象的并发访问。比如，当试图用悲观锁更新一个ToDo列表项时，服务端会在该对象上置一个锁，在提交或者回滚该事务之前，其它的事务或者操作都无法更新该条目。" +
                "不管在一个事务中使用那种并发模型，在提交之前都存在事务中的所有条目被锁定的时刻。  隔离级别定义了并发事务如何\"看\"以及处理针对同一个键的操作。" +
                "Ignite支持READ_COMMITTED、REPEATABLE_READ、SERIALIZABLE隔离级别。  并发模型和隔离级别的所有组合都是可以同时使用的。" +
                "下面是针对Ignite提供的每一个并发-隔离组合的行为和保证的描述。");
        priceZoneNamePo.setTelephone("13261785567");

        //计时开启
        priceZoneNamePo.setEndDate(new Timestamp(System.currentTimeMillis()));
        System.out.println("put start");
        long start = System.currentTimeMillis();
        cache.clear();
        for(long i = 0; i < forEachNum; i++){
            priceZoneNamePo.setId(i);
            cache.putIfAbsent(priceZoneNamePo.getId(), priceZoneNamePo);
        }

        //计时结束
        long end = System.currentTimeMillis();
        System.out.println("put end time: "+(end-start) / 1000);
    }


    public void get(Long id){
        ClientCache<Long, PriceZoneNamePo> cache = igniteClient.cache(cacheName);
        Collection<String> strings = igniteClient.cacheNames();
        strings.forEach(str -> System.out.println(str));
        PriceZoneNamePo priceZoneNamePo = cache.get(id);
        //使用get() 可以获取正确结果
        System.out.println("get()方法执行");
        System.out.println(priceZoneNamePo);
    }


    public void mySelect(){
        List<Map<String, Object>> list = nameJdbcTemplate.queryForList("SELECT * FROM \"" + schemaName + "\"." + tabName + ";", new HashMap<>());
        //已执行put(), 但使用Sql查询表的结果为空
        System.out.println("select()方法执行");
        System.out.println(list.toString());
    }
}
