package com.liang.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.liang.kafka.model.Person;
import com.liang.pattern.MySingleton;
import com.liang.pattern.Singleton;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lianghaiyang
 * @date 2018/09/05
 */
public class GuavaTests {
    @Test
    public void testSubscriber(){
        //cache缓存
        // LoadingCache是Cache的缓存实现
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                //设置缓存大小
                .maximumSize(1000)
                //设置到期时间
                .expireAfterWrite(10, TimeUnit.MINUTES)
                //设置缓存里的值两分钟刷新一次
                .refreshAfterWrite(2,TimeUnit.MINUTES)
                //开启缓存的统计功能
                .recordStats()
                //构建缓存
                .build(new CacheLoader<String, Object>() {
                    //此处实现如果根据key找不到value需要去如何获取
                    @Override
                    public Object load(String s) throws Exception {
                        return new Person();
                    }

                    //如果批量加载有比反复调用load更优的方法则重写这个方法
                    @Override
                    public Map<String, Object> loadAll(Iterable<? extends String> keys) throws Exception {
                        return super.loadAll(keys);
                    }
                });
    }
}
