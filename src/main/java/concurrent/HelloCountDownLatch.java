package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloCountDownLatch {
	private static CountDownLatch countDownLatch = new CountDownLatch(4);
	private static ExecutorService service = Executors.newCachedThreadPool();
	public static void main(String[] args) throws InterruptedException {
		//	test_Base();
	//	List<Integer> mainList = new ArrayList<>();
		Map<Integer, String> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 20001; ) {
			service.execute(new addToListTask(countDownLatch,i,map));
			i+=500;
		}
		countDownLatch.await();
		for (Map.Entry<Integer, String> each : map.entrySet()) {
			System.out.println(each);
		}
		System.out.println(" size: "+map.size());
	}
	static class addToListTask implements Runnable{
		private final CountDownLatch countDownLatch;
		private  Integer startIndex;
		private final Map<Integer, String> map;
		public addToListTask(CountDownLatch countDownLatch,Integer startInex,Map<Integer, String> map ){
			this.countDownLatch = countDownLatch;
			this.startIndex = startInex;
			this.map = map;
		}
		@Override
		public void run(){
			int count = 500;
			while (count > 0 ) {
				map.put(startIndex++, String.valueOf(startIndex));
				count--;
				}
			countDownLatch.countDown();
			try {
				countDownLatch.await();
				System.out.println(Thread.currentThread().getName()+" compeleted..");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void test_Base() {
		System.out.println("before work start  countDownLatch size :"+countDownLatch.getCount());
		service.execute(new AddMonths1(countDownLatch));
		service.execute(new AddMonths2(countDownLatch));
		service.execute(new AddMonths3(countDownLatch));
		service.execute(new AddMonths4(countDownLatch));
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after work done countDownLatch size :"+countDownLatch.getCount());
	}
    static class AddMonths1 implements Runnable{
    	private final CountDownLatch countDownLatch;
    	public AddMonths1(CountDownLatch countDownLatch){
    		this.countDownLatch = countDownLatch;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths1 start....");
				Thread.sleep(1000);
				System.out.println("AddMonths1 end....");
				countDownLatch.countDown();
				System.out.println("AddMonths1 countDownLatch size:"+countDownLatch.getCount());
				countDownLatch.await();//等待
				System.out.println("AddMonths1 work continue...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
    static class AddMonths2 implements Runnable{
    	private final CountDownLatch countDownLatch;
    	public AddMonths2(CountDownLatch countDownLatch){
    		this.countDownLatch = countDownLatch;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths2 start....");
				Thread.sleep(2000);
				System.out.println("AddMonths2 end....");
				countDownLatch.countDown();
				System.out.println("AddMonths2 countDownLatch size:"+countDownLatch.getCount());
				countDownLatch.await();//等待
				System.out.println("AddMonths2 work continue...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
    static class AddMonths3 implements Runnable{
    	private final CountDownLatch countDownLatch;
    	public AddMonths3(CountDownLatch countDownLatch){
    		this.countDownLatch = countDownLatch;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths3 start....");
				Thread.sleep(3000);
				System.out.println("AddMonths3 end....");
				countDownLatch.countDown();
				System.out.println("AddMonths3 countDownLatch size:"+countDownLatch.getCount());
				countDownLatch.await();//等待
				System.out.println("AddMonths3 work continue...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
    static class AddMonths4 implements Runnable{
    	private final CountDownLatch countDownLatch;
    	public AddMonths4(CountDownLatch countDownLatch){
    		this.countDownLatch = countDownLatch;
    	}
		@Override
		public void run() {
			try {
				System.out.println("AddMonths4 start....");
				Thread.sleep(4000);
				System.out.println("AddMonths4 end....");
				countDownLatch.countDown();
				System.out.println("AddMonths4 countDownLatch size:"+countDownLatch.getCount());
				countDownLatch.await();//等待
				System.out.println("AddMonths4 work continue...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
}
