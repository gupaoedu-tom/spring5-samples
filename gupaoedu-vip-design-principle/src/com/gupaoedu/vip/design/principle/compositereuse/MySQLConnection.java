package com.gupaoedu.vip.design.principle.compositereuse;

/**
 * Created by Tom
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
