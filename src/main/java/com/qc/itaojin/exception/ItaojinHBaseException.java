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
public class ItaojinHBaseException extends Exception {

    /**
     * 错误码
     * */
    private int errorCode;

    /**
     * 明明空间
     * */
    private String nameSpace;

    /**
     * 表格
     * */
    private String table;

    public ItaojinHBaseException(int errorCode) {
        super(String.format("errorCode=%d", errorCode));
        this.errorCode = errorCode;
    }

    public ItaojinHBaseException(int errorCode, String message) {
        super(String.format("errorCode=%d, message=%s", errorCode, message));
        this.errorCode = errorCode;
    }

    public ItaojinHBaseException(int errorCode, String nameSpace, String table) {
        super(String.format("errorCode=%d, nameSpace=%s, table=%s", errorCode, nameSpace, table));
        this.errorCode = errorCode;
        this.nameSpace = nameSpace;
        this.table = table;
    }

    public ItaojinHBaseException(int errorCode, String nameSpace, String table, String message) {
        super(String.format("errorCode=%d, nameSpace=%s, table=%s, message=%s", errorCode, nameSpace, table, message));
        this.errorCode = errorCode;
        this.nameSpace = nameSpace;
        this.table = table;
    }

    public ItaojinHBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItaojinHBaseException(Throwable cause) {
        super(cause);
    }

    protected ItaojinHBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
