/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrew.business;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Andrew
 */
public class Cart implements Serializable {
  
    private ArrayList<LineItem> items;
    
    //Creates an ArrayList of items
    public Cart() {
        items = new ArrayList<LineItem>();
    }
    
    //Getters and Setters for variables
    
    public ArrayList<LineItem> getItems() {
        return items;
    }
    
    public int getCount() {
        return items.size();
    }
    
    //Adds item
    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for(int i = 0 ; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)){
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    //Removes item
    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        for(int i = 0 ; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)){
                items.remove(i);
                return;
            }
        }        
    }
}
