package com.seeburger.students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student {

	private String firstName;
	private String lastName;
	private int fNum;
	private int course;

	@Override
	public String toString() {
		return firstName + ", " + lastName + ", " + fNum;
	}

	public Student() {
		System.out.println("from constructor");
	}

	public Student(String firstName, String lastName, int fNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fNum = fNum;
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

	public int getCourse() {
		return course;
	}

	public int getfNum() {
		return fNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
