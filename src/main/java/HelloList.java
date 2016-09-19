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

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
/**
 * 主要实现了对LIST进行遍历、排序、去重等操作
 * @author josonLiu
 *
 */
public class HelloList {
    public static void main(String[] args){
/*    	test_GetSubList();*/
    }
	private static void test_GetSubList() {
		HelloList helloList = new HelloList();
    	List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
    	List<Integer> sublist = helloList.getSublist(list, 1, 2);
    	System.out.println(list.indexOf(5));
    	System.out.println(sublist);
    	List<Integer> sublist2 = helloList.getSublist(list, 2, 10);
    	System.out.println(sublist2);
    	List<Integer> sublist3 = helloList.getSublist(list, 0, 10);
    	System.out.println(sublist3);
	}
    public<E> List<E> getSublist(List<E> list,Integer startIndex,Integer count ){
    	final List<E> tempList = list;
    	int size = tempList.size();
    	if( list == null ){
    		return Lists.newArrayList();
    	}
    	if( startIndex < 0 ){
    		throw new IllegalArgumentException(" startIndex must > 0");
    	}
    	int toIndex = startIndex + count;
    	if( toIndex > size ){
    		toIndex = size;
    	}
    	return tempList.subList(startIndex, toIndex);
    }
    private void printList(){
    	
    }
}
