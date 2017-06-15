package com.rev.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheDemo {
    public static void main(String[] args) {
        CacheManager cm = CacheManager.getInstance();

        cm.addCache("defaultCache");
        Cache cache = cm.getCache("defaultCache");
//        Cache cache = cm.getCache("myAwesomeCache");

        cache.put(new Element("1", "Jan"));
        cache.put(new Element("2", "Feb"));
        cache.put(new Element("3", "Mar"));

        // get element
        Element e = cache.get("1");
        String eExists = (String) (e == null ? null : e.getObjectValue());

        System.out.println(eExists);

        // does key/element exist?
        System.out.println(cache.isKeyInCache("2"));
        System.out.println(cache.isKeyInCache("6"));


        // shut down the cache manager
        cm.shutdown();
    }
}
