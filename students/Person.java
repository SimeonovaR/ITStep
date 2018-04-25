package com.seeburger.students;

import com.seeburger.exceptions.InvalidAgeException;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String phone;
	
	public Person() {}
	
	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	Person(String firstName, String lastName, int age, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		if (age > 0 && age < 100) {
			this.age = age;
		}
		else {
			this.age = 50;
		}
		this.email = email;
		if (phone.startsWith("+")) {
			this.phone = phone;
		} 
		else {
			this.phone = "Invalid phone number";
		}
	}
	
	void eat() {
		
	}
	
	void work() {
	
	}
	
	public int study(int age) throws InvalidAgeException {
		return age*3;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
