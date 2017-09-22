/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;


public class ShoppingCart {
    
    int order_id;
    List<Orderline> Orderlines;
    double total_price;

    public ShoppingCart(int order_id, List<Orderline> Orderlines, double total_price) {
        this.order_id = order_id;
        this.Orderlines = Orderlines;
        this.total_price = total_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public List<Orderline> getOrderlines() {
        return Orderlines;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrderlines(List<Orderline> Orderlines) {
        this.Orderlines = Orderlines;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    
    
    
}
