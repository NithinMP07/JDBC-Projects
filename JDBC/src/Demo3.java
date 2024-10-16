//Program for inserting the data

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo3 {
 public static void main(String args[]) throws Exception {
	 
	 //loading the driver
	 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	 System.out.println("Driver loaded successfully");
	 
	 //establishing the connection
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "123456789");
	 System.out.println("Connection established");
	 
	String s="insert into student values(?,?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(s);
	Scanner sc= new Scanner(System.in);
	System.out.print("Enter the id: ");
	int id=sc.nextInt();
	
	System.out.print("Enter name: ");
	String name=sc.next();
	
	System.out.print("Enter marks1: ");
	int marks1=sc.nextInt();
	
	System.out.print("Enter marks2: ");
	int marks2=sc.nextInt();
	
	System.out.print("Enter marks3: ");
	int marks3=sc.nextInt();
	
	System.out.print("Enter result: ");
	String result=sc.next();
	
	pstmt.setInt(1, id);
	pstmt.setString(2, name);
	pstmt.setInt(3, marks1);
	pstmt.setInt(4, marks2);
	pstmt.setInt(5, marks3);
	pstmt.setString(6, result);

	int row=pstmt.executeUpdate();
	System.out.println(row);
	
	
	// print  the result 
	
	
//	String s1="Select * from student";
//	Statement stmt=con.createStatement();
//	ResultSet res=stmt.executeQuery(s1);
//	
//	while(res.next()==true) {
//		 int id1=res.getInt(1);
//		 String name1=res.getString(2);
//		 int marks11=res.getInt(3);
//		 int marks22=res.getInt(4);
//		 int marks33=res.getInt(5);
//		 String result1=res.getString(6);
//		 
//		 System.out.println(id1+" "+name1+" "+marks11+" "+marks22+" "+marks33+" "+result1);
//	 }
//	 
 }
}

