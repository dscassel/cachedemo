package com.darcycasselman.cachedemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class LruCacheImpl implements LruCache {

	private static int DEFAULT_CACHE_SIZE = 10;
	
	private Map<Object, Object> cache = new HashMap<>();
	private LinkedList<Object> recentOrderList = new LinkedList<>();
	
	private int maxSize;
	
	public LruCacheImpl(int maxSize) {
		this.maxSize = maxSize;
	}

	public LruCacheImpl() {
		this(DEFAULT_CACHE_SIZE);
	}

	@Override
	public Object get(Object key) {
		if ( !recentOrderList.remove(key) ) {
			return null;
		}
		recentOrderList.push(key);
		
		return cache.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		if ( recentOrderList.size() >= maxSize ) {
			Object oldestKey = recentOrderList.removeLast();
			cache.remove(oldestKey);
		}
		
		recentOrderList.push(key);
		cache.put(key, value);
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		ListIterator<Object> iterator = recentOrderList.listIterator();
		while ( iterator.hasNext() ) {
			Object key = iterator.next();
			sb.append(key);
			sb.append("=");
			sb.append(cache.get(key));
			if ( iterator.hasNext() ) {
				sb.append(", ");
			}
			
		}
		sb.append("}");
		
		return sb.toString();
	}
	
	

}
