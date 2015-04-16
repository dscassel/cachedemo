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

}
