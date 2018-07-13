package com.qc.itaojin.service;

public interface IBaseService {

    /**
     * 使用单一连接
     * */
    void useSingleConn();

    /**
     * 销毁连接
     * */
    void closeSingleConn();

}
