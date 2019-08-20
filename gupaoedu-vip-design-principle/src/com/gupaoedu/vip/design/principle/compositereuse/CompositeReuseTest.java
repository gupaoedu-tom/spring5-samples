package com.gupaoedu.vip.design.principle.compositereuse;

/**
 * Created by Tom
 */
public class CompositeReuseTest {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new OracleConnection());
        productDao.addProduct();
    }

}
