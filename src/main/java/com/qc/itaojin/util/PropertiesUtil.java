package com.qc.itaojin.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by fuqinqin on 2018/6/25.
 */
public class PropertiesUtil {

    private static ClassLoader classLoader = PropertiesUtil.class.getClassLoader();

    public static Properties loadProperties(String path){
        if(StringUtils.isBlank(path)){
            return null;
        }

        Properties pros = new Properties();
        InputStream is = classLoader.getResourceAsStream(path);
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return pros;
    }

}
