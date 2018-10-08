package fujitsu.sms.model;

public class Student {

	private int id;
	private String name;
	private String department;
	private int marks1;
	private int marks2;
	private int marks3;
	private int total;
	private String result;
	private float percentage;

	public Student() {
	}

	public Student(int id, String name, String department, int marks1, int marks2, int marks3) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public void setTotal(int total) {
		this.total = total;

	}

	public float getTotal() {
		return total;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;

	}

	public float getPercentage() {
		return percentage;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", marks1=" + marks1
				+ ", marks2=" + marks2 + ", marks3=" + marks3 + "]";
	}

}