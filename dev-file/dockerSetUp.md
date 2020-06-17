#使用yum安装docker

解决yum找不到下载docker路径的问题, 将docker.repo文件中的baseurl改为//mirrors.aliyun.com/docker-ce/linux/centos/7/$basearch/stable

1.更新yum, ins: yum -y update

2.安装yum需要依赖的包, ins: sudo yum install -y yum-utils \device-mapper-persistent-data \lvm2

3.安装稳定版的yum仓库源, ins: sudo yum-config-manager \--add-repo \https://download.docker.com/linux/centos/docker-ce.repo

4.可选项, ins: sudo yum-config-manager --enable docker-ce-edge

5.安装dockerCE, ins: sudo yum install docker-ce

6.查看可用版本, ins:  yum list docker-ce --showduplicates | sort -r

7.启动docker, ins: sudo systemctl start docker

8.查看自己安装的版本, ins: docker -v