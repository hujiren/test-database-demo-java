package com.apl.ignite.demo.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.apache.ignite.configuration.ClientConnectorConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hjr start
 * @Classname IgniteThinClient
 * @Date 2020/12/10 9:45
 */
@Configuration
@Component
public class IgniteThinClient {

    @Bean
    public IgniteClient thinClientBean(){

        ClientConnectorConfiguration clientConnectorCfg = new ClientConnectorConfiguration();
        //设置服务端地址
        clientConnectorCfg.setHost("192.168.1.185:10800");
        //设置要连接的端口
        clientConnectorCfg.setPort(10800);

        //设置连接端口范围, 10800 - 10805 瘦客户端回尝试绑定从port开始到range结束的每个端口, 直到找到可用端口为止, 如果都不可用, 则瘦客户端无法启动
        clientConnectorCfg.setPortRange(5);
        //启用/禁用 客户端接入
        clientConnectorCfg.setThinClientEnabled(true);
        //启用/禁用 SSL加密传输
//        clientConnectorCfg.setSslEnabled(true);

        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setClientConnectorConfiguration(clientConnectorCfg);

        //接入集群 如果地址都不通, 则抛出ClientConnectionException异常
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setAddresses("192.168.1.185:10800").setUserName("ignite").setUserPassword("ignite").setPartitionAwarenessEnabled(true);//分区感知
        IgniteClient igniteClient = Ignition.startClient(clientConfiguration);//igniteClient对象提供了访问数据的各种方法

//        Ignite ignite = Ignition.start(cfg);
        return igniteClient;
    }
}
    //    动态创建缓存
    //    ClientCacheConfiguration cacheCfg = new ClientCacheConfiguration().setName("References")
    //        .setCacheMode(CacheMode.REPLICATED)
    //        .setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);

    //    ClientCache<Integer, String> cache = client.getOrCreateCache(cacheCfg);



    //    igniteClient和ignite会直接访问缓存, 如果缓存不存在, 则创建该缓存,且使用默认的配置
    //    igniteClient.cache("");
    //    列出所有的缓存
    //    igniteClient.cacheNames();


    //    使用ScanQuery<K, V>类当做条件可获得一组满足给定条件的条目，瘦客户端将查询操作发送到集群节点，在集群节点上将其作为普通扫描查询执行。
