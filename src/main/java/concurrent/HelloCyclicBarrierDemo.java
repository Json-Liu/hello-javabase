package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class HelloCyclicBarrierDemo {
	private static CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
		@Override
		public void run() {
			System.out.println("barrier end...");
			System.out.println("end time:"+System.currentTimeMillis());
			System.out.println(barrier.getNumberWaiting());
		}
	});
	public static void main(String[] args) {
			System.out.println("start time:"+System.currentTimeMillis());
			System.out.println(barrier.getNumberWaiting());
			for (int i = 0; i < 3; i++) {
				Thread thread = new Thread(new Worker(barrier),"thread"+i);
				thread.start();
			}
			Thread thread4 = new Thread(new Worker2(barrier),"thread4");
			thread4.start();
			thread4.interrupt();
	}
    static  class Worker implements Runnable{
    	private final CyclicBarrier barrier;
    	public Worker(CyclicBarrier barrier){
    		this.barrier = barrier;
    	}
		@Override
		public void run() {
			try {
				System.out.println("work start....");
				Thread.sleep(4000);	// simulate doing work.
				System.out.println("work end....");
				System.out.println(Thread.currentThread().getName()+" barrier size:"+barrier.getNumberWaiting());
			}catch (InterruptedException  e) {
				System.out.println(Thread.currentThread().getName()+" is Interrupted.");
				System.out.println(Thread.currentThread().getName()+" is Interrupted:"+Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();//reset interrupt state because of await will use it.
				System.out.println(Thread.currentThread().getName()+" is Interrupted:"+Thread.currentThread().isInterrupted());
			}
			try {
				barrier.await();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" is Interrupted...");
			} catch (BrokenBarrierException e) {
				System.out.println(Thread.currentThread().getName()+" is Broken.");
			}
			System.out.println(Thread.currentThread().getName()+" continue...");
		}
    }
    static  class Worker2 implements Runnable{
    	private final CyclicBarrier barrier;
    	public Worker2(CyclicBarrier barrier){
    		this.barrier = barrier;
    	}
		@Override
		public void run() {
			try {
				for(int i = 0 ; i<1000000;++i){
					//an empty loop to simulate doing something.
				}
				barrier.await();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" is Interrupted...");
				return;// return after interrupted.
			} catch (BrokenBarrierException e) {
				System.out.println(Thread.currentThread().getName()+" is Broken.");
			}
		}
    	
    }
}
