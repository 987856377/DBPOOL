package com.java.custom;

import com.java.database.DataBase;
import com.java.database.MySQL;
import com.java.database.Oracle;

public class DBUtil {

    public static DataBase getInstance(String dbType){
        if (dbType.equals("MySQL")||dbType.equals("mysql")||dbType.equals("MYSQL")){
            System.out.println("获取 MySQL 数据库实例成功");
            return new MySQL();
        }
        else if (dbType.equals("oracle")||dbType.equals("ORACLE")){
            System.out.println("获取 Oracle 数据库实例成功");
            return new Oracle();
        }
        System.out.println("获取数据库实例失败,请使用 MySQL 或 Oracle 数据库");
        return null;
    }
}
