

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "123456789");
			
			String s="select * from student where id=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			PrintWriter out=response.getWriter();
			if(res.next()) {
				id=res.getInt(1);
				String name=res.getString(2);
				int marks1=res.getInt(3);
				int marks2=res.getInt(4);
				int marks3=res.getInt(5);
				String result=res.getString(6);
				
				out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3+" "+result);
			}
			else {
				out.println("Invalid ID");
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
