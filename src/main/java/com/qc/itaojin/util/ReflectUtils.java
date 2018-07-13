package com.qc.itaojin.util;

import com.qc.itaojin.enums.GenericType;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;

import static com.qc.itaojin.enums.GenericType.*;

/**
 * Created by fuqinqin on 2018/7/13.
 */
public class ReflectUtils {

    /**
     * 构建set方法
     * */
    public static String buildSet(String name){
        return StringUtils.contact("set", StringUtils.firstCharUpper(name));
    }

    /**
     * 根据Field对象和值，转换成正确的类型
     * */
    public static Object transValue(Field field, String value){
        Assert.notNull(field, "field must not be null");
        Assert.hasLength(value, "value must not be null");

        String typeName = field.getGenericType().getTypeName();

        if(STRING.type().equals(typeName)){
            return value;
        }else if(SHORT.type().equals(typeName) || SHORT_PACKAGE.type().equals(typeName)){
            return Short.parseShort(value);
        }else if(BYTE.type().equals(typeName) || BYTE_PACKAGE.type().equals(typeName)){
            return Byte.parseByte(value);
        }else if(INT.type().equals(typeName) || INTEGER.type().equals(typeName)){
            return Integer.parseInt(value);
        }else if(LONG.type().equals(typeName) || LONG_PACKAGE.type().equals(typeName)){
            return Long.parseLong(value);
        }else if(FLOAT.type().equals(typeName) || FLOAT_PACKAGE.type().equals(typeName)){
            return Float.parseFloat(value);
        }else if(DOUBLE.type().equals(typeName) || DOUBLE_PACKAGE.type().equals(typeName)){
            return Double.parseDouble(value);
        }else if(BOOLEAN.type().equals(typeName) || BOOLEAN_PACKAGE.type().equals(typeName)){
            return Boolean.parseBoolean(value);
        }else if(CHAR.type().equals(typeName)){
            return value.charAt(0);
        }else if(DATE.type().equals(typeName)){
            try{
                long _var1 = Long.parseLong(value);
                return new Date(_var1);
            }catch (Exception ex){

            }
            return new Date(Date.parse(value));
        }else if(DATE_SQL.type().equals(typeName)){
            return new java.sql.Date(Date.parse(value));
        }else if(BIGDECIMAL.type().equals(typeName)){
            return BigDecimal.valueOf(Long.parseLong(value));
        }

        throw new IllegalArgumentException("error field type");
    }

    /**
     * 根据Type获取Class
     * */
    public static Class mapClass(Type type){
        Assert.notNull(type, "type must not be null");
        GenericType genericType = GenericType.typeOf(type.getTypeName());

        switch (genericType) {
            case SHORT:
                return short.class;
            case SHORT_PACKAGE:
                return Short.class;
            case BYTE:
                return byte.class;
            case BYTE_PACKAGE:
                return Byte.class;
            case INT:
                return int.class;
            case INTEGER:
                return Integer.class;
            case LONG:
                return long.class;
            case LONG_PACKAGE:
                return Long.class;
            case BOOLEAN:
                return boolean.class;
            case BOOLEAN_PACKAGE:
                return Boolean.class;
            case FLOAT:
                return float.class;
            case FLOAT_PACKAGE:
                return Float.class;
            case DOUBLE:
                return double.class;
            case DOUBLE_PACKAGE:
                return Double.class;
            case BIGDECIMAL:
                return BigDecimal.class;
            case DATE:
                return Date.class;
            case DATE_SQL:
                return java.sql.Date.class;
            case STRING:
                return String.class;
            case CHAR:
                return char.class;
            default:
                throw new IllegalArgumentException("error reflect type");
        }

        /*if(GenericType.SHORT.equalsTo(genericType) || GenericType.SHORT_PACKAGE.equalsTo(genericType)){
            return Short.class;
        }else if(GenericType.BYTE.equalsTo(genericType) || GenericType.BYTE_PACKAGE.equalsTo(genericType)){
            return Byte.class;
        }else if(GenericType.INT.equalsTo(genericType) || GenericType.INTEGER.equalsTo(genericType)){
            return Integer.class;
        }else if(GenericType.LONG.equalsTo(genericType) || GenericType.LONG_PACKAGE.equalsTo(genericType)){
            return Long.class;
        }else if(GenericType.BOOLEAN.equalsTo(genericType) || GenericType.BOOLEAN_PACKAGE.equalsTo(genericType)){
            return Boolean.class;
        }else if(GenericType.FLOAT.equalsTo(genericType) || GenericType.FLOAT_PACKAGE.equalsTo(genericType)){
            return Float.class;
        }else if(GenericType.DOUBLE.equalsTo(genericType) || GenericType.DOUBLE_PACKAGE.equalsTo(genericType)){
            return Double.class;
        }else if(GenericType.BIGDECIMAL.equalsTo(genericType)){
            return BigDecimal.class;
        }else if(GenericType.DATE.equalsTo(genericType)){
            return Integer.class;
        }else if(GenericType.DATE_SQL.equalsTo(genericType)){
            return java.sql.Date.class;
        }else if(GenericType.STRING.equalsTo(genericType)){
            return String.class;
        }else if(GenericType.CHAR.equalsTo(genericType)){
            return char.class;
        }

        throw new IllegalArgumentException("error reflect type");*/
    }


    /**
     * class是否使用了某个注解
     * */
    public static void isAnnotationPresent(Class clazz, Class<? extends Annotation> annoClass){
        Assert.notNull(clazz, "clazz must not be null");
        Assert.notNull(annoClass, "annoClass must not be null");
        if(!clazz.isAnnotationPresent(annoClass)){
            throw new IllegalArgumentException(String.format("%s must has annotation %s", clazz.getName(), annoClass.getName()));
        }
    }

    /**
     * Filed是否使用了某个注解
     * */
    public static void isAnnotationPresent(Field field, Class<? extends Annotation> annoClass){
        Assert.notNull(field, "field must not be null");
        Assert.notNull(annoClass, "annoClass must not be null");
        if(!field.isAnnotationPresent(annoClass)){
            throw new IllegalArgumentException(String.format("%s must use annotation %s", field.getName(), annoClass.getName()));
        }
    }

    public static void main(String[] args){
        Field[] fields = Test.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.print(field.getName() + "\t");
            System.out.println(field.getGenericType().getTypeName());
        }
    }

    public static class Test{
        private short s1;
        private Short s2;
        private byte s3;
        private Byte s4;
        private int s5;
        private Integer s6;
        private long s7;
        private Long s8;
        private boolean s9;
        private Boolean s10;
        private float s11;
        private Float s12;
        private double s13;
        private Double s14;
        private char s15;
        private BigDecimal s16;
        private String name;
        private Date date;
        private java.sql.Date d;
    }

}
