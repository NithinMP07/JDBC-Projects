import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root", "123456789");
		Scanner sc=new Scanner(System.in);
		//Transaction method
		con.setAutoCommit(false);
		String s1="insert into student values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(s1);
		System.out.print("Enter id: ");
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
		pstmt.executeUpdate();
		
		
		String s2="insert into student values(?,?,?,?,?,?)";
		PreparedStatement pstmt2=con.prepareStatement(s2);
		System.out.print("Enter id: ");
		int id2=sc.nextInt();
		System.out.print("Enter name: ");
		String name2=sc.next();
		System.out.print("Enter marks1: ");
		int marks12=sc.nextInt();	
		System.out.print("Enter marks2: ");
		int marks22=sc.nextInt();
		System.out.print("Enter marks3: ");
		int marks32=sc.nextInt();
		System.out.print("Enter result: ");
		String result2=sc.next();
		pstmt2.setInt(1, id2);
		pstmt2.setString(2, name2);
		pstmt2.setInt(3, marks12);
		pstmt2.setInt(4, marks22);
		pstmt2.setInt(5, marks32);
		pstmt2.setString(6, result2);
		pstmt2.executeUpdate();
		
		con.commit();

	}

}
