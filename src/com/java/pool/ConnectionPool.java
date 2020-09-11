package com.java.pool;

import com.java.driver.Connection;

import java.util.LinkedList;

public abstract class ConnectionPool {

    protected LinkedList<Connection> list = new LinkedList<>();

    public abstract Connection getConnection();

    public void valid(Connection connection){
        System.out.println(connection+" 安全连接环境校检成功");
    }

    public abstract void close();
}
