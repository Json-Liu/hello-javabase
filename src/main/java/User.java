

import java.util.concurrent.atomic.AtomicInteger;

public class User {
	private String name ;
	private Integer age;
	private static AtomicInteger count =new AtomicInteger(0);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 返回一个新的实例
	 * @return
	 */
	public static User newInstance(){
		User instance = new User();
		instance.setAge(count.getAndIncrement());
		instance.setName("user "+count);
		return instance;
	}
	private User(){}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}
