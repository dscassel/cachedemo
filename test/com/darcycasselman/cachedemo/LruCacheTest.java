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
	
	@Test
	public void testToStringPrintsInReverseOrderOfAccess() {
		LruCache cache = new LruCacheImpl(5);

		cache.put("one", 1);
		cache.put("two", 2);
		cache.put("three", 3);
		cache.put("four", 4);
		cache.put("five", 5);
		
		cache.get("five");
		cache.get("four");
		cache.get("three");
		cache.get("two");
		cache.get("one");

		assertEquals("{one=1, two=2, three=3, four=4, five=5}", cache.toString());
	}
	
	@Test
	public void testEmptyToString() {
		LruCache cache = new LruCacheImpl();
		
		assertEquals("{}", cache.toString());
	}
	
	@Test
	public void testGetKeyNotFoundReturnsNull() {
		LruCache cache = new LruCacheImpl();
		
		assertNull("get of a missing key is not null", cache.get("test"));
	}
	
	@Test
	public void testCacheFullRemovesOldest() {
		LruCache cache = new LruCacheImpl(2);
		
		cache.put("three", 3);
		cache.put("two", 2);
		cache.put("one", 1);
		
		assertEquals("{one=1, two=2}", cache.toString());
	}
	

}
