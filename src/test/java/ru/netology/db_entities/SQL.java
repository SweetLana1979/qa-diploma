package ru.netology.db_entities;


import ru.netology.db_entities.PaymentEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    private static final String url = "jdbc:postgresql://localhost:5432/app";
    private static final String user = "app";
    private static final String password = "pass";

    private static Connection connection;

    public static @Nullable Connection getConnection() {
        try {
            if (connection != null) {
                return connection;
            }
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", user, password);
            return connection;
        } catch (SQLException sqlException) {
            System.out.println("No connection with DB:" + sqlException.getMessage());
            sqlException.printStackTrace();
            return null;
        }

    }

     public static void dropDB() {
        QueryRunner runner = new QueryRunner();
        String payment = "DELETE FROM payment_entity";
        String credit = "DELETE FROM credit_request_entity";
        String order = "DELETE FROM order_entity";

        getConnection();
        try {
            runner.update(connection, order);
            runner.update(connection, payment);
            runner.update(connection, credit);
        } catch (SQLException sqlException) {
            System.out.println("Error drop database: " + sqlException.getMessage());
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
            } else {
                System.out.println("No payment found in the database.");
            }
        } catch (SQLException sqlException) {
            System.out.println("Error fetching payment from the database: " + sqlException.getMessage());
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
            } else {
                System.out.println("No credit payment found in the database.");
            }
        } catch (SQLException sqlException) {
            System.out.println("Error fetching credit payment from the database: " + sqlException.getMessage());
            sqlException.printStackTrace();
        }
        return null;
    }
    public static OrderEntity fetchOrderEntity() {
        String statusQuery = "SELECT * FROM order_entity";
        QueryRunner runner = new QueryRunner();
        getConnection();
        try {
            OrderEntity orderEntity = runner.query(connection, statusQuery, new BeanHandler<>(OrderEntity.class));
            if (orderEntity != null) {
                return orderEntity;
            } else {
                System.out.println("No order found in the database.");
            }
        } catch (SQLException sqlException) {
            System.out.println("Error fetching order from the database: " + sqlException.getMessage());
            sqlException.printStackTrace();
        }
        return null;
    }
}