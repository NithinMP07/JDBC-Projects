
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class user1 {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("1.Register");
	System.out.println("2.Login");
	System.out.print("Enter your choice: ");
	int choice=sc.nextInt();
	
	switch(choice) {
	case 1:register();
	break;
	
	case 2:login();
	break;
	
	default: System.out.println("Invalid choice");
	break;
	}
}
	
	static void register() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root", "123456789");
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter name: ");
		String name=sc.next();
		System.out.print("Enter username: ");
		String username=sc.next();
		
		//for checking the unique username
		while(true) {
		String s="select * from user where username=?;";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1,username);
		ResultSet res=pstmt.executeQuery();
		
		if(res.next()) {
			System.out.println("Username already exists, please enter another username");
			username=sc.next();
		}
		else {
			break;
		}
		}
		String password,cnfrmpassword;
		do {
		System.out.print("Enter password: ");
		 password=sc.next();
		System.out.print("Enter confirm password: ");
		 cnfrmpassword=sc.next();
		}
		while(!password.equals(cnfrmpassword));
		
		System.out.print("Enter email: ");
		String email=sc.next();
		
		String s1="insert into user values(?,?,?,?);";
		PreparedStatement pstmt1=con.prepareStatement(s1);
		pstmt1.setString(1, name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		
		int row=pstmt1.executeUpdate();
		System.out.println(row+" row effected");
		}
	
	static void login() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root", "123456789");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the username: ");
		String username=sc.next();
		System.out.print("Enter password:");
		String password=sc.next();
		String s1="select * from user where username=?";
		PreparedStatement pstmt=con.prepareStatement(s1);
		pstmt.setString(1, username);
		ResultSet res=pstmt.executeQuery();
		if(res.next()) {
			if(password.equals(res.getString(3))) {
				System.out.println("Loggin successful");
			}
			else {
				System.out.println("Invalid password");
			}
		}
		else {
			System.out.println("Invalid username");
		}
		
		
//		while(true) {
//			String s="select * from user where username=?;";
//			PreparedStatement pstmt=con.prepareStatement(s);
//			pstmt.setString(1,username);
//			ResultSet res=pstmt.executeQuery();
//			if(res.next()) {
//				break;
//			}
//			else {
//				System.out.print("Enter correct user name: ");
//				username=sc.next();
//			}
//		}
//		System.out.print("Enter the password: ");
//		String password=sc.next();
//		while(true) {
//			String s1="select * from user where password=?;";
//			PreparedStatement pstmt=con.prepareStatement(s1);
//			pstmt.setString(1,password);
//			ResultSet res=pstmt.executeQuery();
//			if(res.next()) {
//				break;
//			}
//			else {
//				System.out.print("Enter correct password: ");
//				password=sc.next();
//			}
//		}
//		System.out.println("Successfully Logged In");
		
		
	}
}
