package com.foodapp.controller;

import java.util.HashMap;
import java.util.Map;

import com.foodapp.model.CartItem;

public class Cart {
	private Map<Integer, CartItem> items;

	public Cart() {
		this.items = new HashMap<>();
	}

	public void add(CartItem item) {
		int itemID = item.getItemID();
		if (items.containsKey(itemID)) {
			CartItem existingCartItem = items.get(itemID);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
		} else {
			items.put(itemID, item);
		}
	}

	public void update(int itemID, int quantity) {
		if (items.containsKey(itemID)) {
			if (quantity <= 0) {
				items.remove(itemID);
			} else {
				items.get(itemID).setQuantity(quantity);
			}
		}
	}

	public void RemoveItem(int itemID) {
		items.remove(itemID);
	}

	public void clearItem(int itemID) {
		items.clear();
	}

	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public double getTotalAmount() {
	    return items.values().stream()
	        .mapToDouble(item -> item.getPrice() * item.getQuantity())
	        .sum();
	}

}
