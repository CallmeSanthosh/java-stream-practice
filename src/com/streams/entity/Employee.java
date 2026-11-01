package com.streams.entity;

public class Employee {
	String name;
	String department;
	double salary;
	int age;
	String city;

	public Employee(String name, String department, double salary, int age, String city) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return name + " (" + department + ", $" + salary + ", age " + age + ", " + city + ")";
	}
}