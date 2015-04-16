package com.darcycasselman.cachedemo;

import java.util.HashMap;
import java.util.Map;

public class LruCacheImpl implements LruCache {

	private static int DEFAULT_CACHE_SIZE = 10;
	
	private Map<Object, Object> cache = new HashMap<>();
	
	private int maxSize;
	
	public LruCacheImpl(int maxSize) {
		this.maxSize = maxSize;
	}

	public LruCacheImpl() {
		this(DEFAULT_CACHE_SIZE);
	}

	@Override
	public Object get(Object key) {
		return cache.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		cache.put(key, value);
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

}
