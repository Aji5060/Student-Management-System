package fujitsu.sms.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fujitsu.sms.controller.StudentController;
import fujitsu.sms.exception.InvalidInputException;
import fujitsu.sms.model.Student;

public class TestSMSApp {
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Student> studentList;

	public static void main(String[] args) throws Exception {
		int choice = 0;
		int id = 0;
		String name;
		String department;
		int marks1;
		int marks2;
		int marks3;
		boolean flag = false;
		try {
			System.out.println("username: ");
			String userName = scanner.next();
			System.out.println("password: ");
			String password = scanner.next();
			while (true) {
				if (userName.equals("ajinkya") && password.equals("ajinkya")) {
					while (true) {
						System.out.println("\n1. Add student's record ");
						System.out.println("2. Display all the students in database ");
						System.out.println("3. Search by student's id");
						System.out.println("4. Search by student's department");
						System.out.println("5. Update student's name");
						System.out.println("6. Remove student's record");
						System.out.println("7. Display students's marksheet");
						System.out.println("8. Logout\n");
						System.out.println("Enter your choice: ");
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Enter id: ");
							id = scanner.nextInt();
							System.out.println("Enter name: ");
							name = scanner.next();
							System.out.println("Enter department: ");
							department = scanner.next();
							System.out.println("Enter marks of first subject: ");
							marks1 = scanner.nextInt();
							if (marks1 < 0 || marks1 > 100) {
								throw new InvalidInputException("Invalid value for marks");
							}
							System.out.println("Enter marks of second subject: ");
							marks2 = scanner.nextInt();
							if (marks2 < 0 || marks2 > 100) {
								throw new InvalidInputException("Invalid value for marks");
							}
							System.out.println("Enter marks of third subject: ");
							marks3 = scanner.nextInt();
							if (marks3 < 0 || marks3 > 100) {
								throw new InvalidInputException("Invalid value for marks");
							}
							Student studentobject1 = new Student(id, name, department, marks1, marks2, marks3);
							StudentController.add(studentobject1);
							break;
						case 2:
							System.out.println("Database:\n");
							List<Student> students = StudentController.findAll();
							for (Student student : students) {
								System.out.println(student);
							}
							break;
						case 3:
							System.out.println("Enter id: ");
							id = scanner.nextInt();
							Student studentObject2 = new Student();
							studentObject2.setId(id);
							if (StudentController.findById(studentObject2) == null) {
								System.out.println("Student not found in the database.");
								break;
							} else {
								System.out.println(StudentController.findById(studentObject2));
							}

							break;
						case 4:
							System.out.println("Enter department name: ");
							department = scanner.next();
							studentList = new ArrayList<>();
							Student studentObject3 = new Student();
							studentObject3.setDepartment(department);
							studentList = StudentController.findByDepartment(studentObject3);
							if (studentList.isEmpty()) {

								System.out.println("No students found in the database matching department name as '"
										+ department + "'");
								break;
							} else {
								for (Student student : studentList) {
									System.out.println(student);
								}
							}

							break;

						case 5:
							flag = false;
							System.out.println("Enter Student's id: ");
							id = scanner.nextInt();
							System.out.println("Enter new name: ");
							name = scanner.next();
							Student studentObject4 = new Student();
							studentObject4.setId(id);
							studentObject4.setName(name);
							flag = StudentController.update(studentObject4);
							if (flag == false) {
								System.out.println("Student not found in the database.");
							} else {
								System.out.println("Update Successful.");
							}
							break;

						case 6:
							System.out.println("Enter Student's id: ");
							id = scanner.nextInt();
							Student studentObject5 = new Student();
							studentObject5.setId(id);
							flag = StudentController.delete(studentObject5);
							if (flag == false) {
								System.out.println("Student not found in the database.");
							} else {
								System.out.println("Entry deleted successful.");
							}
							break;
						case 7:
							System.out.println("Enter student id to display marksheet: ");
							id = scanner.nextInt();
							Student studentObject6 = new Student();
							studentObject6.setId(id);
							Student studentResult;
							studentResult = StudentController.dataOperations(studentObject6);
							System.out.print("\n\nMarksheet\n\nStudent's Name: " + studentResult.getName()
									+ "\nStudent's ID: " + studentResult.getId() + "\nMarks 1: "
									+ studentResult.getMarks1() + "\nMarks 2: " + studentResult.getMarks2()
									+ "\nMarks3: " + studentResult.getMarks3() + "\nTotal marks obtained: "
									+ studentResult.getTotal() + " out of 300" + "\nPercentage: "
									+ studentResult.getPercentage() + "\nResult: " + studentResult.getResult() + "\n");
							break;
						case 8:
							System.out.println("Bye");
							System.exit(0);
						}
					}
				} else {
					System.out.println("Invalid login.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
