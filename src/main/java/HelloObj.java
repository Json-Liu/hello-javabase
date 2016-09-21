import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import utils.JsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/***
 ** @Author JosonLiu
 ** @Date 2016年9月19日
 ** @Version 1.0
 **/
public class HelloObj {
	public static ObjectMapper objectMapper = JsonUtils.getObjectMapper();
	public static void main(String[] args) {
		objForceConverToLong();
		objForceConverToLongList();
		objForceConverToLong_JsonConver();
		objForceConverToLongInMap_JsonConver();
		//test();
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
		Long test = 50075120L;
		Map<String, Object> map = Maps.newHashMap();
		map.put("test", test);
		Map<String, Object> dataMap = Maps.newHashMap();
		dataMap.put("code", 1);
		dataMap.put("result", 50075121L);
		map.put("data", dataMap);
		String jsonStr = JsonUtils.objToStr(map);
/*		Map<String, Object> converResult = JsonUtils.strToObj(jsonStr, new TypeReference<Map<String, Object>>(){});
		Long testLong = (Long) converResult.get("test");*/
		Long result = getResult(jsonStr, new TypeReference<Long>() {});
		Assert.assertTrue( result instanceof Long );
		System.out.println(result);
	}
	public static void objForceConverToLongList_JsonConver(){
		List<Long> list = Lists.newArrayList(50075120L,50075121L);
		Map<String, Object> map = Maps.newHashMap();
		Map<String, Object> dataMap = Maps.newHashMap();
		dataMap.put("code", 1);
		dataMap.put("result", list);
		map.put("data", dataMap);
		String jsonStr = JsonUtils.objToStr(map);
		List<Long> uidList = getResult(jsonStr, new TypeReference< List<Long> >() {});
		for (int i = 0; i < uidList.size(); i++) {//出错
			Assert.assertTrue(uidList.get(i) + " is not Long ", uidList.get(i) instanceof Long);
			System.out.println(uidList.get(i));
		}
	}
	@SuppressWarnings("unchecked")
	private static<T extends Object> T getResult (String response,TypeReference typeReference) {
		try {
			JsonNode root = objectMapper.readTree(response);
			int code = root.get("data").get("code").asInt();
			if( code != 1){
				throw new RuntimeException(" service error.");
			}
			String resultStr = root.get("data").get("result").toString();
			return (T) JsonUtils.strToObj(resultStr, typeReference);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(" service error.");
		}
	}
}

