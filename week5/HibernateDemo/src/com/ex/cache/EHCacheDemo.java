package com.ex.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheDemo {
	
	public static void main(String[] args) {
		CacheManager cm = CacheManager.getInstance();
		Cache cache = cm.getCache("myAwesomeCache");
		
		//create new cache with default config
		cm.addCache("defaultCache");
		Cache dc=cm.getCache("defaultCache");
		
		System.out.println(dc.getName());
		System.out.println(dc.getCacheConfiguration().toString());
		System.out.println(cache.getCacheConfiguration().toString());
		
		//add element to cache
		cache.put(new Element("1","Jan"));
		cache.put(new Element("2","Feb"));
		cache.put(new Element("6","Jun"));
		
		//get element
		Element e = cache.get("1");
		String eExists = (e==null?null:e.getObjectValue().toString());
		System.out.println(eExists);
		
		//does key element exist?
		System.out.println(cache.isKeyInCache("2"));
		System.out.println(cache.isKeyInCache("6"));
		
		//shut down cache manager
		cm.shutdown();
		
	}
}