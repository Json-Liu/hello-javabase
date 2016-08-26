package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class HelloCyclicBarrier {
	private static CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
		@Override
		public void run() {
			System.out.println("barrier end...");
			System.out.println("end time:"+System.currentTimeMillis());
			System.out.println(barrier.getNumberWaiting());
		}
	});
	private static ExecutorService service = Executors.newCachedThreadPool();
	public static void main(String[] args) {
			System.out.println("start time:"+System.currentTimeMillis());
			System.out.println(barrier.getNumberWaiting());
			service.execute(new AddMonths1(barrier));
			service.execute(new AddMonths2(barrier));
			service.execute(new AddMonths3(barrier));
			service.execute(new AddMonths4(barrier));
			try {
				barrier.await();
				System.out.println("after work done..barrier size:"+barrier.getNumberWaiting());
			} catch (Throwable e) {
				e.printStackTrace();
			} 
	}
    static class AddMonths1 implements Runnable{
    	private final CyclicBarrier barrier;
    	public AddMonths1(CyclicBarrier barrier){
    		this.barrier = barrier;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths1 start....");
				Thread.sleep(1000);
				System.out.println("AddMonths1 end....");
				System.out.println("AddMonths1 barrier size:"+barrier.getNumberWaiting());
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
    	
    }
    static  class AddMonths2 implements Runnable{
    	private final CyclicBarrier barrier;
    	public AddMonths2(CyclicBarrier barrier){
    		this.barrier = barrier;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths2 start....");
				Thread.sleep(2000);
				System.out.println("AddMonths2 end....");
				System.out.println("AddMonths2 barrier size:"+barrier.getNumberWaiting());
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
    	
    }
    static  class AddMonths3 implements Runnable{
    	private final CyclicBarrier barrier;
    	public AddMonths3(CyclicBarrier barrier){
    		this.barrier = barrier;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths3 start....");
				Thread.sleep(3000);
				System.out.println("AddMonths3 end....");
				System.out.println("AddMonths3 barrier size:"+barrier.getNumberWaiting());
				barrier.await();
				System.out.println("AddMonths3 continue..");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
    	
    }
    static class AddMonths4 implements Runnable{
    	private final CyclicBarrier barrier;
    	public AddMonths4(CyclicBarrier barrier){
    		this.barrier = barrier;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths4 start....");
				Thread.sleep(4000);
				System.out.println("AddMonths4 end....");
				System.out.println("AddMonths4 barrier size:"+barrier.getNumberWaiting());
				barrier.await();
				System.out.println("AddMonths4 continue..");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
    	
    }
}
