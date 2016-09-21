package executors;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 ** @Author JosonLiu
 ** @Date 2016年7月30日
 ** @Version 1.0
 ***/
public class ExecutorsWithBlockQueue {
	private static final ScheduledExecutorService POLL_EXECUTOR =  Executors.newSingleThreadScheduledExecutor();
	/**
	 * 最大未处理任务数，超出则丢弃
	 */
	private static final Integer MAX_TASK_NUM = 100;
	/**
	 * 执行线程池  最多滞留 1000
	 */
	private static final ThreadPoolExecutor EXECUTORS = new ThreadPoolExecutor(2, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(MAX_TASK_NUM));
	/**
	 * 任务队列1
	 */
	private static final BlockingQueue<Integer> WORK1 = new ArrayBlockingQueue<>(MAX_TASK_NUM);
	/**
	 * 任务队列2
	 */
	private static final BlockingQueue<Integer> WORK2 = new ArrayBlockingQueue<>(MAX_TASK_NUM);
	public static void main(String[] args) {
		POLL_EXECUTOR.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Integer task1 = WORK1.poll();
				if( task1 != null ){
					EXECUTORS.execute(new TaskDemo(task1));
				}
				Integer task2 = WORK2.poll();
				if( task2 != null ){
					EXECUTORS.execute(new TaskDemo2(task2));
				}
/*				try {
					EXECUTORS.execute(new TaskDemo(WORK1.take()));
				} catch (InterruptedException e) {
					//ignore
				}
				try {
					EXECUTORS.execute(new TaskDemo2(WORK2.take()));
				} catch (InterruptedException e) {
					// ignore
				}*/
			}
		}, 1, 100, TimeUnit.MILLISECONDS);//100毫秒轮循一次
		for(int i = 1 ; i< 20 ; i++){
			if(i % 2 == 0 ){
				WORK2.add(i);
			}else{
				WORK1.add(i);
			}
			if(i == 10 ){
				try {
					System.out.println("...................... sleep start ........................ at "+ new Date());
					Thread.sleep(5000);
					System.out.println("...................... sleep end ........................ at "+ new Date());
				} catch (InterruptedException e) {
					// ignore
				}
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// ignore
		}
		for (int i = 20; i < 30; i++) {
			if(i % 2 == 0 ){
				WORK2.add(i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// ignore
				}
			}
		}
	}
	private static class TaskDemo implements Runnable{
		private final Integer num ;
		public TaskDemo(Integer num ){
			this.num = num;
		}
		@Override
		public void run(){
			try {
				Thread.sleep(500);//摸拟操作
			} catch (InterruptedException e) {
				// ignore
			}
			System.out.println("work1 task num: " + num + " task is done." + " at "+ new Date());
		}
	}
	private static class TaskDemo2 implements Runnable{
		private final Integer num ;
		public TaskDemo2(Integer num ){
			this.num = num;
		}
		@Override
		public void run(){
			try {
				Thread.sleep(500);//摸拟操作
			} catch (InterruptedException e) {
				// ignore
			}
			System.out.println("work2 task num: " + num + " task is done."+ " at "+ new Date());
		}
	}
}
