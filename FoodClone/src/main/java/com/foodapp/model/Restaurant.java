package com.foodapp.model;

public class Restaurant {
    private int restaurantID;
    private String name;
    private String cuisineType;
    private int deliveryTime;
    private String address;
    private float ratings;
    private boolean isActive;
    private String imagePath;

    // Constructor
    public Restaurant(int restaurantID, String name, String cuisineType, int deliveryTime, String address, float ratings, boolean isActive, String imagePath) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.cuisineType = cuisineType;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.ratings = ratings;
        this.isActive = isActive;
        this.imagePath = imagePath;
    }

    // Getters and Setters
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

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantID +
                ", name='" + name + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", address='" + address + '\'' +
                ", ratings=" + ratings +
                ", isActive=" + isActive +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
