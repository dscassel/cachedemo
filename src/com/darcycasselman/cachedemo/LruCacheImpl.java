package com.darcycasselman.cachedemo;

import java.util.HashMap;
import java.util.Map;

public class LruCacheImpl implements LruCache {

	private Map<Object, Object> cache = new HashMap<>();
	
	public LruCacheImpl(int i) {
		// TODO Auto-generated constructor stub
	}

	public LruCacheImpl() {
		this(1);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
