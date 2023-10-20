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
            System.out.println("Error fetching payment status from the database: " + sqlException.getMessage());
            sqlException.printStackTrace();
        }
        return null;
    }
}