<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>User Login Page</title>
	    
	    <style>
	        body 
	        {
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            height: 100vh;
	            margin: 0;
	            font-family: Arial, sans-serif;
	            background-color: #f7f7f7;
	        }
	
	        .container 
	        {
	            width: 50%;
	            max-width: 400px;
	            padding: 20px;
	            border: 1px solid #ccc;
	            border-radius: 10px;
	            background-color: #fff;
	            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	            text-align: center;
	        }
	
	        h1 
	        {
	            margin-bottom: 20px;
	            color: #333;
	        }
	
	        .form-group 
	        {
	            margin-bottom: 15px;
	            text-align: left;
	        }
	
	        .form-group label 
	        {
	            display: block;
	            margin-bottom: 5px;
	            font-weight: bold;
	        }
	
	        .form-group input 
	        {
	            width: calc(100% - 16px);
	            padding: 8px;
	            margin: 0 auto;
	            border: 1px solid #ccc;
	            border-radius: 5px;
	        }
	
	        .actions 
	        {
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            gap: 20px;
	            margin-top: 20px;
	        }
	
	        .actions input[type="submit"], .actions button 
	        {
	            padding: 10px 20px;
	            background-color: #2ac2d1;
	            color: white;
	            border: none;
	            border-radius: 5px;
	            cursor: pointer;
	            font-size: 16px;
	        }
	
	        .actions input[type="submit"]:hover, .actions button:hover 
	        {
	            background-color: #45a049;
	        }
	
	        .actions form 
	        {
	            display: inline-block;
	            margin: 0;
	        }
	    </style>
	</head>
	<body>
	    <div class="container">
	        <h1>User Login</h1>
	        <form action="loginDTO" method="get">
	            <div class="form-group">
	                <label for="userName">User Name:</label>
	                <input type="text" id="userName" name="userName" required>
	            </div>
	            <div class="form-group">
	                <label for="userPassword">Password:</label>
	                <input type="password" id="userPassword" name="userPassword" required>
	            </div>
	            <div class="actions">
	                <input type="submit" value="Login">
	            </div>
	        </form>
	        <br><a href="signupPage.jsp">Create New Account</a>
	    </div>
	</body>
</html>
