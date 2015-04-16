package com.darcycasselman.cachedemo;

import java.util.HashMap;
import java.util.Map;

public class LruCacheImpl implements LruCache {

	private Map<Object, Object> cache = new HashMap<>();
	
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
