package com.foodapp.model;

public class OrderItems {
    private int orderItemID;
    private int orderID;
    private int menuID;
    private int quantity;
    private int itemTotal;

    // Constructor
    public OrderItems(int orderItemID, int orderID, int menuID, int quantity, int itemTotal) {
        this.orderItemID = orderItemID;
        this.orderID = orderID;
        this.menuID = menuID;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }
    
    // Getters and Setters
    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(int itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Override
    public String toString() {
        return "OrderItems [orderItemID=" + orderItemID + ", orderID=" + orderID + ", menuID=" + menuID +
                ", quantity=" + quantity + ", itemTotal=" + itemTotal + "]";
    }
}
