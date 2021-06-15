/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author Muneeb
 */
public class DBcon {
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
        public boolean login(String userName,String pass) throws SQLException
	{
		String sql="Select * from [Profile]";
		re=stmt.executeQuery(sql);
		while(re.next())
		{
			String a=re.getString("userName");
			String b=re.getString("password");
			if(userName.equals(a))
			{
				if(pass.equals(b))
				{
                                    String query="Insert into LoggedIn (usrName) values(?)";
                                    PreparedStatement prst=con.prepareStatement(query);
                                    prst.setString(1, a);
                                    prst.executeUpdate();
					return true;
				}
			}
		}
		return false;
}
        
       
}


