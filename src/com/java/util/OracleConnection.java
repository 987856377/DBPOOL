package com.java.util;

import com.java.database.DataBase;

public class OracleConnection implements Connection {

    private DataBase dataBase;

    public OracleConnection(DataBase dataBase) {
        this.dataBase = dataBase;
        System.out.println("连接已建立");
    }

    @Override
    public void createStatement(String sql) {
        System.out.println("创建 sql 语句: "+sql+" 成功");
    }

    @Override
    public void commit() {
        dataBase.commit();
    }

    @Override
    public void rollback() {
        dataBase.rollback();
    }

    @Override
    public void close() {
        dataBase.close();
    }
}
