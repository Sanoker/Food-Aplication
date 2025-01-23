<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check out</title>
<style>
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

        .nav-links a:hover {
            color: #1a1a1a;
            background-color: #f5f5f5;
        }

        /* Main content styles */
        .main-content {
            max-width: 600px;
            margin: 2rem auto;
            padding: 2rem;
        }

        .checkout-form {
            background: white;
            padding: 2rem;
            border-radius: 12px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .form-title {
            font-size: 1.8rem;
            font-weight: 700;
            color: #1a1a1a;
            margin-bottom: 1.5rem;
            text-align: center;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-group label {
            display: block;
            font-weight: 500;
            margin-bottom: 0.5rem;
            color: #4a4a4a;
        }

        .form-group textarea {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 1rem;
            min-height: 100px;
            resize: vertical;
            transition: border-color 0.2s;
        }

        .form-group textarea:focus {
            outline: none;
            border-color: #1a73e8;
        }

        .form-group select {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 1rem;
            background-color: white;
            cursor: pointer;
            transition: border-color 0.2s;
        }

        .form-group select:focus {
            outline: none;
            border-color: #1a73e8;
        }

        .submit-btn {
            width: 100%;
            padding: 1rem;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .submit-btn:hover {
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
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 2rem;
        }

        .footer-section {
            display: flex;
            flex-direction: column;
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
        @media (max-width: 768px) {
            .main-content {
                margin: 1rem;
                padding: 1rem;
            }

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
        }
    </style>
</head>
<body> <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="nav-container">
            <a href="/" class="logo">
                <span class="logo-icon">🍽️</span>
                Food Delivery
            </a>
        </div>
    </nav>

    <!-- Main Content -->
    <main class="main-content">
        <form class="checkout-form" action="CheckoutS" method="post">
            <h2 class="form-title">Checkout</h2>
            
            <div class="form-group">
                <label for="address">Delivery Address</label>
                <textarea 
                    id="address" 
                    name="address" 
                    placeholder="Enter your complete delivery address"
                    required
                ></textarea>
            </div>
            
            <div class="form-group">
                <label for="paymentMethod">Payment Method</label>
                <select id="paymentMethod" name="paymentMethod" required>
                    <option value="" disabled selected>Select payment method</option>
                    <option value="debit">Debit Card</option>
                    <option value="credit">Credit Card</option>
                    <option value="cash">Cash on Delivery</option>
                </select>
            </div>
            
            <button type="submit" class="submit-btn">Place Order</button>
        </form>
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
</html>