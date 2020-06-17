#docker安装ignite

docker pull apacheignite/ignite:2.8.0

docker run -itd --name=ignite --net=host -e 
"CONFIG_URL=/opt/ignite/apache-ignite/examples/config/example-cache.xml" 
-v /apache-ignite/data:/usr/local/data 
-e IGNITE_WORK_DIR=/usr/local/data apacheignite/ignite:2.8.0

--net=host 表示暴露所有端口
CONFIG_URL 指定配置文件所在目录

