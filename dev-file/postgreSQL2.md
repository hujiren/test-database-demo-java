#Docker安装PostgresSQL

拉取镜像: docker pull postgres:latest

创建容器: docker run -itd -v /root/db/postgresql/data:/usr/local/data -v /root/db/postgresql/log:/usr/local/log --name postgres -e POSTGRES_PASSWORD=123456 -p 5432:5432 postgres:latest

进入容器: docker exec -it postgres /bin/bash

更新插件库: apt-get update

安装vim插件: apt-get install vim

修改配置: vim /var/lib/postgresql/data/postgresql.conf
           数据存储路径: data_directory='xxx'      端口号: port=5432取消注释    可监听端口: listen_addresses='*'
           端口配置文件所在路径: hba_file= 'xxx'    logging_collector=on      log_directory='xxx' 
           log_filename='xxx'                     log_truncate_on_rotation=on    
           
修改配置: vim /var/lib/postgresql/data/pg_hba.conf
           在IPv4 local connections: 下面添加: host  all     all     0.0.0.0/0       ident(表示需要密码校验)
           

如果修改后的配置文件路径发生变化
chown -R postgres:postgres /<new directory>  
chown -R postgres:postgres /usr/local/data  
 
开放端口
sudo ufw allow 5432

并修改数据目录权限 
chmod 700 /<new directory>
chmod 700 /usr/local/data


并将原目录的数据copy到新的目录中  
cd /var/lib/postgresql/data
cp -r * /usr/local/data
cp  * /usr/local/data


重启容器
 docker restart postgres
 
使用Navicat12会出现建表后找不到表的问题:升级Navicat15解决问题