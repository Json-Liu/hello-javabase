package atomic;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Maps;

import static org.junit.Assert.*;

/***
 ** @Author JosonLiu
 ** @Date 2016年9月9日
 ** @Version 1.0
 **/
public class HelloAtomicInteger {
	public static void main(String[] args) {
		test_AtomicInteger();
		test_MapAto();
	}
	public static void test_MapAto(){
		Map<String,AtomicInteger> map = Maps.newConcurrentMap();
		map.put("test", new AtomicInteger(0));
		AtomicInteger oldValue = map.get("test");
		for (int i = 0; i < 10; i++) {
			System.out.println(oldValue.get());
			oldValue.getAndIncrement();
			map.put("test", oldValue);
			oldValue = map.get("test");
		}
	}
	public static void test_AtomicInteger(){
		AtomicInteger atomicInteger = new AtomicInteger(1);
		int oldValue = atomicInteger.get();
		assertTrue(oldValue == 1);
		int IncreValue = atomicInteger.getAndIncrement();
		assertTrue(atomicInteger.get() == 2);
		assertTrue(IncreValue ==  1);
	}
}

