有备份就有一致性问题和同步问题
为什么不用消息队列? 
数据库同步工具  datax(alibaba 不支持ignite数据库 需要手动封装工具, 缺少jar包来源) 
              streamSet(不停的更新数据源)  
              binlog日志(反写)
              canal 
