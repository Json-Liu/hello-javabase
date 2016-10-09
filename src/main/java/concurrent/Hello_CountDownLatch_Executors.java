package concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***利用 CountDownLatch 来统计线程池的执行时间 
 ** @Author JosonLiu
 ** @Date 2016年9月22日
 ** @Version 1.0
 **/
public class Hello_CountDownLatch_Executors {
	private static final Integer MAX_THREAD_COUNT = 5 ;
	private static final ExecutorService EXECUTORS =  Executors.newFixedThreadPool(MAX_THREAD_COUNT);
	private static final CountDownLatch countDownLatch = new CountDownLatch(MAX_THREAD_COUNT);
	public static void main(String[] args) {
		computeExecuteTime();
	}
	private static void computeExecuteTime(){
		long startTime = System.currentTimeMillis();
		System.out.println("startTime: " + startTime);
		for(int i = 0 ;i < MAX_THREAD_COUNT; i++){
			int sleepTime = new Random().nextInt(5);
			EXECUTORS.execute(new Task(sleepTime));
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			//ignore
		}
		long endTime = System.currentTimeMillis();
		System.out.println("endTime: " + endTime);
		System.out.println(" cost time : " + (endTime - startTime ) / 1000 + " seconds");
	}
	private static class Task implements Runnable{
		private final Integer sleepTime ;
		public Task(Integer sleepTime){
			this.sleepTime = sleepTime;
		}
		@Override 
		public void run(){
			try {
				System.out.println(Thread.currentThread().getName()+" sleepTime: "+sleepTime);
				Thread.sleep(sleepTime*1000);
			} catch (InterruptedException e) {
				//ignore
				e.printStackTrace();
			}
			System.out.println(" sleep "+sleepTime + " seconds has done..");
			countDownLatch.countDown();
		}
	}
}

