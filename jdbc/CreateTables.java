package com.ipstep.jdbc;

import java.sql.*;


public class CreateTables {
	public void createTable(Connection conn) throws SQLException {
		Statement stat = conn.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS FACULTY "
				+ "(ID INT PRIMARY KEY    NOT NULL," 
				+ "NAME        TEXT    NOT NULL, "
				+ "FAMILY         TEXT    NOT NULL, "
				+ "F_NUM        INT) ";
		stat.execute(sql);
		stat.close();
		
		System.out.println("System created successfully!");
	}
	
	public void deleteTable(Connection conn)throws SQLException{    
	    Statement st = conn.createStatement();
	    String sql = "drop table company";
	    st.execute(sql);
	    st.close();
	     conn.close();
	     System.out.println("Table was droped!");
	}
}
