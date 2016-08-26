import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 本例主要介绍了Set的常见用法 包括向Set添加、删除元素 遍历Set的两种方式等。Set的底层实现逻辑就是Map
 * @author JosonLiu
 */
public class HelloSet {
    public static void main(String[] args){
        Set<Integer> helloSet = new HashSet<Integer>();
        for(int i =0 ; i< 10 ;i++ ){
            helloSet.add(i);//初始化
        }
        System.out.println("traverse with iterator:");
        /*利用迭代器进行遍历*/
        Iterator<Integer> iterator = helloSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" , ");
        }
        System.out.println("\ntraverse with for:");
        /*利用FOR循环遍历*/
        for(Integer intVal : helloSet){
            System.out.print(intVal+" , ");
        }
        helloSet.remove(9);//移除一个元素9
        System.out.println("\ntransfer to array:");
        Integer[] arrayInt = new Integer[helloSet.size()];
        arrayInt = helloSet.toArray(arrayInt);
        for(Integer intVal : arrayInt){
            System.out.print(intVal+" , ");
        }
    }
}
