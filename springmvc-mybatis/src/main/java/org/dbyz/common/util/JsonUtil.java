package org.dbyz.common.util;

import com.alibaba.fastjson.JSON;
/**
 * Json 工具类(具体实现后期可变)
 *
 * @ClassName: JsonUtil
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a> 
 * @version: V1.0
 */
public class JsonUtil {
	/**
	 * 对象转换成JSON
	 * 
	 * @Title: objectToJson
	 * @param @param t
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static <T> String objectToJson(T t) {
		return JSON.toJSONString(t);
	}

	/**
	 * JSON转化成对象
	 * 
	 * @Title: jsonToObject
	 * @param @param json
	 * @param @param clazz
	 * @param @return
	 * @return: T
	 * @since V1.0
	 */
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
}
