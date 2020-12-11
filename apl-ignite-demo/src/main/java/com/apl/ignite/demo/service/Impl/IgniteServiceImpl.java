package com.apl.ignite.demo.service.Impl;
import com.apl.db.adb.AdbHelper;
import com.apl.ignite.demo.entity.PriceZoneNameVo;
import com.apl.ignite.demo.mapper.IgniteMapper;
import com.apl.ignite.demo.service.IgniteService;
import com.apl.tenant.AplTenantConfig;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import org.apache.ignite.*;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientTransaction;
import org.apache.ignite.client.ClientTransactions;
import org.apache.ignite.client.IgniteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

@Service
public class IgniteServiceImpl extends ServiceImpl<IgniteMapper, PriceZoneNameVo> implements IgniteService{

    @Autowired
    private IgniteMapper igniteMapper;

    @Autowired
    IgniteClient ignite;

    @Autowired
    NamedParameterJdbcTemplate nameJdbcTemplate;



    @Override
    public void queryStu(Long num) {

//        com.apl.db.adb.AdbHelper
        Collection<String> strings = ignite.cacheNames();
        strings.forEach((str) -> System.out.println(str));
        ClientCache<Object, Object> cache = ignite.cache("priceZone");
        for(int i = 0; i < num; i++){
            PriceZoneNameVo o = (PriceZoneNameVo) cache.get(i + 1L);
            Object obj = cache.get(i + 1L);
            System.out.println(obj);
        }
        cache.clear();
    }

    @Override
    public Integer updateStu(Long num) {

        for(int i = 0; i < num; i++){
            ignite.cacheNames();
            ClientCache<Object, Object> cache = ignite.getOrCreateCache("priceZone");
            PriceZoneNameVo priceZoneNameVo = new PriceZoneNameVo();
            priceZoneNameVo.setId(389878907L);
            priceZoneNameVo.setChannelCategory("RPG");
            priceZoneNameVo.setAddress("广东省深圳市宝安区海城路78号");
            priceZoneNameVo.setBalance(8989898.12);
            priceZoneNameVo.setCode("232103199610052837");
            //priceZoneNameVo.setEndDate(new Timestamp(System.currentTimeMillis()));
            //priceZoneNameVo.setStartDate(new Timestamp(System.currentTimeMillis()));
            priceZoneNameVo.setFirstName("法外狂徒张三");
            priceZoneNameVo.setRemark("Ignite使用数据区的概念来控制可用于缓存的内存数量，" +
                    "数据区是缓存数据存储在内存中的逻辑可扩展区域。可以控制数据区的初始值及其可以占用的最大值，除了大小之外，数据区还控制缓存的持久化配置。");
            priceZoneNameVo.setTelephone("13845199844");
            ClientTransactions transactions = ignite.transactions();
            ClientTransaction clientTransaction = transactions.txStart();
            cache.putIfAbsent(i + 1L, priceZoneNameVo);
            if(i == 2){
                throw new RuntimeException();
            }
            clientTransaction.commit();
        }


        return 1;
    }

    @Override
    public Integer insertStu() {

        return 1;
    }

    @Override
    public Integer deleteStu(Integer id) {
        return igniteMapper.deleteById(id);
    }

    @Override
    public void add(PriceZoneNameVo priceZoneNameVo) {


        //baseMapper.insert(priceZoneNameVo);
        //save(priceZoneNameVo);

    }
}
