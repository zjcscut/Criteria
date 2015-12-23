package cn.ppfix.util;

import com.alibaba.fastjson.JSON;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/19-12:49
 */
public class Json {

    public static String toJson(Object s) {
        if (s != null) {
            return JSON.toJSONString(s);
        } else
            return null;
    }
}
