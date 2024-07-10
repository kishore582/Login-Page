<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Error Page</title>
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
	            text-align: center;
	        }
	
	        h1 
	        {
	            margin-bottom: 20px;
	            color: #d9534f;
	        }

	        p 
	        {
	            color: #333;
	        }
	    </style>
	</head>
	<body>
	    <div class="container">
	        <h1>Login Failed</h1>
	        <p><strong>Reason:</strong> ${requestScope.errorMessage}</p>
	        <a href=loginPage.jsp><strong>PLEASE TRY AGAIN</strong></a>
	    </div>
	</body>
</html>
