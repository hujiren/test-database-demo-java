package com.apl.ignite.demo.config;

import com.apl.ignite.demo.entity.PriceZoneNamePo;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.*;
import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.MySQLDialect;
import org.apache.ignite.configuration.*;

import javax.cache.configuration.Factory;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author hjr start
 * @Classname IgniteCacheBean
 * @Date 2020/12/8 15:04
 */
public class IgniteCacheBean {

    public Ignite igniteBean(){

        //配置自定义数据区, 若要配置缓存,必须先配置数据区,使用默认数据区也可以,同时数据区可以控制缓存的持久化
        DataStorageConfiguration storageCfg = new DataStorageConfiguration();

        DataRegionConfiguration dataRegionConfiguration = new DataRegionConfiguration();
        dataRegionConfiguration.setName("apl-dataRegion");

        //server  client

        //初始内存
        dataRegionConfiguration.setInitialSize(20 * 1024 * 1024);
        //最大内存
        dataRegionConfiguration.setMaxSize(40 * 1024 * 1024);
        //内存退出算法: 适用于关闭原生持久化后的堆外内存  整合外部存储后的堆外内存  堆内缓存  近缓存
        dataRegionConfiguration.setPageEvictionMode(DataPageEvictionMode.RANDOM_2_LRU);



        //启用持久化
        //dataRegionConfiguration.setPersistenceEnabled(true);
        //配置持久化目录, 需要配置集群
        //storageCfg.setStoragePath("G:\\ignite\\data");

        storageCfg.setDefaultDataRegionConfiguration(dataRegionConfiguration);


//      预写日志模式 FSYNC:数据任何情况下都不会丢失  LOG_ONLY:发生电源故障数据会丢失  BACKGROUND: 发生进程或电源故障数据会丢失   NONE:只有在节点优雅的关闭时数据才不会丢失
        storageCfg.setWalMode(WALMode.FSYNC);
        //日志存档路径
        storageCfg.setWalArchivePath("G:\\ignite\\log");
        //日志活动段存储路径
        storageCfg.setWalPath("G:\\ignite\\log");
        //设置为true 则开启文档压缩
        storageCfg.setWalCompactionEnabled(true);
        //设置文档压缩的算法
        storageCfg.setWalPageCompression(DiskPageCompression.LZ4);
        //日志压缩等级 从1-9等级 速度快-最高压缩率
        storageCfg.setWalCompactionLevel(9);
        //日志存档占用空间最大值(字节)
        storageCfg.setMaxWalArchiveSize(1024 * 1024 * 1024);


        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setDataStorageConfiguration(storageCfg);


//        //配置缓存, 可以单独配置缓存, 也可以在配置外部存储时同时配置缓存
//        CacheConfiguration cacheCfg = new CacheConfiguration("zoneCache");
//        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
//        cacheCfg.setBackups(2);
//        cacheCfg.setRebalanceMode(CacheRebalanceMode.SYNC);
//        cacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
//        cacheCfg.setPartitionLossPolicy(PartitionLossPolicy.READ_ONLY_SAFE);
//        cacheCfg.setDataRegionName("apl_data_area");
//        cfg.setCacheConfiguration(cacheCfg);



        //外部存储 + 缓存
        CacheConfiguration<String, PriceZoneNamePo> cacheCfg2 = new CacheConfiguration<>();

        //缓存的备份分区数量
        cacheCfg2.setBackups(2);

        //控制再平衡执行方式 SYNC:所有缓存操作都会被阻塞知道再平衡结束  ASYNC:再平衡在后台执行  NONE:再平衡不会被触发
        cacheCfg2.setRebalanceMode(CacheRebalanceMode.SYNC);

        //写同步模式 FULL_SYNC:客户端节点会等待所有写入或提交完成  FULL_ASYNC:客户端节点不会等待来自相关节点的响应  PRIMARY_SYNC:客户端节点会等待主节点写入或提交完成,但不等待备份
        cacheCfg2.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);

        //分区丢失策略 READ_ONLY_SAFE:缓存处于只读状态,写操作会抛异常,在丢失分区内的读操作也会抛异常
        //READ_WRITE_SAFE:缓存丢失分区的读写尝试都会抛出异常，但是在线分区的读写是正常的。
        //IGNORE:分区丢失将被无视,当请求丢失分区时,返回空值,如果集群中有任何一个数据区开启了持久化,IGNORE都会被READ_WRITE_SAFE替代, 显示配置指定也不可以
        cacheCfg2.setPartitionLossPolicy(PartitionLossPolicy.IGNORE);

        //内存区域名称
        cacheCfg2.setDataRegionName("apl-dataRegion");

