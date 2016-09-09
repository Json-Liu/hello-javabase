package concurrent;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/***
 ** @Author JosonLiu
 ** @Date 2016年8月1日
 ** @Version 1.0
 ***/
public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
	private static void test(){
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.get("1");
	}
}
