package com.ex.main;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheDemo {

  public static void main(String[] args) {
    CacheManager cman = CacheManager.getInstance();
    Cache cache = cman.getCache("myAwesomeCache");
//    Cache cache = cman.getCache("blahblahblah");
    cache.put(new Element("1", "January"));
    cache.put(new Element("6", "June"));
    cache.put(new Element("12", "December"));
    
    Element e = cache.get("1");
    String eExists = (e == null) ? null : e.getObjectValue().toString();
    System.out.println(eExists);
    
    
    
    // does key/element exist
    System.out.println(cache.isKeyInCache("2"));
    System.out.println(cache.isKeyInCache("12"));
    
    
    
    
    // shut down cache manager
    cman.shutdown();
  }

}
