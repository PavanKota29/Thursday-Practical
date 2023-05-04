package com.library.LibExp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;

public class App 
{
    public static void main( String[] args ) throws Exception,SQLSyntaxErrorException
    {
    	ConnectDataBase db=new ConnectDataBase();
    	Connection con=db.create();
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		while(true) {
			
			System.out.print("\n----Library Management system----\n1.Insert The Book Record Into Table !!!\n2.Update The Book Record in Table !!!!!\n"
					+ "3.Delete The Book Record From Table !!!!\n4.Show All Book Records\n--Enter Your Choice:");
			
			switch (Integer.parseInt(br.readLine())) {
			case 1:										//For Inserting Record 
				System.out.println("\nEnter BookId:");
				int bid=Integer.parseInt(br.readLine());
				System.out.println("\nEnter BookName:");
				String bname=br.readLine();
				System.out.println("Enter AuthorName:");
				String aname=br.readLine();
			
				if(db.insert(con,bid, bname, aname)==1) {
					System.out.println("Record Inserted Successfully !!!!!");
				}else {
					System.out.println("Error !!!!");
				}
				break;
			case 2:										//For Updating Record 
				System.out.println("\nEnter BookId:");
				if(db.update(con,Integer.parseInt(br.readLine()))==1) {
					System.out.println("Record Updated Successfully !!!");
				}else {
					System.out.println("Record Not Found !!!");
				}
				break;
			case 3:										// For Deleting Record
				System.out.println("\nEnter BookId");
				if(db.delete(con, Integer.parseInt(br.readLine()))==1) {
					System.out.println("Record Deleted Successfully !!!!");
				}else {
					System.out.println("Record Not Found !!");
				}
				break;
			case 4:										//For Showing All Records in Table
				ResultSet rs=db.select(con);
				System.out.println("\n-----------------Book Records In Tables-----------------\nBookId\t\tBookName\t\tAuthorName");
				while(rs.next()) {
					System.out.println(rs.getInt("Bookid")+"\t\t"+rs.getString("BookName")+"\t\t"+rs.getString("AuthorName"));
				}
				break;
			default:
				System.out.println("Choice Correct Option !!!");
				break;
			}
		}		
    }
}
