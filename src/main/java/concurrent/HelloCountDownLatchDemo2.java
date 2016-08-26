package concurrent;

import java.util.concurrent.CountDownLatch;

public class HelloCountDownLatchDemo2 {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		Thread thread = new Thread(new Task(countDownLatch));
		Thread thread2 = new Thread(new Task(countDownLatch));
		System.out.println(countDownLatch.getCount());
		thread.start();
		thread2.start();
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(countDownLatch.getCount());
		System.out.println("all done..");
	}
	private static final class Task implements Runnable{
		private final CountDownLatch countDownLatch;
		public Task(CountDownLatch countDownLatch){
			this.countDownLatch = countDownLatch;
		}
		@Override
		public void run() {
			doSomething() ;
			countDownLatch.countDown();// to tell main thread ,one work has done.
			try {
				countDownLatch.await();
				recordSomething();
			} catch (InterruptedException e) {
				System.out.println("countDownLatch await is interrupted..");
				e.printStackTrace();
			}
		}
		/**
		 * do something after work done.
		 */
		private void recordSomething() {
			System.out.println(Thread.currentThread().getName()+" has down.");
		}
		/**
		 * simulate doing something
		 */
		private void doSomething() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("do something is interrupted.");
				e.printStackTrace();
			}
		}
		
	}
}
