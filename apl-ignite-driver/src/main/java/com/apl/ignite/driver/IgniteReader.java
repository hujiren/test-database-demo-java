package com.apl.ignite.driver;

import com.alibaba.datax.plugin.rdbms.reader.CommonRdbmsReader;
import com.alibaba.datax.plugin.rdbms.util.DataBaseType;

/**
 * @author hjr start
 * @Classname IgniteReader
 * @Date 2020/12/17 20:08
 */
public class IgniteReader extends Reader{

    private static final DataBaseType DATABASE_TYPE;

    static {
          /*
          typeName:数据源类型名称(全小写)
          driverClassName:数据源jdbc驱动类
         */
        DATABASE_TYPE = new DBType("ignite", "org.apache.ignite.IgniteJdbcThinDriver");
    }

    public static class Job extends Reader.Job {
        private static final Logger LOG = LoggerFactory.getLogger(Job.class);

        private Configuration originalConfig = null;
        private CommonRdbmsReader.Job commonRdbmsReaderJob;

        public void init() {
            this.originalConfig = super.getPluginJobConf();
            Integer userConfigedFetchSize = this.originalConfig.getInt("fetchSize");
//            if (userConfigedFetchSize != null) {
//                LOG.warn("对 ignitereader 不需要配置 fetchSize, mysqlreader 将会忽略这项配置. 如果您不想再看到此警告,请去除fetchSize 配置.");
//            }

            this.originalConfig.set("fetchSize", Integer.valueOf(-2147483648));

            this.commonRdbmsReaderJob = new com.alibaba.datax.plugin.rdbms.reader.CommonRdbmsReader.Job(IgniteReader.DATABASE_TYPE);
            this.commonRdbmsReaderJob.init(this.originalConfig);
        }


        public void preCheck() {
            init();
            this.commonRdbmsReaderJob.preCheck(this.originalConfig, IgniteReader.DATABASE_TYPE);
        }

        public List<Configuration> split(int adviceNumber) {
            return this.commonRdbmsReaderJob.split(this.originalConfig, adviceNumber);
        }

        public void post() {
            this.commonRdbmsReaderJob.post(this.originalConfig);
        }

        public void destroy() {
            this.commonRdbmsReaderJob.destroy(this.originalConfig);
        }
    }

    public static class Task extends Reader.Task {
        private Configuration readerSliceConfig;
        private CommonRdbmsReader.Task commonRdbmsReaderTask;

        public void init() {
            this.readerSliceConfig = super.getPluginJobConf();
            this.commonRdbmsReaderTask = new CommonRdbmsReader.Task(IgniteReader.DATABASE_TYPE, super.getTaskGroupId(), super.getTaskId());
            this.commonRdbmsReaderTask.init(this.readerSliceConfig);
        }

        public void startRead(RecordSender recordSender) {
            int fetchSize = this.readerSliceConfig.getInt("fetchSize").intValue();

            this.commonRdbmsReaderTask.startRead(this.readerSliceConfig, recordSender, super.getTaskPluginCollector(), fetchSize);
        }

        public void post() {
            this.commonRdbmsReaderTask.post(this.readerSliceConfig);
        }

        public void destroy() {
            this.commonRdbmsReaderTask.destroy(this.readerSliceConfig);
        }
    }
}


