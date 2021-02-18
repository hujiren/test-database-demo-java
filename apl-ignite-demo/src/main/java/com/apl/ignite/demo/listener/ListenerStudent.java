//package com.apl.ignite.demo.listener;
//
//import com.apl.ignite.demo.entity.student;
//import lombok.SneakyThrows;
//import org.apache.ignite.Ignite;
//import org.apache.ignite.IgniteCache;
//import org.apache.ignite.cache.query.ContinuousQuery;
//import org.apache.ignite.cache.query.QueryCursor;
//import org.apache.ignite.lang.IgniteAsyncCallback;
//import org.apache.ignite.resources.IgniteInstanceResource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.cache.Cache;
//import javax.cache.configuration.Factory;
//import javax.cache.event.CacheEntryEvent;
//import javax.cache.event.CacheEntryEventFilter;
//import javax.cache.event.CacheEntryListenerException;
//import javax.cache.event.CacheEntryUpdatedListener;
//
///**
// * @author hjr start
// * @Classname ListenerStudent
// * @Date 2020/12/16 18:11
// *
// */
//@Component
//public class ListenerStudent implements CommandLineRunner  {
//
//    @Autowired
//    Ignite ignite;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        startListener();
//    }
//
//    public void startListener()  {
////        ignite.cache("student");
//        IgniteCache<Object, Object> cache = ignite.cache("student");
//
//        ContinuousQuery<Long, student> query = new ContinuousQuery<>();
//
//        query.setLocalListener(new CacheEntryUpdatedListener<Long, student>() {
//
//            @SneakyThrows
//            @Override
//            public void onUpdated(Iterable<CacheEntryEvent<? extends Long, ? extends student>> events)
//                    throws CacheEntryListenerException {
////                System.out.println("student: " + events.toString());
////                Thread.sleep(1000);
//            }
//        });
//
////        query.setRemoteFilterFactory(new Factory<CacheEntryEventFilter<Long, student>>() {
////            @Override public CacheEntryEventFilter<Long, student> create() {
////                return new CacheEntryFilter();
////            }
////        });
//
////        try (QueryCursor<Cache.Entry<Long, student>> cur = cache.query(query)) {
////
////            for (Cache.Entry<Long, student> e : cur)
////                System.out.println("student2: " + e.toString());
////
////            // Wait for a while while callback is notified about remaining puts.
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//        cache.query(query);
//
//
//        System.out.println("start Listener student");
//
//        try {
//
//        }
//        catch (Exception e){
//
//        }
//    }
//
//
//    @IgniteAsyncCallback
//    private  static  class CacheEntryFilter implements CacheEntryEventFilter<Long, student> {
//
//        @IgniteInstanceResource
//        private Ignite ignite;
//
//        @SneakyThrows
//        @Override
//        public boolean evaluate(CacheEntryEvent<? extends Long, ? extends student> e) throws CacheEntryListenerException {
//
//            //System.out.println("student: " + cacheEntryEvent.toString());
//            //Thread.sleep(1000);
//
//            //return cacheEntryEvent.getKey() > 0;
//
//            ignite.cache("student").put(e.getKey(), e.getValue() + "_less_than_10");
//
//            return true;
//        }
//
//    }
//
//}
