package ru.netology.data;


import ru.netology.data.db_entities.CreditEntity;
import ru.netology.data.db_entities.PaymentEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection != null) {
                return connection;
            }
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

     public static void deleteDB() {
        QueryRunner runner = new QueryRunner();
        String payment = "DELETE FROM payment_entity";
        String credit = "DELETE FROM credit_request_entity";
        String order = "DELETE FROM order_entity";


        getConnection();
        try {

            runner.update(connection, payment);
            runner.update(connection, credit);
            runner.update(connection, order);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static PaymentEntity fetchPaymentEntity() {
        String statusQuery = "SELECT * FROM payment_entity";
        QueryRunner runner = new QueryRunner();
        getConnection();
        try {
            PaymentEntity paymentEntity = runner.query(connection, statusQuery, new BeanHandler<>(PaymentEntity.class));
            if (paymentEntity != null) {
                return paymentEntity;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    public static CreditEntity fetchCreditEntity() {
        String statusQuery = "SELECT * FROM credit_request_entity";
        QueryRunner runner = new QueryRunner();
        getConnection();
        try {
            CreditEntity creditEntity = runner.query(connection, statusQuery, new BeanHandler<>(CreditEntity.class));
            if (creditEntity != null) {
                return creditEntity;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

}