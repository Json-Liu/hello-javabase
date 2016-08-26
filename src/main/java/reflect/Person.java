package reflect;

/**
 * 一个Person类 包含 name,age,school等属性 用于作反射测试用
 * @author JosonLiu
 *
 */
public class Person extends Human implements IPerson {
    private String name;
    private Integer age;
    private String school;
    public Person(){
        this.name = "";
        this.age = 0;
        this.school = "";
    }
    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
        this.school = "";
    }
    public Person(String name,Integer age,String school){
        this.name = name;
        this.age = age;
        this.school = school;
    }
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
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", school=" + school + "]";
    }
    @Override
    public void sayHello() {
        System.out.println(name+" say Hello to you.");
    }
    public void sayHelloToSomeOne(String userName) {
        System.out.println(userName+" say Hello to you.");
    }
}
