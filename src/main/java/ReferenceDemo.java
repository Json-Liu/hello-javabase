import java.util.List;

import com.google.common.collect.Lists;

/***
 ** @Author JosonLiu
 ** @Date 2016年8月8日
 ** @Version 1.0
 **/
public class ReferenceDemo {
	public static void main(String[] args) {
		List<User> list1 = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			User each = User.newInstance();
			each.setAge(i);
			each.setName("User"+i);
			list1.add(each);
		}
		List<User> list2 = list1;
		User each = User.newInstance();
		each.setAge(3);
		each.setName("User3");
		list2.add(each);
		System.out.println(list1.size());
		System.out.println(list2.size());
	}
}

