import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class HelloSortMap {
	public static void main(String[] args) {
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> exp = new TreeMap<>(new Comparator<Integer>(
				) {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 大的排前面
				return  o2-o1;
			}
		});
		for (int i = 0; i < 20; i++) {
			int value = 0;
			int key = i%8;
			value = i%8 + i;
			if(data.containsKey(key)){
				int oldValue = data.get(key);
				value += oldValue;
			}
			data.put(key, value);
		}
		data.put(100, 100);
		for (Map.Entry<Integer, Integer> eachEntry : data.entrySet()) {
			int key = eachEntry.getValue();
			int value = eachEntry.getKey();
			while(exp.containsKey(key)){
				key+=1;
			}
			if(exp.size() >= 8){
				int lastKey = exp.pollLastEntry().getKey();
				if(key > lastKey){
					System.out.println(lastKey);
					exp.remove(lastKey);
					exp.put(key, value);
				}
			}else{
				exp.put(key, value);
			}
		}
		for (Map.Entry<Integer, Integer> eachEntry : exp.entrySet()) {
			System.out.println("key:"+eachEntry.getKey()+",value:"+eachEntry.getValue());
		}
		System.out.println("last:"+exp.pollLastEntry().getKey());
		System.out.println("last:"+exp.pollLastEntry().getKey());
		System.out.println(exp.size());
	}
}
