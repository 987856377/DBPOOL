package com.java.pool;

import com.java.pool.Connection;

public abstract class ProxyConnection implements Connection {

    public abstract Connection conn(String url, String username, String password);

    public abstract void exec(String sql);

    @Override
    public void createStatement(String sql) {
        System.out.println("createStatement: " + sql);
    }

    public void commit() {
        System.out.println("提交完成");
    }

    public void rollback() {
        System.out.println("回滚完成");
    }

    public void close() {
        System.out.println("数据库连接关闭");
    }
}
