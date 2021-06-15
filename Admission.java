/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Muneeb
 */
public class Admission {
    private Connection con;
	private Statement stmt;
	private ResultSet re;
	public boolean connect() throws Exception
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;databaseName=CareerCounsellingSystem";
			String name="new_user";
			String password="123";
			con=DriverManager.getConnection(url,name,password);
			stmt=con.createStatement();
			return true;
		  }
		  catch(SQLException e)
		  {
			  System.out.print(e);
			  return false;
	 	  }
	}
}
