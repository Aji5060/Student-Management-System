package fujitsu.sms.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fujitsu.sms.model.Student;
import fujitsu.sms.util.ConnectionUtil;

public class StudentDAO {
	public static ArrayList<Student> studentList;

	public StudentDAO() {

	}

	public static List<Student> findAll() {
		Connection connection = ConnectionUtil.getConnection();
		ArrayList<Student> students = new ArrayList<>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM Students");
			while (resultset.next()) {
				Student student = new Student();
				student.setId(resultset.getInt("id"));
				student.setName(resultset.getString("name"));
				student.setDepartment(resultset.getString("department"));
				student.setMarks1(resultset.getInt("marks1"));
				student.setMarks2(resultset.getInt("marks2"));
				student.setMarks3(resultset.getInt("marks3"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return students;
	}

	public static Student findById(Student student) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Student studentobj = new Student();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE id=?");
			preparedStatement.setInt(1, student.getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				studentobj.setId(resultSet.getInt("id"));
				studentobj.setName(resultSet.getString("name"));
				studentobj.setDepartment(resultSet.getString("department"));
				studentobj.setMarks1(resultSet.getInt("marks1"));
				studentobj.setMarks2(resultSet.getInt("marks2"));
				studentobj.setMarks3(resultSet.getInt("marks3"));
			} else {
				studentobj = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentobj;
	}

	public static ArrayList<Student> findByDepartment(Student student) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		studentList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE department=?");
			preparedStatement.setString(1, student.getDepartment());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Student studentobj = new Student();
					studentobj.setId(resultSet.getInt("id"));
					studentobj.setName(resultSet.getString("name"));
					studentobj.setDepartment(resultSet.getString("department"));
					studentobj.setMarks1(resultSet.getInt("marks1"));
					studentobj.setMarks2(resultSet.getInt("marks2"));
					studentobj.setMarks3(resultSet.getInt("marks3"));
					studentList.add(studentobj);

				}
			} else {
				studentList = null;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return studentList;
	}

	public static boolean add(Student student) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		boolean flag = false;
		int resultSet;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO Students VALUES(?,?,?,?,?,?)");
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getDepartment());
			preparedStatement.setInt(4, student.getMarks1());
			preparedStatement.setInt(5, student.getMarks2());
			preparedStatement.setInt(6, student.getMarks3());
			resultSet = preparedStatement.executeUpdate();
			if (resultSet != 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean update(Student student) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		int resultSet;
		boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement("UPDATE Students set name=? WHERE id=?");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getId());
			resultSet = preparedStatement.executeUpdate();
			if (resultSet == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean delete(Student student) {
		boolean flag = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		int resultSet;
		try {
			preparedStatement = connection.prepareStatement("delete from Students where id=?");
			preparedStatement.setInt(1,student.getId());
			resultSet = preparedStatement.executeUpdate();
			if (resultSet == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Student dataOperations(Student student) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Student studentobject = new Student();
		int total=0;
		float percentage=0.00f;
		String result = "";
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE id=?");
			preparedStatement.setInt(1, student.getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				studentobject.setId(resultSet.getInt("id"));
				studentobject.setName(resultSet.getString("name"));
				studentobject.setDepartment(resultSet.getString("department"));
				studentobject.setMarks1(resultSet.getInt("marks1"));
				studentobject.setMarks2(resultSet.getInt("marks2"));
				studentobject.setMarks3(resultSet.getInt("marks3"));
				total = studentobject.getMarks1()+studentobject.getMarks2()+studentobject.getMarks3();
				studentobject.setTotal(total);
				percentage = (float) ((studentobject.getTotal() )/ 300)*100;
				studentobject.setPercentage(percentage);
				if (studentobject.getPercentage() >= 35) {
					result = "PASS";
				} else {
					result = "FAIL";
				}
				studentobject.setResult(result);				
			} 
			else {
				studentobject = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentobject;
	}

}