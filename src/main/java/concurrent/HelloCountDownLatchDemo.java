package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/***
 ** @Author JosonLiu
 ** @Date 2016年8月22日
 ** @Version 1.0
 **/
public class HelloCountDownLatchDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < 10; i++){
			list.add(i);
		}
		CountDownLatch countDownLatch = new CountDownLatch(list.size());
		for (int i = 0; i < list.size(); i++) {
			new Thread( new Work("Thread: "+i, countDownLatch)).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" all task done");
	}
	private static class Work implements Runnable{
		private final String name ;
		private final CountDownLatch countDownLatch;
		public Work(String name, CountDownLatch countDownLatch){
			this.name = name ;
			this.countDownLatch = countDownLatch;
		}
		@Override
		public void run() {
			System.out.println( name + " is running" );
			try {
				Thread.sleep(1000);
				if( name.endsWith("9")){
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();
			System.out.println( name + " is done" );
		}
		
	}
}

