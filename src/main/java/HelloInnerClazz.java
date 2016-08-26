
public class HelloInnerClazz {

	private int data = 0;
	public Inner inner = new Inner();
	private class Inner{//normal inner class
		public Inner(){}
		public void print(){
			System.out.println("out class data:"+data);
		}
	}
	private static class Inner2{// static class 
		public Inner2(){}
	}
	public void OutMethod(){// a part inner class
		final int beep = 0;// must be a final type
		class Inner3{
			public Inner3(){}
			void print(){
				System.out.println(beep);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("Hello inner class..");
	}
}
