/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.Bottom;
import entities.Topping;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class CupcakeMapper {
    
    
    public List<Topping> getListOfTops() {
        List<Topping> output = new ArrayList<Topping>();   
        try{
            String sql = "SELECT topping_id "
                    + "FROM cupcake.toppings";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            Topping mytop = null;
            int toppint_id = 0;
            while (rs.next()) {
                toppint_id = rs.getInt("topping_id");
                mytop = new Topping(toppint_id);
                mytop = this.getToppingByToppingId(mytop);
                output.add(mytop);
            }
        }catch (Exception e) {
            return null;
        }
        
        return output;
    }
    
    public List<Bottom> getListOfBots() {
        List<Bottom> output = new ArrayList<Bottom>();
        try{   
            String sql = "SELECT bottom_id "
                    + "FROM cupcake.bottoms";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            Bottom mybot = null;
            int bottom_id = 0;
            while (rs.next()) {
                bottom_id = rs.getInt("bottom_id");
                mybot = new Bottom(bottom_id);
                mybot = this.getBottomByBottomId(mybot);
                output.add(mybot);
            }
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    public Topping getToppingByToppingId(Topping topping) {
        Topping output = topping;
        try {
            String sql = "SELECT name, price "
                    + "FROM cupcake.toppings where topping_id =" + 
                    topping.getId();
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
        public Topping getToppingByToppingId(int id) {
        Topping output = new Topping(id);
        try {
            String sql = "SELECT name, price "
                    + "FROM cupcake.toppings where topping_id =" + 
                    id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    
    public Bottom getBottomByBottomId(Bottom bottom) {
        Bottom output = bottom;
        try{
            String sql = "SELECT name, price "
                    + "FROM cupcake.bottoms where bottom_id =" + 
                    bottom.getId();
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    public Bottom getBottomByBottomId(int id) {
        Bottom output = new Bottom(id);
        try{
            String sql = "SELECT name, price "
                    + "FROM cupcake.bottoms where bottom_id =" + 
                    id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        }catch (Exception e) {
            return null;
        }
        return output;
    }
    
    
    public static void main(String[] args) {
        
        List<Topping> toplist = new CupcakeMapper().getListOfTops();
        List<Bottom> botlist = new CupcakeMapper().getListOfBots();
        for (Topping t: toplist) {
            System.out.println(t);
        }
        for (Bottom b: botlist) {
            System.out.println(b);
        }
         
        /*
        Topping top = new Topping(1);
        Bottom bot = new Bottom(2);
        top = new CupcakeMapper().getToppingByToppingId(top);
        bot = new CupcakeMapper().getBottomByBottomId(bot);
        System.out.println(top);
        System.out.println(bot);    
        */
    }
}

/*

*/
