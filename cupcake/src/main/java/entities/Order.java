/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Strom
 */
public class Order {

    int order_id;
    User user;
    String date;
    List<Orderline> orderlines;
    int total_price;
    

    public Order(User user) {
        //this.order_id = order_id;
        this.user = user;
        //this.date = date;
        //this.orderlines = orderlines;
        //this.total_price = total_price;

    }

    /*
    public Order(int order_id, User user, List orderlines, int total_price) {
        this.order_id = order_id;
        this.user = user;
        this.orderlines = orderlines;
        this.total_price = total_price;

    }
    */

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", user=" + user + ", date=" + date + ", orderlines=" + orderlines + ", total_price=" + total_price + '}';
    }
    
    

}
