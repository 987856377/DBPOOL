package com.java.database;

import com.java.util.Connection;
import com.java.util.MySQLConnection;

public class MySQL extends DataBase {

    @Override
    public Connection conn(String url, String username, String password) {
        System.out.println("MySQL 数据库 "+url+" 连接成功");
        System.out.println(username+" 登录成功");
        return new MySQLConnection(this);
    }

    @Override
    public void exec(String sql) {
        System.out.println("执行: "+sql+" 成功");
    }
}
