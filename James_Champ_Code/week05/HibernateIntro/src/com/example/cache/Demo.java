package com.example.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Demo {
	public static void main(String[] args) {
		CacheManager cm = CacheManager.getInstance();
		// get cache from xml
		Cache cache = cm.getCache("myAwesomeCache");
		
		// add element to cache
		cache.put(new Element("1", "Jan"));
		cache.put(new Element("11", "Jul"));
		cache.put(new Element("21", "Dec"));

		// get element
		Element e = cache.get("1");
		
		String eExists = (e==null ? null : e.getObjectValue().toString());
		System.out.println(eExists);
		
		// does key/element exist?
		System.out.println(cache.isKeyInCache("2"));
		System.out.println(cache.isKeyInCache("11"));
		
		// create new cache w/ default config
		cm.addCache("defaultCache");
		Cache c2 = cm.getCache("defaultCache");
		
		System.out.println("default cache");
		
		// shut down cache manager
		cm.shutdown();
	}
}
