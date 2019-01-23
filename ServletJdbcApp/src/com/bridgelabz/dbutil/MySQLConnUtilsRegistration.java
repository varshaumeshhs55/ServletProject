package com.bridgelabz.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.RegistrationForm;
import com.bridgelabz.model.UserInfo;



public class MySQLConnUtilsRegistration{
	 
	 
	   // Connect to MySQL
	   public static Connection getMySQLConnection() throws SQLException,
	           ClassNotFoundException {
	       String hostName = "localhost";
	       String dbName = "ServletProject";
	       String userName = "root";
	       String password = "password";
	 
	       return getMySQLConnection(hostName, dbName, userName, password);
	   }
	 
	   public static Connection getMySQLConnection(String hostName, String dbName,
	           String userName, String password) throws SQLException,
	           ClassNotFoundException {
	    
	       Class.forName("com.mysql.jdbc.Driver");
	 
	       String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	 
	       Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	       return conn;
	   }
	   public static void registration(RegistrationForm registrationform) throws ClassNotFoundException, SQLException
	   {
		   // Get a connection
	        Connection connection = getMySQLConnection();
	        // Create a SQL statement with two parameters (?)
	        String sql ="insert into User values(?,?,?,?,?,?)";
	        // Create a PreparedStatement object.
	        PreparedStatement pstm = connection.prepareStatement(sql);
	        pstm.setInt(1, 0);
	        pstm.setString(2, registrationform.getFirstName());
	        pstm.setString(3, registrationform.getLastName());
	        pstm.setString(4, registrationform.getEmailId());
	        pstm.setString(5, registrationform.getPassword());
	        pstm.setString(6, registrationform.getMobNo());
            pstm.execute();
            connection.close();
	   }
	   public static boolean loginservlet(UserInfo userinfo) throws ClassNotFoundException, SQLException {
		   // Get a connection
	        Connection connection = getMySQLConnection();
	        // Create a SQL statement with two parameters (?)
	        String sql ="select * from User where Email_Id=? and Password=?";
	        PreparedStatement pstm = connection.prepareStatement(sql);
	        pstm.setString(1, userinfo.getUserName());
	        pstm.setString(2, userinfo.getPassword());
	        ResultSet rs=pstm.executeQuery();
	        while(rs.next()) {
	        return true;
	        }
	        connection.close();
	        return false;
		   
	   }
	}