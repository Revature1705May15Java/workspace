package com.ex.main;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHcache_Demo {

	public static void main(String[] args) {
		CacheManager cm = CacheManager.getInstance();
		
		Cache cache = cm.getCache("myAwesomeCache");
		
		cm.addCache("defaultCache");
		
		Cache dc = cm.getCache("defaultCache");
		
		// add element
		cache.put(new Element("1","Jan"));
		cache.put(new Element("2","Feb"));
		cache.put(new Element("3","Mar"));
		
		// get element
		Element e = cache.get("1");
		System.out.println("Element: " + e);
		
		String eExists = (e==null ? null : e.getObjectValue().toString());
		System.out.println(eExists);
		System.out.println(cache.isKeyInCache("6"));
		System.out.println(cache.isKeyInCache("2"));
		
		//shutdown cache manager
		cm.shutdown();
	}

}