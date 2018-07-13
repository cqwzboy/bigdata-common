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
     * 命名空间 + 表格
     * */
    private String nameSpaceAndTable;

    public ItaojinHBaseException(int errorCode) {
        super(String.format("errorCode=%d", errorCode));
        this.errorCode = errorCode;
    }

    public ItaojinHBaseException(int errorCode, String message) {
        super(String.format("errorCode=%d, message=%s", errorCode, message));
        this.errorCode = errorCode;
    }

    public ItaojinHBaseException(int errorCode, String nameSpaceAndTable, String message) {
        super(String.format("errorCode=%d, nameSpaceAndTable=%s, message=%s", errorCode, nameSpaceAndTable, message));
        this.errorCode = errorCode;
        this.nameSpaceAndTable = nameSpaceAndTable;
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
