package com.gupaoedu.vip.spring.formework.jdbc.datasource;

import javax.sql.DataSource;

/**
 * Created by Tom on 2019/4/17.
 */
public class GPDataSourceTransactionManager {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
