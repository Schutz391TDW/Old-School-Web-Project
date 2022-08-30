/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrew.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author Andrew
 */
public class Product implements Serializable {
    private String code;
    private String title;
    private double price;
    private String cover;
    
    public Product() {
        code = "";
        title = "";
        price = 0;
    }
    
    //Getters and Setters for variables
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    //Sets the format for currency
    
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public String getCover() {
        return cover;
    }
}
