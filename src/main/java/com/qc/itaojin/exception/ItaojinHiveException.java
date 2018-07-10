package com.qc.itaojin.exception;

import com.qc.itaojin.util.StringUtils;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by fuqinqin on 2018/7/10.
 */
@Data
@Slf4j
@ToString
public class ItaojinHiveException extends Exception {

    /**
     * 错误码
     * */
    private int errorCode;

    /**
     * 明明空间
     * */
    private String schema;

    /**
     * 表格
     * */
    private String table;

    public ItaojinHiveException(int errorCode) {
        super(String.format("errorCode=%d", errorCode));
        this.errorCode = errorCode;
    }

    public ItaojinHiveException(int errorCode, String message) {
        super(String.format("errorCode=%d, message=%s", errorCode, message));
        this.errorCode = errorCode;
    }

    public ItaojinHiveException(int errorCode, String schema, String table) {
        super(String.format("errorCode=%d, schema=%s, table=%s", errorCode, schema, table));
        this.errorCode = errorCode;
        this.schema = schema;
        this.table = table;
    }

    public ItaojinHiveException(int errorCode, String schema, String table, String message) {
        super(String.format("errorCode=%d, schema=%s, table=%s, message=%s", errorCode, schema, table, message));
        this.errorCode = errorCode;
        this.schema = schema;
        this.table = table;
    }

    public ItaojinHiveException(int errorCode, String message, Throwable cause) {
        super(String.format("errorCode=%d, message=%s", errorCode, message), cause);
        this.errorCode = errorCode;
    }

    public ItaojinHiveException(Throwable cause) {
        super(cause);
    }

    protected ItaojinHiveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
