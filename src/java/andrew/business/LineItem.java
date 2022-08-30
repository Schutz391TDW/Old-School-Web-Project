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
public class LineItem implements Serializable {
    
    private Product product;
    private int quantity;
    
    public LineItem() {}
    
    //Getters and Setters for variables
    
    public void setProduct (Product p) {
        product = p;
    }
    
    public Product getProduct () {
        return product;
    }
    
    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;
    }
    
    //Sets the format for currency
    
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
