package com.ahohlov.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.ahohlov.config.ConfigurationManager;

public class ConnectionService {

    private static ConnectionService instance;

    private Connection connection;

    private ConnectionService() {
        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        try {
            Class.forName(configurationManager.getProperty(ConfigurationManager.DATABASE_DRIVER_NAME));
            System.out.println("-------- MySQL JDBC Driver registered ------------");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
    }

    public static ConnectionService getInstance() {
        if (instance == null) {
            instance = new ConnectionService();
        }
        return instance;
    }

    public Connection getConnection() {
        System.out.println("Creating connection...");
        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            Properties properties = new Properties();
            properties.setProperty("user", configurationManager.getProperty(ConfigurationManager.DATABASE_USERNAME));
            properties.setProperty("password", configurationManager.getProperty(ConfigurationManager.DATABASE_PWD));
            properties.setProperty("useUnicode", "true");
            properties.setProperty("characterEncoding", "cp1251");
            connection = DriverManager.getConnection(
                    configurationManager.getProperty(ConfigurationManager.DATABASE_URL),
                    properties
            );
            System.out.println("Connection was created");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            throw new RuntimeException();
        }
    }
}
