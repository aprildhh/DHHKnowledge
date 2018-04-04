package com.dhh.knowledge.util;

/**
 * Created by DHH on 2018/4/4.
 * 页面：
 */

class StringUtils {
    public static boolean isEmpty(String str) {

        if (str == null || "null".equals ( str ) || "".equals ( str )){
            return false;
        }

        return true;
    }
}
