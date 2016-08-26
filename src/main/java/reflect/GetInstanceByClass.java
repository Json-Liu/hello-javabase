package reflect;

import java.lang.reflect.*;

public class GetInstanceByClass {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> personClass = null;
        try {
            personClass = Class.forName("reflect.Person");//根据类的完整路径得到Class实例 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //获取所有的公用构造函数
            Constructor<?>[] constructors = personClass.getConstructors();
            for(Constructor<?> tempConstructor : constructors){
                System.out.print("Constructor:");
                int mo = tempConstructor.getModifiers();//获取构造函数属性 ：public protected private
                System.out.print(Modifier.toString(mo)+" ");//将属性值转换为字符串输出
                System.out.print(tempConstructor.getName()+"(");//获取构造函数名称
                Class<?>[] params = tempConstructor.getParameterTypes();//获取当前构造函数的参数列表
                for(int i = 0;i< params.length;i++){
                    System.out.print(params[i].getName()+"  args"+i);//获取参数类型 并输出
                    if(i<params.length -1){
                        System.out.print(",");
                    }
                }
                System.out.println("){}");
            }
            //利用Class实例 根据特定的构造函数参数 得到其构造函数对象
            Constructor<?> constructor = personClass.getConstructor(String.class,Integer.class);
            //根据构造函数对象进行对象实例的创建
            Person person = (Person) constructor.newInstance("JosonLiu",26);
            System.out.println(person);
            //通过无参构造函数实例化对象  PS:如果类中有 有参构造函数时 ，默认的无参构造函数会取消，此时要调用无参构造函数则必须在类中显示声明无参构造函数，否则会报错。
            Person person2 = (Person) personClass.newInstance();
            System.out.println(person2);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } 
    }

}
