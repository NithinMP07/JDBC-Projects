
//Program for accessing an individual student details

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo2 {
public static void main(String args[]) throws Exception {
	 
	 //loading the driver
	 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	 System.out.println("Driver loaded successfully");
	 
	 //establishing the connection
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "123456789");
	 System.out.println("Connection established");
	 
	String s="Select * from student where id=?";
	PreparedStatement pstmt=con.prepareStatement(s);
	System.out.print("Enter the id: ");
	Scanner sc= new Scanner(System.in);
	int id=sc.nextInt();
	pstmt.setInt(1, id);
	
	ResultSet res=pstmt.executeQuery();

	 	 
	 if(res.next()) {
		 id=res.getInt(1);
		 String name=res.getString(2);
		 int marks1=res.getInt(3);
		 int marks2=res.getInt(4);
		 int marks3=res.getInt(5);
		 String result=res.getString(6);
		 
		 System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3+" "+result);
	 }
	 else {
		 System.out.println("Invalid ID");
	 }
	 
}
}
