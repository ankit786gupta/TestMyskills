package com.employeedata.pojo;

public class EmpDatabaseQuery {
	static final String url = "jdbc:mysql://localhost:3306/user";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "root";
	static final String password = "root123";
	static final String savedata = "insert into registrationform (name,email,company,salary,designation,id) values (?,?,?,?,?,?)";
	static final String updatedata = "update registrationform set name = ?,email = ?,company = ?,salary = ?,designation = ? where id = ?";
	static final String deletedata = "delete from registrationform where id = ?";
	static final String alldata = "select * from registrationform";
	static final String editdata = "select * from registrationform where id = ?";
}