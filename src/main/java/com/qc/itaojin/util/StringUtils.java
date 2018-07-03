package com.qc.itaojin.util;

/**
 * @desc 字符串工具类
 * @author fuqinqin
 * @date 2018-04-16
 */
public class StringUtils {

    /**
     * 拼接字符串
     * */
    public static String contact(String... strs){
        if(strs == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 判断是否为空
     * */
    public static boolean isBlank(String data){
        return org.apache.commons.lang3.StringUtils.isBlank(data);
    }

    /**
     * 判断是否不为空
     * */
    public static boolean isNotBlank(String data){
        return org.apache.commons.lang3.StringUtils.isNotBlank(data);
    }

}
