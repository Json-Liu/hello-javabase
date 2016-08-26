import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用LinkedHashMap实现最近最少使用Cache算法
 * @author josonLiu
 *
 */
public class HelloLinkedHashMap<K,V> extends LinkedHashMap<K, V>{
    
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    /**
     * 最大存储数
     */
    private final int maxValue = 8;
    /**
     * 构造函数
     * @param initialCapacity 初始容量 默认为 1>>30
     * @param loadFactor 负载因子 默认为0.75
     * @param accessOrder 如果为true则按使用顺序排，如果为false则按插入顺序排
     */
    public HelloLinkedHashMap(int initialCapacity,float loadFactor,boolean accessOrder){
        super(initialCapacity,loadFactor,accessOrder);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        if(size() > maxValue){//当存储的数目达到最大值时，移除根据accessOrder移除元素
            System.out.println(" Key:"+eldest.getKey() +" Value:"+eldest.getValue() +" has been removed..");//打印移除日志
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        Map<Integer,String > helloLinkedHashMap = new HelloLinkedHashMap<Integer, String>(16, 0.75f, true);
        for(int i = 0 ; i < 10 ; i++ ){//初始化
            helloLinkedHashMap.put(i, "Value:"+i);
            if(i == 5){
                String temp = helloLinkedHashMap.get(0);//使用一下第一个插入的值，让其逃过删除
                System.out.println("Key: 0 "+"Value:"+temp+"have used.");
            }
        }
        for(Map.Entry<Integer, String> entry : helloLinkedHashMap.entrySet() ){
            System.out.println("Key:" + entry.getKey() + "Value:" + entry.getValue());
        }
    }
}
