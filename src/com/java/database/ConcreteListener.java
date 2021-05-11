package com.java.database;

import com.java.pool.Connection;
import com.java.pool.ProxyConnection;

public class ConcreteListener extends Listener {

    private ProxyConnection proxyConnection;

    public ConcreteListener(ProxyConnection proxyConnection) {
        this.proxyConnection = proxyConnection;
    }

    @Deprecated
    @Override
    public Connection conn(String url, String username, String password) {
        return null;
    }

    @Deprecated
    @Override
    public void exec(String sql) {
    }

    @Override
    public void start() {
        System.out.println("*** start listen ***: " + proxyConnection.getClass().getSimpleName());
    }

    @Override
    public void stop() {
        System.out.println("*** stop listen ***: " + proxyConnection.getClass().getSimpleName());
    }
}
