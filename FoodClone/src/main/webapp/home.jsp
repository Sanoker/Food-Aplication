<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant List</title>
    <style>
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
 
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            line-height: 1.6;
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

        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 1.5rem;
            padding: 1rem 0;
        }

        /* Restaurant card styles */
        .restaurant-card {
            background: white;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s, box-shadow 0.2s;
            text-decoration: none;
            color: inherit;
            position: relative;
        }

        .restaurant-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.15);
        }

        .restaurant-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .restaurant-info {
            padding: 1.25rem;
        }

        .restaurant-name {
            font-size: 1.25rem;
            font-weight: 600;
            margin-bottom: 0.75rem;
            color: #1a1a1a;
        }

        .info-row {
            display: flex;
            align-items: center;
            margin-bottom: 0.5rem;
            color: #666;
        }

        .info-icon {
            width: 20px;
            height: 20px;
            margin-right: 0.5rem;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .rating-badge {
            display: inline-flex;
            align-items: center;
            background-color: #e6f4ea;
            color: #1b873f;
            padding: 0.25rem 0.75rem;
            border-radius: 1rem;
            font-weight: 600;
            font-size: 0.875rem;
        }

        .status-badge {
            margin-left: 0.75rem;
            font-size: 0.875rem;
            color: #666;
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
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1rem;
        }

        .footer-section {
            display: flex;
            flex-direction: column;
            width: 500px;
            gap: 1rem
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

        .footer-links {
            list-style: none;
        }

        .footer-links li {
            margin-bottom: 0.5rem;
        }

        .footer-links a {
            color: #999;
            text-decoration: none;
            transition: color 0.2s;
        }

        .footer-links a:hover {
            color: #fff;
        }

        .footer-bottom {
            text-align: center;
            padding-top: 2rem;
            margin-top: 2rem;
            border-top: 1px solid #333;
            color: #666;
        }

        /* Responsive adjustments */
        @media (max-width: 768px) {
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
            .restaurant-grid {
                grid-template-columns: 1fr;
            }

            .header h1 {
                font-size: 1.5rem;
            }
        }

        /* Icons using Unicode characters */
        .icon-star::before {
            content: "★";
            color: #1b873f;
        }
        
        .icon-clock::before {
            content: "⏰";
        }
        
        .icon-location::before {
            content: "📍";
        }
        
        .icon-cuisine::before {
            content: "🍽️";
        }
        
        
    </style>
</head>
<body>
  <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="nav-container">
            <a href="/" class="logo">
                <span class="logo-icon">🍽️</span>
                Food Delivery
            </a>
            <div class="nav-links">
                <a href="login.jsp">Login</a>
                <a href="register.jsp" class="register-btn">Register</a>
            </div>
        </div>
    </nav>
    
  <header class="header">
        <div class="header-content">
            <h1>Welcome, <%= session.getAttribute("username") %></h1>
        </div>
    </header>

    <main class="main-content">
        <div class="restaurant-grid">
            <%
                List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurants");
                if (restaurants != null && !restaurants.isEmpty()) {
                    for (Restaurant restaurant : restaurants) {
            %>
            <a href="GetMenu?restaurantID=<%= restaurant.getRestaurantID() %>" class="restaurant-card">
                <img src="<%= restaurant.getImagePath() %>" alt="<%= restaurant.getName() %>" class="restaurant-image">
                <div class="restaurant-info">
                    <h3 class="restaurant-name"><%= restaurant.getName() %></h3>
                    
                    <div class="info-row">
                        <span class="info-icon icon-cuisine"></span>
                        <span><%= restaurant.getCuisineType() %></span>
                    </div>
                    
                    <div class="info-row">
                        <span class="info-icon icon-clock"></span>
                        <span><%= restaurant.getDeliveryTime() %> mins</span>
                    </div>
                    
                    <div class="info-row">
                        <span class="info-icon icon-location"></span>
                        <span><%= restaurant.getAddress() %></span>
                    </div>
                    
                    <div class="info-row">
                        <div class="rating-badge">
                            <span class="icon-star"></span>
                            <span><%= restaurant.getRatings() %></span>
                        </div>
                        <span class="status-badge">
                            <%= restaurant.isActive() ? "Open" : "Closed" %>
                        </span>
                    </div>
                </div>
            </a>
            <%
                    }
                } else {
            %>
            <div style="grid-column: 1 / -1; text-align: center; padding: 2rem; color: #666;">
                <p>No restaurants found.</p>
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
                <p>We're dedicated to bringing your favorite restaurants right to your doorstep. Fast, reliable, and delicious food delivery service.</p>
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
</body>
</html>
