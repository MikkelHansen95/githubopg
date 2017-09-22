/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GertLehmann
 */
public class Connector {
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://46.101.152.26:3306/cupcake";
    private final static String user = "cupcakeuser";
    private final static String password = "cupcakemysql";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
