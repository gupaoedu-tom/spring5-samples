package com.gupaoedu.vip.design.principle.compositereuse;

/**
 * Created by Tom
 */
public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "Oracle数据库连接";
    }
}
