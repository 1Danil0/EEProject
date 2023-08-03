package com.danilermolenko.javaee.project.myclasses;

import java.util.HashMap;

public class Cart {
    private String name;
    private int quantity;
    private HashMap<String, Integer> cartMap;
    public Cart(){
        cartMap = new HashMap<>();
    }
     public void addItems(String name, Integer quantity){
        cartMap.put(name, quantity);
     }

    public HashMap<String, Integer> getCartMap() {
        return cartMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
