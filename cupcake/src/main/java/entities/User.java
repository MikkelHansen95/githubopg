/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Strom
 */
public class User {
    
    int user_id;
    String name;
    String password;
    double balance;
    String email;
    

    public User(String name, String password, double balance, String email) {
        //this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", name=" + name + ", password=" + password + ", balance=" + balance + ", email=" + email + '}';
    }

    
    
    
    
}
