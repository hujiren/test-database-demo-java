#使用dockerCE下拉mongo镜像

1.查看可用版本, ins: docker search mongo

2.拉取最新版本镜像, ins: docker pull mongo:latest

3.查看本地镜像, ins: docker images

4.运行容器, ins: docker run -itd --name mongo -p 27017:27017 mongo --auth

5.安装成功, 查看运行中容器 / 所有容器, ins: docker ps / docker ps -a

6.mongodb数据存储与宿主机映射: docker run -it -v /mongodb/data:/mydata mongo /bin/bash

7.修改Mongodb数据存储位置: /etc/mongod.conf.orig  文件内部属性: dbpath:/mydata