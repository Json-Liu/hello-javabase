package executors;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/***
 ** @Author JosonLiu
 ** @Date 2016年7月30日
 ** @Version 1.0
 ***/
public class ExecutorsDemo {
	private static final ScheduledExecutorService executor =  Executors.newScheduledThreadPool(2, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, "test-thread");
		}
	});
	public static void main(String[] args) {
		executor.scheduleAtFixedRate(new TaskDemo(), 0L, 1L, TimeUnit.SECONDS);
		executor.execute(new TaskDemo2());
	}
	protected static class TaskDemo implements Runnable{
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName() + " is running...");
		}
	}
	protected static class TaskDemo2 implements Runnable{
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName() + " is running... Just One");
		}
	}
}
