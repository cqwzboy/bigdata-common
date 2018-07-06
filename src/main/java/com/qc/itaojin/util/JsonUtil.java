package com.qc.itaojin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by fuqinqin on 2018/6/29.
 */
public class JsonUtil {

    public static String toJson(Object object){
        return JSON.toJSONString(object, SerializerFeature.IgnoreNonFieldGetter);
    }

    public static <T> T parse(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

}
