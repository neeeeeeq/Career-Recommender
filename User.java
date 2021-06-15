/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muneeb
 */
public abstract class User {
    
    protected Profile prof;
    
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
    
        
        public Profile viewProfile()
        {
            String usrName=prof.userName;
            Profile temp=new Profile();
        try {
            temp=prof.displayProfile(usrName);
        } 
        catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
            return temp;
        }
        
        public abstract void setProfile(Profile profile);
        
        public boolean logOut(String userName) throws SQLException
        {
            String temp="Select * from LoggedIn";
            
            re=stmt.executeQuery(temp);
            
            while(re.next())
            {
                String a=re.getString("usrName");
                if(userName.equals(a))
                {
                    String query= "Delete from LoggedIn Where userName=?";
                            
                            PreparedStatement prst=con.prepareStatement(query);
                                
                            prst.setString(1, userName);
                            prst.executeUpdate();
                            return true;
                }
            }
            return false;
        }
        
    
}
