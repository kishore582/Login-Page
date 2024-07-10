package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/signupDAO")
public class signupDAO extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userDatabase";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kishore";

	private static final String INSERT_USER_DETAILS = "INSERT INTO usersList (userName, userPassword, userDetails) VALUES (?, ?, ?);";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userNameJSP = request.getParameter("userName");
        String userPasswordJSP = request.getParameter("userPassword");        
        String userDetailsJSP = request.getParameter("userDetails");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try 
        {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            // Create a PreparedStatement to execute the SQL query
            preparedStatement = connection.prepareStatement(INSERT_USER_DETAILS);
            preparedStatement.setString(1, userNameJSP);
            preparedStatement.setString(2, userPasswordJSP);
            preparedStatement.setString(3, userDetailsJSP);
            preparedStatement.executeUpdate();
            response.sendRedirect("accountCreated.jsp");

        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close the PreparedStatement and Connection to release resources
            if (preparedStatement != null) 
            {
                try 
                {
                    preparedStatement.close();
                }
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
            if (connection != null) 
            {
                try 
                {
                    connection.close();
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        
        // Redirect to the output page
        
    }
}