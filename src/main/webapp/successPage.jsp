<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>User Details</title>
	    <style>
	        body 
	        {
	            font-family: Arial, sans-serif;
	            background-color: #f7f7f7;
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            height: 100vh;
	            margin: 0;
	        }
	
	        .container 
	        {
	            padding: 20px;
	            border: 1px solid #ccc;
	            border-radius: 10px;
	            background-color: #fff;
	            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	        }
	
	        h1 
	        {
	            margin-bottom: 20px;
	        }
	    </style>
	</head>
	<body>
	    <div class="container">
	        <h1>Welcome, ${requestScope.userName}</h1>
	        <p><strong>Your Message: </strong> ${requestScope.userDetails}</p>
	    </div>
	</body>
</html>
