#docker安装ignite

docker pull apacheignite/ignite:2.8.0

docker run -itd --name=ignite --net=host -e 
"CONFIG_URL=/opt/ignite/apache-ignite/examples/config/example-cache.xml" 
-v /apache-ignite/data:/usr/local/data 
-e IGNITE_WORK_DIR=/usr/local/data apacheignite/ignite:2.8.0

--net=host 表示暴露所有端口
CONFIG_URL 指定配置文件所在目录

ignite配置
目前的ignite分区感知不是正式版, 由瘦客户端连接至服务端需要提供所有服务端的地址和端口
所以如果有新添加的服务节点,需要重新启动瘦客户端
如果不用分区感知,则瘦客户端需要通过服务端的代理节点路由到服务节点在执行操作, 有性能瓶颈
瘦客户端支持集群的身份验证,开启身份验证在集群配置中, 瘦客户端仅提供登录凭证

若要启用缓存,必须配置数据区,数据区用于控制缓存的内存数量,和缓存的持久化配置

如果服务端启用身份认证, 会默认创建用户名密码为"ignite"的用户,客户端需使用ClientConfiguration创建连接并在连接时设置用户名密码





