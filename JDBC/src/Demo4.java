//Update the table  --> update student set name= "shahil" where id=4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo4 {
	public static void main(String args[]) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","123456789");
		System.out.println("Connection established");
		
		String s="update student set name=? where id=? ";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name: ");
		String name=sc.next();
		System.out.println("Enter the id: ");
		int id=sc.nextInt();
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int row=pstmt.executeUpdate();
		System.out.println(row);
		
		
	}
}
