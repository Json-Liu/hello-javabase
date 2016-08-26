package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMethodByClass {

    public static void main(String[] args) throws Throwable {
        Class<?> personClass = null;
        try{
            personClass = Class.forName("reflect.Person");
        }catch(Exception e){
            e.printStackTrace();
        }
        Method[] methods = personClass.getDeclaredMethods();//获取类中的所有方法
        for(Method tempMethod : methods ){
            System.out.printf("%s %s : (",Modifier.toString(tempMethod.getModifiers()),tempMethod.getName());
            Class<?>[] params = tempMethod.getParameterTypes();//获取方法的参数数组
            for(int i = 0;i< params.length;i++ ){
                System.out.print(params[i].getName() + " args"+i);
                if(i<params.length - 1){
                    System.out.println(",");
                }
            }
            System.out.print(")\n");
        }
//        sayHelloToSomeOne
        Method method = personClass.getDeclaredMethod("sayHello");
        method.invoke(personClass.newInstance());
        Person person = (Person) personClass.newInstance();
        person.setName("JosonLiu");
        Method  method2 = personClass.getDeclaredMethod("sayHelloToSomeOne", String.class);
        method2.invoke(person, "JosonLiu");
    }

}
