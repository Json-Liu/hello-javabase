import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 对MAP数据结构 进行遍历
 * @author josonLiu
 *
 */
public class HelloMap {
	private static final Map<Integer, User> map = new HashMap<>();
	private static ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
		private AtomicInteger count = new AtomicInteger();
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r,"joson-thread-"+count.getAndIncrement());
			return t;
		}
	});
	public HelloMap(){
		for(int i = 0; i < 5 ; i++ ){
			User user = User.newInstance();
			user.setAge(i);
			user.setName("user"+i);
			map.put(i, user);
		}
	}
    public static void main(String[] args){
/*        Map<Integer, String> helloMap = new HashMap<Integer, String>();
        for(int i = 0 ; i < 10 ; i++ ){
            //初始化MAP 将K-V键值对存入MAP中
            helloMap.put(i, "This number's Key is "+i);
        }
        for(Map.Entry<Integer,String > entry : helloMap.entrySet()){
            //这种遍历方法只需要O(N)即可遍历完所有元素的KEY和VALUE
            System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());
        }
    	new HelloMap();
        User user = map.get(1);
        user.setAge(100);
        System.out.println(map.get(1).getAge());
        map.put(6, User.newInstance());*/
/*    	Map<Integer, User> testMap = new HashMap<>();
    	for (int i = 0; i < 12; i++) {
    		if(testMap.size() == 3 ){
    			executorService.execute(new Worker(testMap));
    			testMap = new HashMap<>();
    		}
			User temp = User.newInstance();
			temp.setAge(i);
			temp.setName("user"+i);
			testMap.put(i, temp);
		}
    	if(testMap.size() > 0 && testMap.size() <= 3){
    		executorService.execute(new Worker(testMap));
    	}*/
    	Map<Long, Long> testMap = new HashMap<Long, Long>();
    	for(int i =0 ;i < 3 ; i++ ){
    		testMap.put(Long.valueOf(i), Long.valueOf(i));
    	}
    	addToMap(testMap);
    	scanMapByIterator(testMap);
    }
    private static void addToMap(Map<Long, Long> testMap){
    	testMap.put(11L, 11L);
    }
    static class Worker implements Runnable{
    	private final Map<Integer, User> userMap;
    	public Worker(Map<Integer, User> userMap){
    		this.userMap = userMap;
    	}
		@Override
		public void run() {
			for(Map.Entry<Integer, User> eachEntry : userMap.entrySet()){
				Integer key = eachEntry.getKey();
				User valUser = eachEntry.getValue();
				valUser.setAge(key+100);
				System.out.println(Thread.currentThread().getName()+" key:"+key+" value:"+ valUser);
			}
		}
    }
    private static void scanMapByIterator(Map<Long, Long> map){
    	Iterator<Entry<Long, Long>> iterator = map.entrySet().iterator();
    	while (iterator.hasNext()) {
			Entry<Long, Long> each = iterator.next();
			if(iterator.hasNext()){
				System.out.println(" ( Key:"+each.getKey()+"Value:"+each.getValue()+"),");
			}else{
				System.out.println(" ( Key:"+each.getKey()+"Value:"+each.getValue()+");");
			}
		}
    }
}
