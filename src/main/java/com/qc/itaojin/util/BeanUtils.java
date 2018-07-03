package com.qc.itaojin.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author fuqinqin
 * @desc 扩展Spring的BeanUtils工具类
 * @date 2018-04-16
 */
public class BeanUtils {

    /**
     * 拷贝单个对象且返回
     */
    public static <T> T copyProperties(Object source, Class<T> clazz) {
        if (source == null || clazz == null) {
            return null;
        }

        T t;

        try {
            t = clazz.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, t);
        } catch (InstantiationException e) {
            e.printStackTrace();
            t = null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            t = null;
        } catch (Exception ex){
            ex.printStackTrace();
            t = null;
        }

        return t;
    }

    /**
     * 拷贝一个集合，且返回
     */
    public static <T> List<T> copyList(Collection<? extends Object> sourceList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(sourceList) || clazz == null) {
            return null;
        }

        List<T> list = new ArrayList<>();

        T t;
        try {
            for (Object source : sourceList) {
                t = clazz.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(source, t);
                list.add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
            list = null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            list = null;
        }

        t = null;

        return list;
    }

    /**
     * @param source 数据源
     * @param start  起始下角标(包含)
     * @param end    结束下角标(不包含)
     * @desc 拷贝集合的一部分
     */
    public static <T> List<T> copyListByIndex(List<T> source, Integer start, Integer end) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        if (start == null) {
            start = 0;
        }

        if (end == null) {
            end = source.size();
        }

        List<T> list = new ArrayList<>();

        for (int i = start; i < end; i++) {
            list.add(source.get(i));
        }

        return list;
    }

    public static <T> List<T> copyListByIndex(List<T> source) {
        return copyListByIndex(source, null, null);
    }

}
