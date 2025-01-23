<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.foodapp.model.CartItem" %>
<%@ page import="com.foodapp.controller.Cart" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f9fa;
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
	margin: 20px 0;
	color: #343a40;
}

.cart-container {
	margin: 20px auto;
	width: 90%;
	max-width: 1200px;
	background: #ffffff;
	border-radius: 8px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
}

.cart-items {
	display: flex;
	flex-direction: column; /* Display cards one below the other */
	gap: 20px; /* Space between each card */
}

.cart-card {
	display: flex; /* Align contents horizontally */
	flex-direction: row; /* Align card contents in a row */
	align-items: center; /* Vertically align the contents */
	gap: 20px; /* Space between card elements */
	background: #ffffff;
	border: 1px solid #dee2e6;
	border-radius: 8px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	padding: 15px;
}

.cart-card h3 {
	margin: 0 0 10px;
	font-size: 18px;
	color: #343a40;
	flex-basis: 100%; /* Makes the item name span across the top */
}

.cart-card p {
	margin: 5px 0;
	font-size: 14px;
	color: #6c757d;
}

.quantity-update {
	display: flex;
	align-items: center;
	gap: 10px;
}

.actions {
	display: flex;
	gap: 10px;
}

.cart-card button {
	padding: 8px 12px;
	border: none;
	border-radius: 5px;
	font-size: 14px;
	color: #ffffff;
	cursor: pointer;
}

.btn-update {
	background-color: #28a745;
}

.btn-update:hover {
	background-color: #218838;
}

.btn-remove {
	background-color: #dc3545;
}

.btn-remove:hover {
	background-color: #c82333;
}

.total {
	text-align: right;
	font-size: 20px;
	margin-top: 30px;
	font-weight: bold;
}

.add-more {
	text-align: center;
	margin: 20px 0;
}

.btn-add-more {
	background-color: #007bff;
	color: white;
	padding: 10px 20px;
	font-size: 16px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none;
}

.btn-add-more:hover {
	background-color: #0056b3;
}

.check-out {
	text-align: center;
	margin: 20px 0;
}

.btn-check-out {
	background-color: #007bff;
	color: white;
	padding: 10px 20px;
	font-size: 16px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none;
}

.btn-check-out:hover {
	background-color: #0056b3;
}
.empty-cart {
	text-align: center;
	padding: 30px;
	font-size: 18px;
	color: #6c757d;
}
</style>
</head>
<body>
    <h1>Your Cart</h1>
    <div class="cart-container">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null && !cart.getItems().isEmpty()) {
                Map<Integer, CartItem> cartItems = cart.getItems();
        %>
        <div class="cart-items">
            <%
                for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                    CartItem item = entry.getValue();
            %>
            <div class="cart-card">
                <h3><%= item.getName() %></h3>
                <p>Price: <strong><%= item.getPrice() %> Rs</strong></p>
                <p>Quantity:</p>
                <form action="CartS" method="post" class="quantity-update">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="menuID" value="<%= item.getItemID() %>">
                    <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" style="width: 60px; padding: 5px;">
                    <button type="submit" class="btn-update">Update</button>
                </form>
                <p>Total: <strong><%= item.getPrice() * item.getQuantity() %> Rs</strong></p>
                <div class="actions">
                    <form action="CartS" method="post">
                        <input type="hidden" name="action" value="remove">
                        <input type="hidden" name="menuID" value="<%= item.getItemID() %>">
                        <button type="submit" class="btn-remove">Remove</button>
                    </form>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <div class="add-more">
            <a href="menu.jsp" class="btn-add-more">Add More Items</a>
        </div>
        <div class="check-out">
            <a href="checkout.jsp" class="btn-check-out">Check Out</a>
        </div>
        <div class="total">
            Total Amount: <%= cart.getTotalAmount() %> Rs
        </div>
        <%
            } else {
        %>
        <div class="empty-cart">
            Your cart is empty. <a href="menu.jsp">Go back to the menu</a>.
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
