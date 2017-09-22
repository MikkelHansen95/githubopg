/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.Order;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */

public class UserMapper {
    
    public User getUserByName(String name) {
        User output = null;
        try {
            String sql = "SELECT user_id,username, password,balance, email FROM cupcake.users where username='" + name+"'";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int userID = 0;
            String userName = "";
            String password = "";
            double balance = 0;
            String email = "";
            while (rs.next()) {
                userID = rs.getInt("user_id");
                userName = name; //rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
                email = rs.getString("email");
            }
            output = new User(userName, password, balance, email);
            output.setUser_id(userID);
        }catch (SQLException ex) {
            return null;
        }
        return output;
    } 
    
    public User updateUserBalanceById(User user, double newbalance) throws SQLException {
        User output = user;
                
        Connection conn = Connector.getConnection();
        String sql = "UPDATE cupcake.users SET balance="+
                newbalance +" WHERE user_id="+user.getUser_id();
        PreparedStatement recipePstmt = conn.prepareStatement(sql);
        
        try {
            conn.setAutoCommit(false);
            recipePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
            return null;
        } finally {
            conn.setAutoCommit(true);
        }
        output.setBalance(newbalance);
        return output;
    }
    
    public User getUserByID(int id) {
        User output = null;
        try{
            String sql = "SELECT user_id,username, password,balance, email FROM cupcake.users where user_id=" + id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int userID = 0;
            String userName = "";
            String password = "";
            double balance = 0;
            String email = "";
            while (rs.next()) {
                userID = id;//rs.getInt("user_id");
                userName = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
                email = rs.getString("email");
            }
            output = new User(userName, password, balance, email);
            output.setUser_id(id);
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    public void putUser(User user) throws SQLException {
        
        String name = user.getName();
        String password = user.getPassword();
        double balance = user.getBalance();
        String email = user.getEmail();
        //String name, String password, double balance, String email
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.users ("
                + "username, password, balance, email)"
                + "VALUES (?, ?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser);
        try {
            conn.setAutoCommit(false);
            recipePstmt.setString(1, name);
            recipePstmt.setString(2, password);
            recipePstmt.setDouble(3, balance);
            recipePstmt.setString(4, email);
            recipePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
        
    }
    
    public static void main(String[] args) throws SQLException {
    
        User myuser = new UserMapper().getUserByID(1);
        System.out.println(myuser);
        
        //myuser = new UserMapper().updateUserBalanceById(myuser, 450000.00);
        System.out.println(myuser);
        
//        User myuser = new UserMapper().getUserByName("Jens Hansen");
//        System.out.println(myuser);
     
        //new UserMapper().putUser("Jens Hansen", "bondegaard", 100000, "eyaeyajo@farmer.dk");
        
        //User myuser2 = new UserMapper().getUserByID(2);
        //System.out.println(myuser2);
//        UserMapper um = new UserMapper();
//        User test = new User("Hong Li","123456",10000.0,"test@dummy.dk");
//        try { 
//            um.putUser(test);
//        } catch (SQLException ex)
//        {
//        }    
        
        
        
    }
    
    
    /*
    public void putUser(User user) throws SQLException {
        User userToFile = null;
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO cupcake.users ("
                + "username, password, balance, email)"
                + "VALUES (?, ?, ?, ?);";
        PreparedStatement recipePstmt = conn.prepareStatement(insertUser);
        try {
        conn.setAutoCommit(false);
        recipePstmt.setString(1, user.getName());
        recipePstmt.setString(2, user.getPassword());
        recipePstmt.setDouble(3, user.getBalance());
        recipePstmt.setString(4, user.getEmail());
        recipePstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
    }
    */
}
