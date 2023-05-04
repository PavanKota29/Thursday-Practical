package com.library.LibExp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDataBase {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//For getting input from users
	//this function will return connection object 
	Connection create() throws Exception {
		String url="jdbc:mysql://localhost:3306/mydb";
        String username="root";
        String password="1234";
        Connection c=DriverManager.getConnection(url, username, password);
        
      //For Table Creation it will call every time any check if table is exist or not and according that it 
        //will create the table 
		String qry="CREATE TABLE IF NOT EXISTS library ("
		+ "  Bookid INT(11) NOT NULL PRIMARY KEY,"
		+ "  BookName VARCHAR(255) NOT NULL,"
		+ "  AuthorName VARCHAR(255) NOT NULL);";
		Statement st=c.createStatement();
		st.execute(qry);
		
        return c;
    }
	
	//this function will return 1 if record is inserted into table other wise it will return 0
	int insert(Connection c,int bid,String bname,String aname) throws Exception{
		PreparedStatement ps=c.prepareStatement("insert into library (Bookid,BookName,AuthorName) values (?,?,?);");
		ps.setInt(1,bid);
		ps.setString(2,bname);
		ps.setString(3, aname);
		return ps.executeUpdate();
	}
	
	//this function will return 1 if record is updated in table other wise it will return 0
	int update(Connection c,int bid) throws Exception {
		System.out.println("--What you want to update\n--1.BookName\n--2.AuthorName");
		System.out.println("Enter Your Choice:");
		switch (Integer.parseInt(br.readLine())) {
		case 1:
			PreparedStatement p1=c.prepareStatement("update library set BookName=? where Bookid=?");
			System.out.println("Enter BookName:");
			p1.setString(1, br.readLine());
			p1.setInt(2, bid);
			return p1.executeUpdate();
		case 2:
			PreparedStatement p2=c.prepareStatement("update library set AuthorName=? where Bookid=?");
			System.out.println("Enter AuthorName:");
			p2.setString(1, br.readLine());
			p2.setInt(2, bid);
			return p2.executeUpdate();
		default :
			System.out.println("Invaild choice !!");
		}
		return 0;
	}
	
	//this function will return 1 if record is deleted from  table, other wise it will return 0
	int delete(Connection c,int bid) throws Exception {
		PreparedStatement pd=c.prepareStatement("delete from library where Bookid=?;");
		pd.setInt(1,bid);
		return pd.executeUpdate();
	}
	
	//this function will return Result set object 
	ResultSet select(Connection c) throws Exception {
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery("Select * from library;");
		return rs;
	}
}
