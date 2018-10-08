package fujitsu.sms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fujitsu.sms.model.Student;
import fujitsu.sms.service.StudentService;

public class StudentController {
	static Scanner scanner = new Scanner(System.in);
	static StudentService service = new StudentService();

	static Student getStudent() {
		System.out.println("Enter student's roll number: ");
		int id = scanner.nextInt();
		System.out.println("Enter student's name: ");
		String name = scanner.next();
		System.out.println("Enter student's department: ");
		String department = scanner.next();
		System.out.println("Enter student's marks in subject 1: ");
		int marks1 = scanner.nextInt();
		System.out.println("Enter student's marks in subject 2: ");
		int marks2 = scanner.nextInt();
		System.out.println("Enter student's marks in subject 3: ");
		int marks3 = scanner.nextInt();
		Student student = new Student(id, name, department, marks1, marks2, marks3);
		return student;
	}


	public static boolean add(Student student) {
		return service.add(student);
	}

	public static boolean update(Student student) {
		return service.update(student);
	}

	public static boolean delete(Student student) {
		return service.delete(student);
	}

	public static List<Student> findAll() {
		return service.findAll();
	}

	public static Student findById(Student student) {
		return service.findById(student);
	}

	public static ArrayList<Student> findByDepartment(Student student) {
		return service.findByDepartment(student);
	}


	public static Student dataOperations(Student student) {
		return service.dataOperations(student);
	}
}