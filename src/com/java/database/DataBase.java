package com.java.database;

import com.java.driver.Connection;

public abstract class DataBase {

    public abstract Connection conn(String url, String username, String password);

    public abstract void exec(String sql);

    public void commit(){
        System.out.println("提交完成");
    }

    public void rollback(){
        System.out.println("回滚完成");
    }

    public void close(){
        System.out.println("数据库连接关闭");
    }
}
