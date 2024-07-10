package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginDTO")
public class loginDTO extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userDatabase";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kishore";
    
    private static final String COMPARE_USER_DETAILS = "SELECT * FROM usersList;";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        
		String userNameJSP = request.getParameter("userName");
        String userPasswordJSP = request.getParameter("userPassword");
        String userName = null;
		String userDetails = null;
		String errorMessage = null;
		boolean loginStatus = false;
        
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COMPARE_USER_DETAILS);
            
            while (resultSet.next()) 
            {
                userName = resultSet.getString("userName");
                String userPassword = resultSet.getString("userPassword");
                userDetails = resultSet.getString("userDetails");
                
                if (userNameJSP.equals(userName))
                {
                	if (userPasswordJSP.equals(userPassword))
                	{
	                	loginStatus = true;
	                	break;
                	}
                	else
                	{
                		errorMessage = "Error! Password Mismatch!!";
                		loginStatus = false;
                		break;
                	}
                }
            }
            
            if (loginStatus)
            {
            	request.setAttribute("userName", userName);
            	request.setAttribute("userDetails", userDetails);
            	request.getRequestDispatcher("successPage.jsp").forward(request, response);
            }
            
            else
            {
            	if (errorMessage == null)
            		errorMessage = "Error! Username Mismatch!!";
            	request.setAttribute("errorMessage", errorMessage);
            	request.getRequestDispatcher("failurePage.jsp").forward(request, response);
            }
        } 
        
        catch (SQLException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
	}
}
