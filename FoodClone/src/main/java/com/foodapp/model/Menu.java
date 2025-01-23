package com.foodapp.model;

public class Menu {
    private int menuID;
    private int restaurantID;
    private String name;
    private String description;
    private int price;
    private boolean isAvailable;
    private String imagePath;

    // Constructor
    public Menu(int menuID, int restaurantID, String name, String description, int price, boolean isAvailable, String imagePath) {
        this.menuID = menuID;
        this.restaurantID = restaurantID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getisAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Menu [menuID=" + menuID + ", restaurantID=" + restaurantID + ", name=" + name +
               ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable +
               ", imagePath=" + imagePath + "]";
    }
}
