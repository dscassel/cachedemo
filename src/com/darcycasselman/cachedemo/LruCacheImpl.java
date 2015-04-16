package com.darcycasselman.cachedemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class LruCacheImpl implements LruCache {

	private static int DEFAULT_CACHE_SIZE = 10;
	
	private Map<Object, Object> cache = new HashMap<>();
	private LinkedList<Object> index = new LinkedList<>();
	
	private int maxSize;
	
	/**
	 * Constructs a new cache, specifying a maximum size.
	 * @param maxSize The maximum size of the cache.
	 */
	public LruCacheImpl(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * Constructs a new cache, with a default maximum size.
	 */
	public LruCacheImpl() {
		this(DEFAULT_CACHE_SIZE);
	}

	@Override
	public Object get(Object key) {
		if ( !index.remove(key) ) {
			return null;
		}
		index.push(key);
		
		return cache.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		if ( index.size() >= maxSize ) {
			Object oldestKey = index.removeLast();
			cache.remove(oldestKey);
		}
		
		if ( null == cache.put(key, value) ) {
			index.push(key);
		} else {
			index.remove(key);
			index.push(key);
		}
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		ListIterator<Object> iterator = index.listIterator();
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
