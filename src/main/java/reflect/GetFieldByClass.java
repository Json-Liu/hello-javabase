package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFieldByClass {

    public static void main(String[] args) {
        Class<?> personClass = null;
        try {
            personClass = Class.forName("reflect.Person");//根据类的完整路径得到Class实例 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Field[] publicFileds = personClass.getFields();//获取所有的公共属性
        for(Field tempField : publicFileds){
            System.out.printf("public fieldName:%s\n" , tempField.getName());
        }
        Field[] fileds = personClass.getDeclaredFields();//获取所有的属性
        for(Field tempField : fileds){//输出属性
            System.out.printf("%s fieldName:%s\n" ,Modifier.toString(tempField.getModifiers()),tempField.getName());
        }
        Field field = null;
        try {
            field = personClass.getDeclaredField("name");//按属性名称获取对象属性
            field.setAccessible(true);//设置属性为可访问状态
            Object obj = personClass.newInstance();//获取一个对象实例
            field.set(obj, "Man");//构造一个对象属性
            System.out.println(field.get(obj));//获取构造的属性值
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } 
        
    }

}
