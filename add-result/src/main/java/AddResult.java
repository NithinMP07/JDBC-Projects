import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int marks1 = Integer.parseInt(request.getParameter("marks1"));
		int marks2 = Integer.parseInt(request.getParameter("marks2"));
		int marks3 = Integer.parseInt(request.getParameter("marks3"));
		String result = request.getParameter("result");

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "123456789");
			String s = "insert into student values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			pstmt.setString(6, result);
			int row = pstmt.executeUpdate();
			PrintWriter out = response.getWriter();
			if (row == 0) {
				out.println("Student data not added");
			} else {
				out.println("Student data added successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
