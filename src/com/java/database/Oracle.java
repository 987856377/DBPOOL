package com.java.database;

import com.java.pool.Connection;
import com.java.pool.OracleConnection;
import com.java.pool.ProxyConnection;

public class Oracle extends ProxyConnection {

    @Override
    public Connection conn(String url, String username, String password) {
        System.out.println("MySQL 数据库 " + url + " 连接成功");
        System.out.println(username + " 登录成功");
        return new OracleConnection(this);
    }

    @Override
    public void exec(String sql) {
        System.out.println("执行: " + sql + " 成功");
    }
}
