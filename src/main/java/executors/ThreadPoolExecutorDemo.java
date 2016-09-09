package executors;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/***
 ** @Author JosonLiu
 ** @Date 2016年7月30日
 ** @Version 1.0
 ***/
public class ThreadPoolExecutorDemo {
	private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();
	private static final ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
	private static final BlockingQueue<Msg> workQueue= new ArrayBlockingQueue<Msg>(5000) ;
	public static void main(String[] args) {
		test_ExecutorLoop();
		Msg msg = new Msg();
		msg.setCode(genMsgId());
		msg.setValue(" Hello world,My name is Joson Liu...");
		workQueue.add(msg);
		boolean offer = workQueue.offer(msg);
	}
	private static void test_ExecutorLoop(){
		EXECUTOR.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Msg msg = workQueue.poll();
				if( msg != null ){
					AtomicInteger atomicInteger = map.get(msg.getCode());
					boolean isNeedToDo = false ;
					if( atomicInteger == null ){
						atomicInteger = new AtomicInteger(1);
						map.putIfAbsent(msg.getCode(), atomicInteger);
						isNeedToDo = true ;
					}
					else if( atomicInteger.incrementAndGet() < 4 ){
						map.put(msg.getCode(), atomicInteger);
						isNeedToDo = true ;
					}
					if( isNeedToDo ){
						System.out.println("This is the " + atomicInteger.get() + " time to do work...");
						Boolean result = publishMsg(msg);
						if( !result ){
							//失败重试
							workQueue.add(msg);
						}
					} 
				}else{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// ignore 
					}
				}
				
			}
		}, 1, 1, TimeUnit.SECONDS);
	}
	private static Boolean publishMsg(Msg msg) {
		System.out.println(msg);
		return false ;
	}
	private static String genMsgId(){
		return UUID.randomUUID().toString();
	}
	private static class Msg {
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getValue() {
			return value;
		}
		@Override
		public String toString() {
			return "Msg [code=" + code + ", value=" + value + "]";
		}
		public void setValue(String value) {
			this.value = value;
		}
		private  String code ;
		private  String value ;
	}
}
