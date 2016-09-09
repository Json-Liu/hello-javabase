import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 ** @Author JosonLiu
 ** @Date 2016年9月2日
 ** @Version 1.0
 **/
public class HelloConcurrentHashMap {
	public static void main(String[] args) {
		test(null );
	}
	private static void test( Boolean flag ){

		while  ( flag ) {
			System.out.println("Hello world..");
		}
	}
}

