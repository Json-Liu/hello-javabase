import java.util.List;
import java.util.Map;

import org.junit.Assert;

import utils.JsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/***
 ** @Author JosonLiu
 ** @Date 2016年9月19日
 ** @Version 1.0
 **/
public class HelloObj {
	public static void main(String[] args) {
		objForceConverToLong();
		objForceConverToLongList();
		objForceConverToLong_JsonConver();
		objForceConverToLongInMap_JsonConver();
		test();
		objForceConverToLongList_JsonConver();
	}
	public static void objForceConverToLong(){
		Long test = 1314L;
		Object obj = test;
		Long converToLong = (Long) obj;
		Assert.assertTrue( converToLong instanceof Long );
	}
	public static void objForceConverToLongList(){
		List<Long> list = Lists.newArrayList(50075120L,50075121L);
		Object obj = list;
		List<Long>  converResults = (List<Long>) obj;
		for (int i = 0; i < converResults.size(); i++) {
			Assert.assertTrue( converResults.get(i) instanceof Long );
		}
	}
	public static void objForceConverToLong_JsonConver(){
		Long test = 1314L;
		String jsonStr = JsonUtils.objToStr(test);
		Long converResult = JsonUtils.strToObj(jsonStr, Long.class);
		Assert.assertTrue( converResult instanceof Long );
	}
	public static void objForceConverToLongInMap_JsonConver(){
		//Long test = 50075120L;
		Long test = Integer.MAX_VALUE + 2L;
		Map<String, Object> map = Maps.newHashMap();
		map.put("test", test);
		String jsonStr = JsonUtils.objToStr(map);
		Map<String, Object> converResult = JsonUtils.strToObj(jsonStr, new TypeReference<Map<String, Object>>(){});
		Long testLong = (Long) converResult.get("test");
		Assert.assertTrue( testLong instanceof Long );
	}
	public static void test(){
		Long uid = 50075120L;
		Object longToObj = longToObj(uid);
		Long objToLong = objToLong(longToObj);
		Assert.assertTrue(objToLong + " is not Long ", objToLong instanceof Long);
	}
	private static Object longToObj(Long longObj){
		Object obj = longObj;
		return obj;
	}
	private static Long objToLong(Object obj){
		return (Long) obj;
	}
	public static void objForceConverToLongList_JsonConver(){
		List<Long> list = Lists.newArrayList(50075120L,50075121L);
		Map<String, Object> map = Maps.newHashMap();
		map.put("list", list);
		map.put("target", "test");
		String jsonStr = JsonUtils.objToStr(map);
		Map<String, Object> converResult = JsonUtils.strToObj(jsonStr,new TypeReference<Map<String, Object>>(){});
		List<Long> uidList = (List<Long>) converResult.get("list");
		for (int i = 0; i < uidList.size(); i++) {//出错
			Assert.assertTrue(uidList.get(i) + " is not Long ", uidList.get(i) instanceof Long);
		}
	}
}

