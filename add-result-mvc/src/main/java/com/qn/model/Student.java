package com.qn.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Student {
private int id;
private String name;
private int marks1;
private int marks2;
private int marks3;
private String result;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks1() {
	return marks1;
}
public void setMarks1(int marks1) {
	this.marks1 = marks1;
}
public int getMarks2() {
	return marks2;
}
public void setMarks2(int marks2) {
	this.marks2 = marks2;
}
public int getMarks3() {
	return marks3;
}
public void setMarks3(int marks3) {
	this.marks3 = marks3;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public Student(int id, String name, int marks1, int marks2, int marks3, String result) {
	super();
	this.id = id;
	this.name = name;
	this.marks1 = marks1;
	this.marks2 = marks2;
	this.marks3 = marks3;
	this.result = result;
}
public Student() {
	super();
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", marks1=" + marks1 + ", marks2=" + marks2 + ", marks3=" + marks3
			+ ", result=" + result + "]";
}
public int addResult() {
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
		return row;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return 0;
	
}
}
