import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
		System.out.println();
		System.out.println("1.Create/Insert\n2.Read\n3.Update\n4.Delete\n5.Stop Process\n");
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		System.out.println();
		switch(choice) {
		case 1:insert();
		break;
		case 2:read();
		break;
		case 3:update();
		break;
		case 4:delete();
		break;
		case 5: System.out.println("Process stopped.");
        break;
		default: System.out.println("Invalid choice. Please try again.");
		break;
		}	
	}while(choice != 5);
	}

	 static void insert() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","123456789");
		
		String s="insert into employee values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter the empid: ");
		int empid=sc.nextInt();
		System.out.print("Enter ename: ");
		String ename=sc.next();
		System.out.print("Enter phn_no ");
		String phn_no=sc.next();
		System.out.print("Enter city ");
		String city=sc.next();
		System.out.print("Enter job_title ");
		String job_title=sc.next();
		
		pstmt.setInt(1, empid);
		pstmt.setString(2, ename);
		pstmt.setString(3, phn_no);
		pstmt.setString(4, city);
		pstmt.setString(5, job_title);
		
		int row=pstmt.executeUpdate();
		if(row>0) {
			System.out.println("A new Employee added successfully");
		}
		con.close();		
	}
	 
	 static void read() throws Exception {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","123456789");
			
			String s="select * from employee;";
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(s);
			
			 while(res.next()==true) {
				 int empid=res.getInt(1);
				 String ename=res.getString(2);
				 String phn_no=res.getString(3);
				 String city=res.getString(4);
				 String job_title=res.getString(5);
				 System.out.println(empid+" "+ename+" "+phn_no+" "+city+" "+job_title);
			 }
			 con.close();
			 res.close();	 
		
	}
	 static void update() throws Exception {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","123456789");
			
			String s="update employee set ename=? where empid=? ";
			PreparedStatement pstmt=con.prepareStatement(s);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the ename: ");
			String ename=sc.next();
			System.out.println("Enter the empid: ");
			int empid=sc.nextInt();
			pstmt.setString(1, ename);
			pstmt.setInt(2, empid);
			
			int row=pstmt.executeUpdate();
			if(row>0) {
				System.out.println("Employee name updated successfully");
			}
			con.close();
			pstmt.close();
		
	}
	
	 static void delete() throws Exception {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","123456789");
		 
		 String s="delete from employee where empid=? ";
		 PreparedStatement pstmt=con.prepareStatement(s);
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the empid: ");
		 int empid=sc.nextInt();
		 pstmt.setInt(1, empid);
			
		 int row=pstmt.executeUpdate();
		 if(row>0) {
			 System.out.println("Employee "+ empid +"was deleted successfully");
		 }
		 pstmt.close();
		 con.close();
	}	
}
