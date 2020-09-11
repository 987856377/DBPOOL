package com.java.database;

import com.java.driver.Connection;

public class ConcretListener extends Listener {

    private DataBase dataBase;

    public ConcretListener(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Deprecated
    @Override
    public Connection conn(String url, String username, String password) {
        return null;
    }

    @Deprecated
    @Override
    public void exec(String sql) { }

    @Override
    public void start() {
        System.out.println("*** start listen ***: "+dataBase.getClass().getSimpleName());
    }

    @Override
    public void stop() {
        System.out.println("*** stop listen ***: "+dataBase.getClass().getSimpleName());
    }
}
