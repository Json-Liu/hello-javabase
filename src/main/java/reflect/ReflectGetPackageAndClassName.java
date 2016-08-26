package reflect;

import java.lang.reflect.Method;

/**
 * 根据对象 利用反射获取对象的类名和包名
 * @author JoosonLIu
 *
 */
public class ReflectGetPackageAndClassName {
    public static void main(String[] args){
        Person testPerson = new Person();
        /*所有类的对象都是Class的实例*/
        Class<Person> personClass;
        //通过对象获取Class实例
         personClass = (Class<Person>) testPerson.getClass();
        try {
            //根据类路径获取Class实例   一般尽量用这种形式
             personClass = (Class<Person>)Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //直接根据类名称获取类实例   
        personClass = Person.class;
        String packageName = personClass.getName();//获取类的打包路径
        String className = personClass.getSimpleName();//获取类名
        System.out.println("packageName:"+packageName+",className:"+className);//输出
        
    }
}
