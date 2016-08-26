import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.event.ListSelectionEvent;
/**
 * 主要实现了对LIST进行遍历、排序、去重等操作
 * @author josonLiu
 *
 */
public class HelloList {
    public static void main(String[] args){
    	Map<Integer, Integer> testMap = new HashMap<>();
    	List<Integer> testList = new ArrayList<>();
    	addToList(testList);
    	addToMap(testMap);
    	System.out.println(testList.size());
    	System.out.println(testMap.size());
    	
    }
    public static void  addToList( List<Integer> list){
    	list.add(1);
    	/*List<Integer> otherList = new ArrayList<>();
    	otherList.add(2);
    	otherList.add(3);
    	list=otherList;
    	System.out.println(list.size());
    	list.add(66);*/
    }
    private static void addToMap(Map<Integer,Integer> map){
    	map.put(1, 1);
    	
    	/*Map<Integer, Integer> otherMap = new HashMap<>();
    	otherMap.put(1, 1);
    	otherMap.put(2, 2);
    	map = otherMap;
    	System.out.println(map.size());
    	map.put(6, 6);*/
    }
}
