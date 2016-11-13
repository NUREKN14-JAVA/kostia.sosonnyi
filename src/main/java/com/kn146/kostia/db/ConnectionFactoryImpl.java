package com.kn146.kostia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Константин on 07-Nov-16.
 */
public class ConnectionFactoryImpl implements ConnectionFactory {

    private String user;
    private String password;
    private String driver;
    private String url;

    public ConnectionFactoryImpl(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection createConnection() throws DatabaseException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }
}