package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/***
 ** @Author JosonLiu
 ** @Date 2016年8月26日
 ** @Version 1.0
 **/
public class JsonUtils {
	private static final ObjectMapper mapper = new ObjectMapper();
	public static <T> T strToObj(String jsonStr, Class<T> type) {
		try {
			return mapper.readValue(jsonStr, type);
		} catch (Exception e) {
			String msg = String.format("Failed to parse json %s", jsonStr);
			throw new RuntimeException(msg, e);
		}
	}
	
	/**
	 * 生成对象对应的JSON字符串.
	 * 
	 * @param obj
	 *            对象实例
	 * @exception e
	 *                对象为空时，底层抛出异常时，均会封装成RuntimeException抛出
	 * @return 返回生成的字符串
	 */
	public static String objToStr(Object obj) {
		if (obj == null) {
			throw new RuntimeException("Failed to map object, which is null");
		}
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			String msg = String.format("Failed to map object {}", obj);
			throw new RuntimeException(msg, e);
		}
	}
	/**
	 * 通过JSON字符串生成指定类型的引用对象
	 * @param jsonStr json串
	 * @param type 引用类型  T
	 * @return
	 * 		T 引用类型的对象实例
	 */
	public static <T> T strToObj(String jsonStr, TypeReference<T> type){
		try {
			return  mapper.readValue(jsonStr, type);
		} catch (Exception e) {
			String msg = String.format("Failed to parse json %s", jsonStr);
			throw new RuntimeException(msg, e);
		}
	}
}
