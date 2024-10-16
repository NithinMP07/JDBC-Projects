package com.quntnex.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LaunchCRUD {
    public static void main( String[] args ) throws Exception{
       DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "123456789");
       
       String s="select * from student";
      Statement st= con.createStatement(); 
      ResultSet res=st.executeQuery(s);
      
      while(res.next()==true) {
 		 int id=res.getInt(1);
 		 String name=res.getString(2);
 		 int marks1=res.getInt(3);
 		 int marks2=res.getInt(4);
 		 int marks3=res.getInt(5);
 		 String result=res.getString(6);
 		 
 		 System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3+" "+result);
 	 }
       }
}
