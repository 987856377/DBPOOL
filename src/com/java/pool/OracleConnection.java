package com.java.pool;

import com.java.pool.Connection;
import com.java.pool.ProxyConnection;

public class OracleConnection implements Connection {

    private ProxyConnection proxyConnection;

    public OracleConnection(ProxyConnection proxyConnection) {
        this.proxyConnection = proxyConnection;
        System.out.println("连接已建立");
    }

    @Override
    public void createStatement(String sql) {
        System.out.println("创建 sql 语句: " + sql + " 成功");
    }

    @Override
    public void commit() {
        proxyConnection.commit();
    }

    @Override
    public void rollback() {
        proxyConnection.rollback();
    }

    @Override
    public void close() {
        proxyConnection.close();
    }
}
