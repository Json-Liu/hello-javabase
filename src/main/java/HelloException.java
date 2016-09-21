/***
 ** @Author JosonLiu
 ** @Date 2016年9月20日
 ** @Version 1.0
 **/
public class HelloException {
	public static void main(String[] args) {
		test(2);
		test(3);
	}
	public static void test(Integer number ){
		if( isEven(number)){
			print(number);
		}
	}
	public static boolean isEven(Integer number){
		if( number % 2 == 0){
			return true ;
		}
		throw new RuntimeException( number + " is not even. ");
	}
	public static void print(Integer number ){
		System.out.println( number + " is even number.");
	}
}

