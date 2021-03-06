package com.java.pool;

import com.java.driver.DataBaseFactory;
import com.java.driver.DriverManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ConnectionPoolBuilder extends ConnectionPool {

    private ProxyConnection proxyConnection;

    public ConnectionPoolBuilder(int capacity) {
        DriverManager.getDriver("com.mysql.jdbc.Driver");

        proxyConnection = DataBaseFactory.getInstance("MySQL");

        for (int i = 0; i < capacity; i++) {
            list.add(proxyConnection.conn("jdbc:mysql://127.0.0.1:3306/test", "root", "root"));
        }
    }

    public ProxyConnection getInstance() {
        return this.proxyConnection;
    }

    @Override
    public Connection getConnection() {
        if (list.size() > 0) {
            final Connection conn = list.removeFirst();
//            return (Connection) Proxy.newProxyInstance(ConnectionPoolBuilder.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class<?>[]{Connection.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("close")) {
                        list.add(conn);
                        System.out.println(conn + " 被还给 list 数据库连接池了！！");
                        System.out.println("list 数据库连接池大小为" + list.size());
                        return null;
                    } else {
                        return method.invoke(conn, args);
                    }
                }
            });
        }
        return null;
    }

    @Override
    public void close() {
        for (Connection c : list) {
            c.close();
        }
    }
}
