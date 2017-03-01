/**
 * 
 */
package com.bms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sneha
 *
 */
public class DBConnection {

Connection connection;
	
	public Connection getConnection()
	{				
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			//connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","sneha@212");   
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bms","postgres","sneha@212");   
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	
	return connection; 
	}

}
