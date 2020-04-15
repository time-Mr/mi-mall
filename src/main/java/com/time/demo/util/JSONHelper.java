package com.time.demo.util;

import net.sf.json.JSONObject;

/**
 * json装换
 *
 * @author time
 */
public final class JSONHelper {


    /**
     * 将JSON转换成POJO,其中beanClz为POJO的Class
     *
     * @param json    需要转换的json字符串
     * @param beanClz 将要转换的自定义类
     * @return 转换后的自定义类结果
     */
    public static Object json2Object(String json, Class beanClz) {
        return JSONObject.toBean(JSONObject.fromObject(json), beanClz);
    }

}