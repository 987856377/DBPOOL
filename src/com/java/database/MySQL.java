package com.java.database;

import com.java.pool.Connection;
import com.java.pool.MySQLConnection;
import com.java.pool.ProxyConnection;

public class MySQL extends ProxyConnection {

    @Override
    public Connection conn(String url, String username, String password) {
        System.out.println("MySQL 数据库 " + url + " 连接成功");
        System.out.println(username + " 登录成功");
        return new MySQLConnection(this);
    }

    @Override
    public void exec(String sql) {
        System.out.println("执行: " + sql + " 成功");
    }
}
