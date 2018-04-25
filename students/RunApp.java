package com.seeburger.run;

import java.io.IOException;
import com.seeburger.students.Student;
import java.util.ArrayList;

public class RunApp {
	
	public static void main(String[] args) throws IOException {	
		ArrayList<Student> studentList = Student.readStudentData();
		Map<Long, Student> studentsMap = new HashMap<Long, Student>();
		for (Student st : studentList) {
			//System.out.println(st.toString());
			studentsMap.put(st.getfNum(), st);
		} 
		
	    // Getting a Set of Key-value pairs
	    Set entrySet = studentsMap.entrySet();
	 
	    // Obtaining an iterator for the entry set
	    Iterator it = entrySet.iterator();
	 
	    // Iterate through HashMap entries(Key-Value pairs)
	    System.out.println("HashMap Key-Value Pairs : ");
	    while(it.hasNext()){
	       Map.Entry me = (Map.Entry)it.next();
	       System.out.println("Key is: "+ me.getKey() + 
	       " & " + 
	       " value is: "+me.getValue());
	   }
		
		try {
	    	int[] arr = {2, 2, 2, 5};
		    Person person1 = new Student(481817, "Craig", "King", "cking7@cyberchimps.com", 19, 3, arr, "+35931088883");
		    System.out.println(person1.study(20));
		    System.out.println(((Student) person1).finalGrade(arr));
	    } catch(InvalidAgeException e) {
	    	e.printStackTrace();
	    } catch(InvalidGradeException ge) {
	    	ge.printStackTrace();
	    } catch(RepeatTheClassException re) {
	    	re.printStackTrace();
	    }
    }
}
