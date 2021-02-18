文档示例:https://www.cnblogs.com/harvey2017/p/12148906.html
功能介绍:https://www.jianshu.com/p/f5f0dc99d5ab
参数配置:https://www.jianshu.com/p/d7ec4998d190
参数调优:https://blog.csdn.net/qq_23268209/article/details/90437073
快速开始:https://github.com/alibaba/DataX/blob/master/userGuid.md
创建项目:https://blog.csdn.net/lw277232240/article/details/90903251
驱动插件二次开发https://developer.aliyun.com/article/753099?scm=20140722.184.2.173
注意事项:reader jdbcUrl必须带中括号  writer jdbcUrl必须不带中括号
github源码:https://github.com/alibaba/DataX
目录:/usr/local/distributed/datax
启动job命令:python datax.py ../job/job.json 必须在bin目录下执行
python bin/datax.py -r mysqlreader -w hdfswriter 获取配置模板
chmod +x xxxx.json 命令可以将Job目录下的新建的json文件进行授权变为datax可执行的job文件

reader 和 writer 命名 必须和/usr/local/distributed/datax/plugin目录中reader writer文件夹下列出的命名保持一致,
如果没有匹配的名称需要自行下载对应的源码手动编译打包放入 reader 或 writer文件夹下 python会全局扫描