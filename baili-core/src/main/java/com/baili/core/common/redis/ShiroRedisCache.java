package com.baili.core.common.redis;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import cn.hutool.core.util.ObjectUtil;

public class ShiroRedisCache<K,V> implements Cache<K,V> {
	@SuppressWarnings("rawtypes")
	@Resource 
    private RedisTemplate redisTemplate;
    private String prefix = "shiro_redis";

    public String getPrefix() {
        return prefix+":";
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @SuppressWarnings("rawtypes")
	public ShiroRedisCache(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @SuppressWarnings("rawtypes")
	public ShiroRedisCache(RedisTemplate redisTemplate,String prefix){
        this(redisTemplate);
        this.prefix = prefix;
    }

    @SuppressWarnings("unchecked")
	@Override
    public V get(K k) throws CacheException {
        if (k == null) {
            return null;
        }
        byte[] bytes = getBytesKey(k);
        return (V)redisTemplate.opsForValue().get(bytes);

    }

    @SuppressWarnings("unchecked")
	@Override
    public V put(K k, V v) throws CacheException {
        if (k== null || v == null) {
            return null;
        }

        byte[] bytes = getBytesKey(k);
        redisTemplate.opsForValue().set(bytes, v);
        return v;
    }

    @SuppressWarnings("unchecked")
	@Override
    public V remove(K k) throws CacheException {
        if(k==null){
            return null;
        }
        byte[] bytes =getBytesKey(k);
        V v = (V)redisTemplate.opsForValue().get(bytes);
        redisTemplate.delete(bytes);
        return v;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.getConnectionFactory().getConnection().flushDb();

    }

    @Override
    public int size() {
        return redisTemplate.getConnectionFactory().getConnection().dbSize().intValue();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Set<K> keys() {
        byte[] bytes = (getPrefix()+"*").getBytes();
		Set<byte[]> keys = redisTemplate.keys(bytes);
        Set<K> sets = new HashSet<>();
        for (byte[] key:keys) {
            sets.add((K)key);
        }
        return sets;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = keys();
        List<V> values = new ArrayList<>(keys.size());
        for(K k :keys){
            values.add(get(k));
        }
        return values;
    }

    private byte[] getBytesKey(K key){
        if(key instanceof String){
            String prekey = this.getPrefix() + key;
            return prekey.getBytes();
        }else {
            return ObjectUtil.serialize(key);
        }
    }

}
