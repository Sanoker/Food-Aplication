<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  /* General Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        /* Delivery animation styles */
        .animation-container {
            position: relative;
            width: 100%;
            height: 150px;
            margin-bottom: 20px;
            overflow: hidden;
        }

        .delivery-boy {
            position: absolute;
            bottom: 20px;
            left: -200px;
            width: 150px;
            animation: moveBike 5s linear infinite;
        }

        @keyframes moveBike {
            0% {
                left: -200px;
            }
            50% {
                left: 50%;
            }
            100% {
                left: 100%;
            }
        }

        /* Message container styles */
        .message-container {
            text-align: center;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            z-index: 10;
        }

        h1 {
            color: #4CAF50;
            font-size: 24px;
            margin-bottom: 10px;
        }

        p {
            font-size: 18px;
            color: #333;
            margin-bottom: 20px;
        }

        a {
            display: inline-block;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="animation-container">
        <!-- Replace the path below with your image path -->
        <img src="th.jpg" alt="Delivery Boy on Bike" class="delivery-boy">
    </div>

    <div class="message-container">
        <h1>Order Successful!</h1>
        <p>Your order has been placed successfully.</p>
        <p>Please click here to <a href="GetAllRestaurants">Home</a></p>
    </div>
</body>
</html>