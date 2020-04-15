package com.time.demo.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 * @author time
 */
public class RegularExpressionUtil {

    /**
     * 正则匹配
     *
     * @param text  需要匹配的字符串
     * @param rules 匹配的规则
     * @return 是否成功匹配
     */
    public static boolean parse(String text, String rules) {
        Pattern pattern = Pattern.compile(rules, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    /**
     * 生成订单号
     */
    public static final int MACHINE_ID = 1;

    public static String getOrderNumber() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        Date date = new Date();
        return MACHINE_ID + String.format("%015d", hashCodeV) + date.getTime();
    }

    /**
     * 将一个 JavaBean 对象转化为一个 Map
     *
     * @param bean 需要转换的bean
     * @return 转化出来的 Map 对象
     * @throws Exception
     */
    public static Map<String, Object> convertBean(Object bean)
            throws Exception {
        Class type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<>(1);
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            String propertyName = descriptor.getName();
            if (!"class".equals(propertyName)) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }

}
