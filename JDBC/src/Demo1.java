import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Demo1 {
 public static void main(String args[]) throws Exception {
	 
	 //loading the driver
	 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	 System.out.println("Driver loaded successfully");
	 
	 //establishing the connection
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "123456789");
	 System.out.println("Connection established");
	 
	 con.setAutoCommit(false);
	 
	 String s="Select * from student";
	 Statement stmt=con.createStatement();
	 ResultSet res=stmt.executeQuery(s);
	 
	 //if we dont kown the datatype of the columns 
	 
	 	ResultSetMetaData rsmd=res.getMetaData();	
	 	for(int i=1;i<=
	 			rsmd.getColumnCount();i++) {
	 		
	 		System.out.println(rsmd.getColumnName(i));
		    System.out.println(rsmd.getColumnTypeName(i));
	 	}
	 	System.out.println("");
	 
	 while(res.next()==true) {
		 int id=res.getInt(1);
		 String name=res.getString(2);
		 int marks1=res.getInt(3);
		 int marks2=res.getInt(4);
		 int marks3=res.getInt(5);
		 String result=res.getString(6);
		 
		 System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3+" "+result);
	 }
	con.commit(); 
 }
}
