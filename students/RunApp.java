package com.seeburger.run;

import java.io.IOException;
import com.seeburger.students.Student;
import java.util.ArrayList;

public class RunApp {
	
	public static void main(String[] args) throws IOException {	
		ArrayList<Student> studentList = Student.readStudentInfo();
		
		for (Student st : studentList) {
			System.out.println(st.toString());
		} 
	}
}
