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
public class ItaojinZKException extends Exception {

    /**
     * 错误码
     * */
    private int errorCode;

    /**
     * ZK节点
     * */
    private String zNode;

    public ItaojinZKException(int errorCode) {
        super(String.format("errorCode=%d", errorCode));
        this.errorCode = errorCode;
    }

    public ItaojinZKException(int errorCode, String zNode) {
        super(String.format("errorCode=%d, zNode=%s", errorCode, zNode));
        this.errorCode = errorCode;
        this.zNode = zNode;
    }

    public ItaojinZKException(int errorCode, String zNode, String message) {
        super(String.format("errorCode=%d, zNode=%s, message=%s", errorCode, zNode, message));
        this.errorCode = errorCode;
        this.zNode = zNode;
    }

    public ItaojinZKException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ItaojinZKException(Throwable cause) {
        super(cause);
    }

    protected ItaojinZKException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
