package com.zls;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class JavaEhCache {
	public static void main(String[] args) {
		//创建管理器
		CacheManager manager = CacheManager.create("./src/main/resources/ehcache.xml");
		//获取指定Cache
		Cache c = manager.getCache("a");
		//实例化一个元素
		Element e = new Element("java", "hello world");			
		//添加元素
		c.put(e);
		//取出元素
		Element E = c.get("java");
		
		System.out.println(E);
		System.out.println(E.getObjectValue());
		//刷新缓存
		c.flush();
		//关闭缓存
		manager.shutdown();
	}
}
