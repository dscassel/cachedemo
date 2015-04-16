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
	
	@Test
	public void testToStringPrintsInReverseOrderOfInsertion() {
		LruCache cache = new LruCacheImpl(5);

		cache.put("five", 5);
		cache.put("four", 4);
		cache.put("three", 3);
		cache.put("two", 2);
		cache.put("one", 1);
		
		assertEquals("{one=1, two=2, three=3, four=4, five=5}", cache.toString());
	}

}
