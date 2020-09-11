package com.java;

import com.java.database.ConcretListener;
import com.java.database.DataBase;
import com.java.database.Listener;
import com.java.pool.ConnectionPool;
import com.java.pool.ConnectionPoolBuilder;
import com.java.driver.Connection;

public class Main {
    public static void main(String[] args){
        ConnectionPool pool = new ConnectionPoolBuilder(10);
        Connection connection =  pool.getConnection();
        Connection connection1 = pool.getConnection();

        pool.valid(connection);

        DataBase executer = ((ConnectionPoolBuilder) pool).getInstance();
        Listener listener = new ConcretListener(executer);
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
