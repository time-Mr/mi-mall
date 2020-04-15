package com.time.demo.util;

import org.springframework.stereotype.Component;

/**
 * 判空工具类
 * <p>
 * Description: mi-mall
 * Created by time on 2020/2/27 下午8:34
 *
 * @author time
 */
@Component
public class VerdictUtil {

    /**
     * 判断不为空
     *
     * @param o 需要判断的对象
     * @return 不为空则true，为空则false
     */
    public static boolean isNotNull(Object o) {
        return o != null && !"".equals(o);
    }

    /**
     * 判断为空
     *
     * @param o 需要判断的对象
     * @return 为空则true，不为空则false
     */
    public static boolean isNull(Object o) {
        return o == null || "".equals(o);
    }

    /**
     * 判断是否为空
     *
     * @param o 需要判断的对象
     * @return 不为空返回原对象，为空返回null
     */
    public static Object isNullString(Object o) {
        if (isNotNull(o)) {
            return o;
        }
        return null;
    }

    /**
     * 判断是否成立 成立则返回1,否则返回0
     *
     * @param b 判断的对象
     * @return 返回true或false
     */
    public static int returnInt(boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }
}
