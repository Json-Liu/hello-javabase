package executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 ** @Author JosonLiu
 ** @Date 2016年7月30日
 ** @Version 1.0
 ***/
public class ThreadPoolExecutorDemo {
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5,// core thread size
														10, // max thread size
														0L, // keep alive
														TimeUnit.SECONDS, // time unit
														new ArrayBlockingQueue<Runnable>(10));// working queue
	
	public static void main(String[] args) {
		
	}
}
