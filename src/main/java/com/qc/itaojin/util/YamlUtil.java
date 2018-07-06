package com.qc.itaojin.util;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * Created by fuqinqin on 2018/7/4.
 */
public class YamlUtil {

    private static final Yaml yaml = new Yaml();

    private static final ClassLoader classLoader = YamlUtil.class.getClassLoader();

    public static <T> T loadAs(String path, Class<T> clazz){
        if(StringUtils.isBlank(path) || clazz==null){
            return null;
        }

        return yaml.loadAs(classLoader.getResourceAsStream(path), clazz);
    }

    public static Map<String, Object> load(String path){
        if(StringUtils.isBlank(path)){
            return null;
        }

        return yaml.load(classLoader.getResourceAsStream(path));
    }

}
