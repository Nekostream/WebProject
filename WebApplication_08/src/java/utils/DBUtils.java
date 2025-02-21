/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SideQuest
 */
public class DBUtils implements Serializable{
    private static final String DB_NAME = "prj301_1814_06";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }
    public static void main(String[] args){
        try{
            Connection c = getConnection();
            System.out.print(c);
        }catch(Exception e){
            
        }
    }
}
