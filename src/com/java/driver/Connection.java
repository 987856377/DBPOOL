package com.java.driver;

public interface Connection {

    public void createStatement(String sql);

    public void commit();

    public void rollback();

    public void close();

}
