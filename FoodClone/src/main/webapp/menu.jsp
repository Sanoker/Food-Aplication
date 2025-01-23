<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<style>
/* Reset and base styles */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, sans-serif;
	background-color: #f5f5f5;
	color: #333;
	line-height: 1.6;
}

/* Navigation styles */
.navbar {
	background-color: #ffffff;
	padding: 1rem;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	position: sticky;
	top: 0;
	z-index: 1000;
}

.nav-container {
	max-width: 1200px;
	margin: 0 auto;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.logo {
	display: flex;
	align-items: center;
	text-decoration: none;
	color: #1a1a1a;
	font-size: 1.5rem;
	font-weight: bold;
}

.logo-icon {
	margin-right: 0.5rem;
	font-size: 1.8rem;
}

.nav-links {
	display: flex;
	gap: 2rem;
	align-items: center;
}

.nav-links a {
	text-decoration: none;
	color: #666;
	font-weight: 500;
	transition: color 0.2s;
	padding: 0.5rem 1rem;
	border-radius: 0.5rem;
}

.nav-links a:hover {
	color: #1a1a1a;
	background-color: #f5f5f5;
}

/* Header styles */
.header {
	background-color: white;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	padding: 1.5rem 1rem;
}

.header-content {
	max-width: 1200px;
	margin: 0 auto;
}

.header h1 {
	font-size: 2rem;
	font-weight: 700;
	color: #1a1a1a;
}

/* Main content styles */
.main-content {
	max-width: 1200px;
	margin: 2rem auto;
	padding: 0 1rem;
}

.menu-grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
	gap: 1.5rem;
	padding: 1rem 0;
}

/* Menu card styles */
/* Menu card styles */
.menu-card {
	background: white;
	border-radius: 12px;
	overflow: hidden;
	height: 400px; /* Fixed height for the card */
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	transition: transform 0.2s, box-shadow 0.2s;
	display: flex;
	flex-direction: column; /* Stack image and info vertically */
}

.menu-card:hover {
	transform: translateY(-4px);
	box-shadow: 0 8px 12px rgba(0, 0, 0, 0.15);
}

.menu-image {
	width: 100%;
	height: 50%; /* Image takes up half the card height */
	object-fit: cover;
}

.menu-info {
	padding: 1.25rem;
	flex: 1; /* Takes the remaining space below the image */
}

.menu-name {
	font-size: 1.25rem;
	font-weight: 600;
	margin-bottom: 0.75rem;
	color: #1a1a1a;
}

.menu-description {
	color: #666;
	margin-bottom: 1rem;
	font-size: 0.9rem;
}

.price-availability {
	display: flex;
	justify-content: space-between;
	/* Aligns the price and availability in one line */
	margin-bottom: 1rem;
}

.menu-price {
	font-size: 1.25rem;
	font-weight: 600;
	color: #1a73e8;
}

.availability-badge {
	background-color: #e6f4ea;
	color: #1b873f;
	padding: 0.25rem 0.75rem;
	border-radius: 1rem;
	font-weight: 600;
	font-size: 0.875rem;
}

.add-to-cart-btn {
	width: 100%;
	background-color: #1a73e8;
	color: white;
	border: none;
	padding: 0.75rem;
	border-radius: 0.5rem;
	font-size: 1rem;
	font-weight: 500;
	cursor: pointer;
	transition: background-color 0.2s;
}

.add-to-cart-btn:hover {
	background-color: #1557b0;
}

/* Footer styles */
.footer {
	background-color: #1a1a1a;
	color: #fff;
	padding: 3rem 1rem;
	margin-top: 4rem;
}

.footer-content {
	max-width: 1200px;
	margin: 0 auto;
	display: flex;
	justify-content: space-between;
	gap: 1rem;
}

.footer-section {
	display: flex;
	flex-direction: column;
	width: 500px;
	gap: 1rem;
}

.footer-section h3 {
	color: #fff;
	font-size: 1.25rem;
	margin-bottom: 0.5rem;
}

.footer-section p {
	color: #999;
	font-size: 0.9rem;
}

.footer-bottom {
	text-align: center;
	padding-top: 2rem;
	margin-top: 2rem;
	border-top: 1px solid #333;
	color: #666;
}

/* Responsive adjustments */
@media ( max-width : 768px) {
	.nav-container {
		flex-direction: column;
		gap: 1rem;
	}
	.nav-links {
		flex-direction: column;
		width: 100%;
		text-align: center;
	}
	.nav-links a {
		width: 100%;
		padding: 0.75rem;
	}
	.menu-grid {
		grid-template-columns: 1fr;
	}
	.header h1 {
		font-size: 1.5rem;
	}
}
</style>
</head>
<body>
	<!-- Navigation Bar -->
	<nav class="navbar">
		<div class="nav-container">
			<a href="/" class="logo"> <span class="logo-icon">🍽️</span> Food
				Delivery
			</a>
			<div class="nav-links">
				<a href="login.jsp">Login</a> <a href="register.jsp"
					class="register-btn">Register</a>
			</div>
		</div>
	</nav>

	<!-- Header -->
	<header class="header">
		<div class="header-content">
			<h1>
				Menu -
				<%=session.getAttribute("restaurantName")%></h1>
		</div>
	</header>

	<!-- Main Content -->
	<main class="main-content">
		<div class="menu-grid">
			<%
			List<Menu> menuList = (List<Menu>) session.getAttribute("menu");
			if (menuList != null && !menuList.isEmpty()) {
				for (Menu menu : menuList) {
			%>
			<div class="menu-card">
				<img src="<%=menu.getImagePath()%>" alt="<%=menu.getName()%>"
					class="menu-image">
				<div class="menu-info">
					<h3 class="menu-name"><%=menu.getName()%></h3>
					<p class="menu-description"><%=menu.getDescription()%></p>
					<div class="price-availability">
						<p class="menu-price">
							₹<%=menu.getPrice()%></p>
						<p class="availability-badge">
							<%=menu.getisAvailable() ? "Available" : "Not Available"%>
						</p>
					</div>
					<form action="CartS" method="post">
						<input type="hidden" name="action" value="add"> <input
							type="hidden" name="menuID" value="<%=menu.getMenuID()%>">
						<input type="hidden" name="menuName" value="<%=menu.getName()%>">
						<input type="hidden" name="menuPrice"
							value="<%=menu.getPrice()%>">
						<button type="submit" class="add-to-cart-btn">Add to Cart</button>
					</form>
				</div>
			</div>


			<%
			}
			} else {
			%>
			<div
				style="grid-column: 1/-1; text-align: center; padding: 2rem; color: #666;">
				<p>No menu items found for this restaurant.</p>
			</div>
			<%
			}
			%>
		</div>
	</main>

	<!-- Footer -->
	<footer class="footer">
		<div class="footer-content">
			<div class="footer-section">
				<h3>About Us</h3>
				<p>We're dedicated to bringing your favorite restaurants right
					to your doorstep. Fast, reliable, and delicious food delivery
					service.</p>
			</div>
			<div class="footer-section">
				<h3>Contact Info</h3>
				<p>📞 Phone: (123) 456-7890</p>
				<p>✉️ Email: support@fooddelivery.com</p>
				<p>🏠 Address: 123 Food Street, Cuisine City</p>
			</div>
		</div>
		<div class="footer-bottom">
			<p>&copy; 2024 Food Delivery. All rights reserved.</p>
		</div>
	</footer>
</body>
</html>