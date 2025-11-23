package com.Basics.TaskTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/taskdb";
    private static final String user = "root";
    private static final String pw  = "Vaish@2003";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pw);
    }
}
