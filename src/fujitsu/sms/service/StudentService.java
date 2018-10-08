package fujitsu.sms.service;

import java.util.ArrayList;
import java.util.List;

import fujitsu.sms.model.Student;
import fujitsu.sms.dao.StudentDAO;

public class StudentService {

	public StudentService() {

	}

	public boolean add(Student student) {
		return StudentDAO.add(student);
	}

	public boolean update(Student student) {
		return StudentDAO.update(student);
	}

	public boolean delete(Student student) {
return StudentDAO.delete(student);
	}

	public List<Student> findAll() {
		return StudentDAO.findAll();
	}

	public Student findById(Student student) {
		return StudentDAO.findById(student);
	}

	public ArrayList<Student> findByDepartment(Student student) {
		return StudentDAO.findByDepartment(student);
	}

	public Student dataOperations(Student student) {
		return StudentDAO.dataOperations(student);
	}

}
