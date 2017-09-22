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
public class Bottom {
    
    int id;
    String name;
    double price;
    
    
    public Bottom (int id){
        this.id = id;
        //this.name = name;
        //this.price = price;     
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bottom{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
    
    
}
