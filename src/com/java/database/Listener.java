package com.java.database;

import com.java.pool.ProxyConnection;

public abstract class Listener extends ProxyConnection {

    public abstract void start();

    public abstract void stop();

}
