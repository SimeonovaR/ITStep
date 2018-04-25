package com.seeburger.students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.seeburger.exceptions.InvalidAgeException;
import com.seeburger.exceptions.InvalidGradeException;
import com.seeburger.exceptions.RepeatTheClassException;

public class Student extends Person{

	private long fNum;
	private int course;
	private int group;
	private int[] grades;
	

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, long fNum) {
		super(firstName, lastName);
		this.fNum = fNum;
	}
	
	public Student(long fNum, String firstName, String lastName, String email, int age, int group, int[] grades, String phone) {
		super(firstName, lastName, age, email, phone);
		this.fNum = fNum;		
		this.group = group;	
		this.grades = grades;
		
	}
	
	
	
	@Override
	public String toString() {
		return fNum + ", " + super.getFirstName() + ", " + super.getLastName() + ", " + super.getEmail() + ", " + super.getAge() + ", " + group + ", " + grades[0] + ", " + grades[1] + ", " + grades[2] + ", " + grades[3] + ", " + super.getPhone();
	}

	public static ArrayList<Student> readStudentInfo() throws IOException {
		File file = new File("C:\\Users\\MKA\\Desktop\\properties.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		ArrayList<Student> studentList = new ArrayList<>();
		String line;
		while ((line = reader.readLine()) != null) {
			String[] studentRec = line.split(", ");
			String firstName = studentRec[0];
			String lastName = studentRec[1];
			String fNum = studentRec[2];
			int num = Integer.parseInt(fNum);
			Student student = new Student(firstName, lastName, num);
			studentList.add(student);
		}
		reader.close();
		return studentList;
	}

	public static ArrayList<Student> readStudentData() throws IOException {
		File file = new File("C:\\Users\\MKA\\Desktop\\StudentData.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		ArrayList<Student> studentList = new ArrayList<>();
		reader.readLine(); //reads the first line 
		String line;
		while ((line = reader.readLine()) != null) { //will start from second line
			String[] studentRec = line.split("\\s+");
			
			String fNum = studentRec[0];
			String firstName = studentRec[1];
			String lastName = studentRec[2];
			String email = studentRec[3];
			String age = studentRec[4];
			String group = studentRec[5];
			String grade1 = studentRec[6];
			String grade2 = studentRec[7];
			String grade3 = studentRec[8];
			String grade4 = studentRec[9];
			String phone = studentRec[10];

			long num = Long.parseLong(fNum);
			int stAge = Integer.parseInt(age);
			int stGroup = Integer.parseInt(group);
			int gr1 = Integer.parseInt(grade1);
			int gr2 = Integer.parseInt(grade2);
			int gr3 = Integer.parseInt(grade3);
			int gr4 = Integer.parseInt(grade4);
			int[] gradeList = {gr1, gr2, gr3, gr4};
			Student student = new Student(num, firstName, lastName, email, stAge, stGroup, gradeList, phone);
			studentList.add(student);
		}
		reader.close();
		return studentList;
	}
	
	public int study(int age) throws InvalidAgeException {
		if (age < 18) 
			throw new InvalidAgeException("You are too young to participate in university");
		else {
			System.out.println("You can participate in university. You will graduate at the age of ");
			age += 5;
			return age;
		}
	}
	
	public int finalGrade(int[] grades) throws InvalidGradeException, RepeatTheClassException {
		boolean isValid = true;
		int sum = 0;
		int poorMarks = 0;
		for (int i = 0; i < grades.length && isValid; i++) {
			sum += grades[i];
			if(grades[i] == 2) {
				poorMarks++;
			}
			if (grades[i] < 2 || grades[i] > 6) {
				isValid = false;
			}
		}
		if (poorMarks > 2) {
			throw new RepeatTheClassException("You can not graduate because you have many poor marks.");
		}
		else {
			if (isValid) {
				return sum/grades.length;
			}
			else {
				throw new InvalidGradeException("There is invalid grade input. Please enter grades between 1 and 6");
			}
		}
		
	}
	
	public int getCourse() {
		return course;
	}

	public long getfNum() {
		return fNum;
	}
}
