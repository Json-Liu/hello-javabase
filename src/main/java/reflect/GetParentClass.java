package reflect;

public class GetParentClass {

    public static void main(String[] args) {
        Class<?> personClass = null;
        try {
            personClass = Class.forName("reflect.Person");//根据类的完整路径得到Class实例 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取Class实例继承的父类
        Class<?> ParentClass = personClass.getSuperclass();
        System.out.println("继承的父类为："+ParentClass.getName());
        //获取实现的接口
        Class<?>[] interfaceClass = personClass.getInterfaces();
        for(Class<?> tempClass : interfaceClass ){
            System.out.println("实现的接口："+tempClass.getName());
        }
    }

}
