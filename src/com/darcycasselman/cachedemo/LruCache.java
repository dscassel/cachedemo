package com.darcycasselman.cachedemo;

/**
 * Least Recently Used Cache. 
 * 
 * This cache keeps all items that have been used most recently, and discards the
 * ones that haven't been used in the longest amount of time as it becomes full.
 */
public interface LruCache {

	/**
	 * Retrieve from the cache
	 * @return the value associated with the key 'key'.
	 */
	Object get(Object key);
	
	/**
	 * Insert into the cache
	 * @param key The key used to retrieve the object
	 * @param value The object being stored
	 */
	void put(Object key, Object value);
	
	/**
	 * The maximum number of items that can be stored in the cache.
	 * @return The maximum size of the cache
	 */
	int getMaxSize();
	
	/**
	 * Returns a string representation of the items in the cache,
	 * including keys and values, in order of recent use.
	 * @return a string representation of the cache
	 */
	String toString();
	
}
