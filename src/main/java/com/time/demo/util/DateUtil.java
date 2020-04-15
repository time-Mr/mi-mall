package com.time.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 解析时间
 *
 * @author time
 */
public class DateUtil {

    /**
     * 解析时间
     *
     * @param dateStr 解析的时间字符串
     * @param pattern 解析的规则
     * @return 解析后的时间格式
     */
    public static Date parse(String dateStr, String pattern) {
        try {
            DateFormat format = new SimpleDateFormat(pattern);
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
