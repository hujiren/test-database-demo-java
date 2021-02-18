#docker安装ignite
1. 拉取镜像 

   docker pull apacheignite/ignite:2.6.0
   
2. 简单运行镜像

   docker run -itd --name ignite apacheignite/ignite:2.6.0
   
3. 在容器外部创建文件夹并赋予权限当做卷,权限不够挂载有可能会出错

   mkdir -p -m 777 /home/aapl/ignite/config
   mkdir -p -m 777 /home/aapl/ignite/config/config
   mkdir -p -m 777 /home/aapl/ignite/config/persistence 
   
4. 拷贝配置文件:从容器内部拷贝至外部
   docker cp ignite:/opt/ignite/apache-ignite-fabric/config /home/aapl/ignite

5. 停止并删除原有镜像
   docker stop ignite
   docker rm -f ignite

6.修改从容器内部拷贝出来的配置文件, default-config.xml

7. 重新挂载并运行镜像
  
      docker run -itd --net=host --name ignite 
      -e "JVM_OPTS= -Xms4g -Xmx4g -server -XX:+AggressiveOpts -XX:MaxPermSize=512m -XX:+AlwaysPreTouch -XX:+UseG1GC -XX:+ScavengeBeforeFullGC  -XX:+DisableExplicitGC" 
      -v /home/aapl/ignite/persistence:/persistence 
      -e IGNITE_WORK_DIR=/persistence      
      -v /home/aapl/ignite/config:/opt/ignite/apache-ignite-fabric/config 

8. 激活集群节点,未激活不能进行CRUD操作
    进入容器
   docker exec -it ignite /bin/bash
   cd apache-ignite-fabric/bin
   
   #如果配置文件设置了身份验证
   ./control.sh --user ignite --password ignite --activate
   
   #如果没有设置身份验证：
   #./control.sh --activate 
   
   显示 Cluster activated 则说明已经激活成功  

9. 测试(默认端口号是：10800)

   进入容器：
   docker exec -it ignite /bin/bash   
   
   cd apache-ignite-fabric/bin
   
   #如果有身份验证
   ./sqlline.sh --verbose=true -u "jdbc:ignite:thin://127.0.0.1:10800;user=ignite;password=ignite"
   
   #如果没有身份验证：忽略[username]和[password]
   ./sqlline.sh -u jdbc:ignite:thin://127.0.0.1
   
   查看所有表：!tables
   
   导入示例表 数据
   
   !run /opt/ignite/apache-ignite-fabric/examples/sql/world.sql
   
   执行sql语句
   
   select count(1) from CITY;
   
   [创建用户]
   
   CREATE USER test WITH PASSWORD 'test';
   
   CREATE USER "test WITH PASSWORD 'test'; (区分大小写,用户名用双引号,密码用单引号)
   
   [更改用户]
   
   ALTER USER test WITH PASSWORD 'test123';
   
   [删除用户]
   
   DROP USER userName;
   
   
ignite配置
目前的ignite分区感知不是正式版, 由瘦客户端连接至服务端需要提供所有服务端的地址和端口
所以如果有新添加的服务节点,需要重新启动瘦客户端
如果不用分区感知,则瘦客户端需要通过服务端的代理节点路由到服务节点在执行操作, 有性能瓶颈
瘦客户端支持集群的身份验证,开启身份验证在集群配置中, 瘦客户端仅提供登录凭证

若要启用缓存,必须配置数据区,数据区用于控制缓存的内存数量,和缓存的持久化配置

如果服务端启用身份认证, 会默认创建用户名密码为"ignite"的用户,客户端需使用ClientConfiguration创建连接并在连接时设置用户名密码

每一张创建的表都带有一个cache, 该cache不能独立于表存在, 表被删除,cache立即消失
想要实现瘦客户端操作表,则在建表的SQL中必须指定KEY_TYPE=java.lang.String, 和VALUE_TYPE=com.apl.ignite.demo.entity.TestPo