        cacheCfg2.setName("apl-cache");
        //缓存模式, PARTITIONED:整体数据被拆分为分区,所有的分区再以平衡的方式分布于相关节点上, REPLICATED:所有的数据在所有的节点上都复制一份
        cacheCfg2.setCacheMode(CacheMode.REPLICATED);

        //原子化模式:ATOMIC:所有操作都会原子化执行, 一次一个,不支持事务,但是提供更好的性能,pulAll这种批量操作不能被事务支持
        //TRANSACTIONAL:在键-值API层面开启了符合ACID的事务支持,但是SQL不支持事务。
        //TRANSACTIONAL_SNAPSHOT:多版本并发控制,其同时支持键-值事务和SQL事务
        cacheCfg2.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        cacheCfg2.setReadThrough(true);//通写和通读不能与TRANSACTIONAL_SNAPSHOT原子化模式一起使用
        cacheCfg2.setWriteThrough(true);

        CacheJdbcPojoStoreFactory<String, PriceZoneNamePo> factory = new CacheJdbcPojoStoreFactory<>();
        factory.setDialect(new MySQLDialect());
        factory.setDataSourceFactory((Factory<DataSource>)() -> {
            MysqlDataSource mysqlDataSrc = new MysqlDataSource();
            mysqlDataSrc.setURL("jdbc:mysql://192.168.1.185:3307/test");
            mysqlDataSrc.setUser("root");
            mysqlDataSrc.setPassword("123456");
            return mysqlDataSrc;
        });

        JdbcType zoneType = new JdbcType();
        zoneType.setCacheName("apl-cache");
        zoneType.setKeyType(Long.class);

        zoneType.setValueType(PriceZoneNamePo.class);

        zoneType.setDatabaseTable("price_zone_name");

        zoneType.setKeyFields(new JdbcTypeField(java.sql.Types.BIGINT, "id", Long.class, "id"));

        String a;


        JdbcTypeField[] valFields = new JdbcTypeField[10];
        valFields[0] = new JdbcTypeField(java.sql.Types.BIGINT, "id", Long.class, "id");
        valFields[1] = new JdbcTypeField(java.sql.Types.VARCHAR, "channel_category", String.class, "channelCategory");
        valFields[2] = new JdbcTypeField(java.sql.Types.VARCHAR, "address", String.class, "address");
        valFields[3] = new JdbcTypeField(Types.BIGINT, "telephone", Long.class, "telephone");
        valFields[4] = new JdbcTypeField(java.sql.Types.VARCHAR, "first_name", String.class, "firstName");
        valFields[5] = new JdbcTypeField(java.sql.Types.VARCHAR, "remark", String.class, "remark");
        valFields[6] = new JdbcTypeField(Types.BIGINT, "code", Long.class, "code");
        valFields[7] = new JdbcTypeField(Types.TIMESTAMP, "start_date", Timestamp.class, "startDate");
        valFields[8] = new JdbcTypeField(Types.TIMESTAMP, "end_date", Timestamp.class, "endDate");
        valFields[9] = new JdbcTypeField(Types.DOUBLE, "balance", Double.class, "balance");

        //与查询更新有关
        zoneType.setValueFields(valFields);
        factory.setTypes(zoneType);

        cacheCfg2.setCacheStoreFactory(factory);

        QueryEntity qryEntity = new QueryEntity();
        qryEntity.setKeyType(Long.class.getName());
        qryEntity.setKeyFieldName("id");

        qryEntity.setValueType(PriceZoneNamePo.class.getName());

        Set<String> keyFields = new HashSet<>();
        keyFields.add("id");
        qryEntity.setKeyFields(keyFields);

        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("id", "java.lang.Long");
        fields.put("channel_category", "java.lang.String");
        fields.put("address", "java.lang.String");
        fields.put("telephone", "java.lang.Long");
        fields.put("first_name", "java.lang.String");
        fields.put("remark", "java.lang.String");
        fields.put("code", "java.lang.Long");
        fields.put("start_date", "java.util.Date.Timestamp");
        fields.put("end_date", "java.util.Date.Timestamp");
        fields.put("balance", "java.lang.Double");

        qryEntity.setFields(fields);

        cacheCfg2.setQueryEntities(Collections.singletonList(qryEntity));

        cfg.setCacheConfiguration(cacheCfg2);
//        Ignition.setClientMode(true);


        Ignite ignite = null;
        try {
            ignite = Ignition.start(cfg);
        } catch (IgniteException e) {
            ignite.close();
        }


        //以下是禁用wal存档
//        ignite.cluster().state(ClusterState.ACTIVE);
//        String cacheName = "myCache";
//        ignite.getOrCreateCache(cacheName);
//        ignite.cluster().disableWal(cacheName);
//        //load data
//        ignite.cluster().enableWal(cacheName);

        return ignite;
    }
}
