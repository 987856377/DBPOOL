package com.java.driver;

public class DriverManager {

    private static DriverManager driverManager;

    private DriverManager(){}

    public static synchronized DriverManager getDriver(String driver){
        if (driverManager == null){
            driverManager = new DriverManager();
        }
        System.out.println("加载数据库驱动: "+driver+" 成功");
        return driverManager;
    }
}
