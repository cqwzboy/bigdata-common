package com.qc.itaojin.enums;

import org.springframework.util.Assert;

/**
 * Created by fuqinqin on 2018/7/13.
 */
public enum  GenericType {
    SHORT("short"),
    SHORT_PACKAGE("java.lang.Short"),
    BYTE("byte"),
    BYTE_PACKAGE("java.lang.Byte"),
    INT("int"),
    INTEGER("java.lang.Integer"),
    LONG("long"),
    LONG_PACKAGE("java.lang.Long"),
    BOOLEAN("boolean"),
    BOOLEAN_PACKAGE("java.lang.Boolean"),
    FLOAT("float"),
    FLOAT_PACKAGE("java.lang.Float"),
    DOUBLE("double"),
    DOUBLE_PACKAGE("java.lang.Double"),
    CHAR("char"),
    BIGDECIMAL("java.math.BigDecimal"),
    STRING("java.lang.String"),
    DATE_SQL("java.sql.Date"),
    DATE("java.util.Date"),
    ;
    private String type;

    GenericType(String type){
        this.type = type;
    }

    public String type(){
        return this.type;
    }

    public static GenericType typeOf(String type){
        Assert.hasLength(type, "type must not be null");
        for (GenericType genericType : GenericType.values()) {
            if(type.equals(genericType.type)){
                return genericType;
            }
        }

        throw new IllegalArgumentException("error type");
    }

    public boolean equalsTo(GenericType type){
        if(type == null){
            return false;
        }

        if(this == type){
            return true;
        }

        if(this.type.equals(type.type()) && this.name().equals(type.name())){
            return true;
        }

        return false;
    }

}
