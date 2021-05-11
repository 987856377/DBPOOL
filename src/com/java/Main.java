package com.java;

import com.java.database.ConcreteListener;
import com.java.pool.ProxyConnection;
import com.java.database.Listener;
import com.java.pool.Connection;
import com.java.pool.ConnectionPool;
import com.java.pool.ConnectionPoolBuilder;

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPoolBuilder(10);
        Connection connection = pool.getConnection();
        Connection connection1 = pool.getConnection();

        pool.valid(connection);

        ProxyConnection executer = ((ConnectionPoolBuilder) pool).getInstance();
        Listener listener = new ConcreteListener(executer);
        listener.start();

        String sql = "select * from user";
        connection.createStatement(sql);
        executer.exec(sql);

        sql = "delete * from user";
        connection1.createStatement(sql);
        executer.exec(sql);

        connection.commit();
        connection.rollback();
        connection.close();

        connection1.commit();
        connection1.rollback();
        connection1.close();

        listener.stop();
        pool.close();
    }
}
