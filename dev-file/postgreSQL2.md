#Docker安装PostgresSQL

拉取镜像: docker pull postgres:latest

创建容器: docker run -itd -v /root/db/postgresql/data:/var/lib/postgresql/data -v /root/db/postgresql/log:/var/lib/postgresql/log --privileged --name postgres -e POSTGRES_PASSWORD=123456 -p 5432:5432 postgres:12
         
    
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
#chown -R postgres:postgres /<new directory>  
#chown -R postgres:postgres /usr/local/data  
 
开放端口/var/lib/postgresql/log
sudo ufw allow 5432

并修改数据目录权限 
#chmod 700 /<new directory>
#chmod 700 /usr/local/data


并将原目录的数据copy到新的目录中  
cd /var/lib/postgresql/data
cp -r * /usr/local/data

进入postgresql命令行
sudo -u postgres psql

修改超级用户密码并退出
postgres=# ALTER USER postgres WITH PASSWORD '123456'; 
postgres=# \q

修改数据库登录密码
sudo passwd -d postgres
sudo -u postgres passwd

重启数据库
sudo /etc/init.d/postgresql restart # 重启

NO POSTGRESQL clusters exist; see "man pg_createcluster"解决方案: 新建一个postgresql主机, 开放端口5433,并修改配置文件
sudo pg_createcluster  + <版本号> +  main --start

退出并重启容器
 exit / docker restart postgres
 
使用Navicat12会出现建表后找不到表的问题:升级Navicat15解决问题