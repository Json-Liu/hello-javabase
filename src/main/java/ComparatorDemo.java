import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComparatorDemo {
	public static void main(String[] args) {
		Map<Integer, Long> dataMap = new HashMap<Integer, Long>();
		dataMap.put(1, 2L);
		dataMap.put(2,2L);
		List<Data> toBeSortDataList = new ArrayList<>();
		for(int i = 0 ;i < 3 ; i++){// init list
			Data each = new Data();
			each.setId(i+1);
			each.setAddTime(dataMap.get(i));
			toBeSortDataList.add(each);
		}
		System.out.println("before sort:");
		for (Data each : toBeSortDataList) {
			System.out.println(each);
		}
		//Collections.sort(toBeSortDataList, new DataComparator());// sort list by the wrong way.
		Collections.sort(toBeSortDataList, new DataComparatorRevise());// sort list by the right way.
		System.out.println("after sort:");
		for (Data each : toBeSortDataList) {
			System.out.println(each);
		}
	}
}
class Data{
	private int id;
	private Long addTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getAddTime() {
		return addTime;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", addTime=" + addTime + "]";
	}
	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}
}
class DataComparator implements Comparator<Data>{
	@Override
	public int compare(Data o1, Data o2) {// order by add time desc.
		Long addTime1 = o1.getAddTime();
		Long addTime2 = o2.getAddTime();
		Long diff = addTime2 - addTime1;
		return  diff.intValue();
	}
	
}
class DataComparatorRevise implements Comparator<Data>{
	@Override
	public int compare(Data o1, Data o2) {// order by add time desc.
		Long addTime1 = o1.getAddTime() == null?0L:o1.getAddTime();
		Long addTime2 = o2.getAddTime()== null?0L:o2.getAddTime();
		int result = addTime1.compareTo(addTime2);
		System.out.println(result);
		return -addTime1.compareTo(addTime2);
	}
}