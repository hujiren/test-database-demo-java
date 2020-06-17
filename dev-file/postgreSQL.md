#Docker安装PostgresSQL

1.拉取镜像: ins: docker pull postgres:versionID

2.生成容器: ins: docker run -itd -v /本地数据卷:/虚拟数据路径 -v /本地日志卷:/虚拟日志路径 --name postgres
                -e POSTGRES_PASSWORD=123456 -p 5432:5432 postgres:versionID

3.更新插件: ins: apt-get update

4.安装插件: ins: apt-get install vim

5.修改配置: ins: vim /var/lib/postgresql/data/postgresql.conf
           数据存储路径: data_directory='xxx'      端口号: port=5432取消注释    可监听端口: listen_addresses='*'
           端口配置文件所在路径: hba_file= 'xxx'    logging_controller=on      log_directory='xxx' 
           log_filename='xxx'                     log_truncate_on_rotation=on    
           
6.修改配置: ins: vim /var/lib/postgresql/data/pg_hba.conf
           在IPv4 local connections: 下面添加: host  all     all     0.0.0.0/0       ident(表示需要密码校验)

7.如果修改后的配置文件路径发生变化
需要明确指定用户的新数据路径 ins: chown -R postgres:postgres /<new directory>
并修改数据目录权限 ins: chmod 700 /<new directory>
并将原目录的数据copy到新的目录中
