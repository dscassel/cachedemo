package com.darcycasselman.cachedemo;
import static org.junit.Assert.*;

import org.junit.Test;


public class LruCacheTest {

	@Test
	public void testAddItem() {
		String key = "key";
		String value = "value";
		
		LruCache cache = new LruCacheImpl();
		cache.put(key, value);
		
		assertEquals(value, cache.get(key));
	}
	
	@Test
	public void testGetMaxSize() {
		int maxSize = 3;
		
		LruCache cache = new LruCacheImpl(3);
		
		assertEquals(maxSize, cache.getMaxSize());
	}
	
	@Test
	public void testToString() {
		LruCache cache = new LruCacheImpl();
		cache.put("key", "value");
		
		assertEquals("{key=value}", cache.toString());
	}
}
