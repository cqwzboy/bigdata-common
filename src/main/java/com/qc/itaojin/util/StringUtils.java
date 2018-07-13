package com.qc.itaojin.util;

import org.springframework.util.Assert;

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

    /**
     * 首字母转大写
     * */
    public static String firstCharUpper(String data){
        Assert.hasLength(data, "data must not be null");
        return contact(data.substring(0, 1).toUpperCase(), data.substring(1));
    }

    /**
     * 首字母转小写
     * */
    public static String firstCharLower(String data){
        Assert.hasLength(data, "data must not be null");
        return contact(data.substring(0, 1).toLowerCase(), data.substring(1));
    }

    /**
     * 转为驼峰格式
     * */
    public static String converseToHump(String field){
        Assert.hasLength(field, "field must not be null");
        String _target = field;
        int _j = _target.length();
        for (int _i = 0; _i < _j; _i++) {
            byte ascii = (byte) _target.charAt(_i);
            if(ascii>=65 && ascii<=90){
                if(_i == 0){
                    _target = firstCharLower(_target);
                }else{
                    byte preAscii = (byte) _target.charAt(_i-1);
                    if(preAscii == 95){
                        _target = StringUtils.contact(_target.substring(0, _i), firstCharLower(_target.substring(_i)));
                    }else{
                        _target = StringUtils.contact(_target.substring(0, _i), "_", firstCharLower(_target.substring(_i)));
                        _j ++;
                        _i ++;
                    }
                }
            }
        }

        return _target;
    }

    public static void main(String[] args){
        String s = "FieldName_A_ZhangSan";
        System.out.println(converseToHump(s));
    }

}
