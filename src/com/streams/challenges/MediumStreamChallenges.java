package com.streams.challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.streams.entity.Employee;
import com.streams.entity.Order;
import com.streams.entity.Student;

public class MediumStreamChallenges {

	List<Employee> employees = Arrays.asList(new Employee("Alice", "Engineering", 95000, 30, "New York"),
			new Employee("Bob", "Marketing", 62000, 28, "Chicago"),
			new Employee("Charlie", "Engineering", 110000, 35, "San Francisco"),
			new Employee("David", "HR", 58000, 42, "New York"), new Employee("Eve", "Marketing", 71000, 26, "Chicago"),
			new Employee("Frank", "Engineering", 88000, 29, "Austin"),
			new Employee("Grace", "HR", 65000, 38, "San Francisco"),
			new Employee("Hank", "Sales", 73000, 33, "New York"), new Employee("Ivy", "Sales", 69000, 27, "Austin"),
			new Employee("Jack", "Engineering", 120000, 40, "San Francisco"));

	List<Student> students = Arrays.asList(
			new Student("Alice", 10, Arrays.asList("Math", "Science", "English"), Arrays.asList(90, 85, 88)),
			new Student("Bob", 11, Arrays.asList("Math", "History"), Arrays.asList(72, 68)),
			new Student("Charlie", 10, Arrays.asList("Science", "English", "Art"), Arrays.asList(95, 91, 78)),
			new Student("David", 12, Arrays.asList("Math", "Science", "History", "English"),
					Arrays.asList(60, 65, 70, 72)),
			new Student("Eve", 11, Arrays.asList("Art", "English"), Arrays.asList(88, 92)),
			new Student("Frank", 10, Arrays.asList("Math", "Science"), Arrays.asList(55, 62)),
			new Student("Grace", 12, Arrays.asList("History", "English", "Art"), Arrays.asList(80, 85, 90)));

	List<Order> orders = Arrays.asList(
			new Order("ORD001", "Alice", Arrays.asList("Laptop", "Mouse"), 1200.00, "DELIVERED"),
			new Order("ORD002", "Bob", Arrays.asList("Keyboard"), 75.50, "PENDING"),
			new Order("ORD003", "Alice", Arrays.asList("Monitor", "Webcam", "Headphones"), 450.00, "DELIVERED"),
			new Order("ORD004", "Charlie", Arrays.asList("Tablet", "Stylus"), 680.00, "CANCELLED"),
			new Order("ORD005", "Bob", Arrays.asList("Mouse", "Mousepad"), 45.00, "DELIVERED"),
			new Order("ORD006", "David", Arrays.asList("Laptop", "Laptop Bag"), 1350.00, "PENDING"),
			new Order("ORD007", "Eve", Arrays.asList("Headphones"), 199.99, "DELIVERED"),
			new Order("ORD008", "Charlie", Arrays.asList("Monitor"), 320.00, "DELIVERED"),
			new Order("ORD009", "Alice", Arrays.asList("Keyboard", "Mouse"), 110.00, "CANCELLED"),
			new Order("ORD010", "Frank", Arrays.asList("Webcam", "Microphone"), 185.00, "PENDING"));

	protected void runEmployeeChallenges() {

		System.out.println(
				"From the Employee,  Group all employees by their department. The result should be a map where the key is the department name and the value is the list of employees in that department.");
		Map<String, List<Employee>> employeesGroupByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(employeesGroupByDept);
		System.out.println();

		System.out.println(
				"From the Employee,  Find the average salary for each department. The result should be a map of department name to average salary.");
		Map<String, Double> avgSalaryOfEachDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryOfEachDept);
		System.out.println();

		System.out.println(
				"From the Employee,   Find the highest-paid employee in each department. The result should be a map of department name to the employee.");
		Map<String, Optional<Employee>> highestSalaryOfEachDept = employees.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println(highestSalaryOfEachDept);
		System.out.println();

		System.out.println("From the Employee,   Count the number of employees in each city.");
		Map<String, Long> employeeCountinEachCity = employees.stream()
				.collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
		System.out.println(employeeCountinEachCity);
		System.out.println();

		System.out.println(
				"From the Employee,    Partition employees into two groups: those earning above 70000 and those earning 70000 or below.");
		Map<Boolean, List<Employee>> partitionByEarnings = employees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getSalary() > 70000));
		System.out.println(partitionByEarnings);
		System.out.println();

		System.out.println(
				"From the Employee,     Get a comma-separated string of all employee names who work in the \"Engineering\" department, sorted alphabetically.");
		String employeeNamesInEnggAndSort = employees.stream()
				.filter(emp -> emp.getDepartment().equalsIgnoreCase("engineering")).map(Employee::getName).sorted()
				.collect(Collectors.joining(", "));
		System.out.println(employeeNamesInEnggAndSort);
		System.out.println();

		System.out.println("From the Employee,     Find the department with the highest total salary payout.");
		Optional<String> highestPayoutDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
				.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
		System.out.println(highestPayoutDept.orElse("None"));
		System.out.println();

		System.out.println(
				"From the Employee,     Get a map of employee name to their salary, but only for employees older than 30.");
		Map<String, Double> empNameToSalary = employees.stream().filter(emp -> emp.getAge() > 30)
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));
		System.out.println(empNameToSalary);
		System.out.println();

	}

	protected void runStudentChallenges() {
		System.out.println(
				"From the Student,     Get a list of all unique subjects across all students, sorted alphabetically.");
		List<String> uniqueSubjectsAndSorted = students.stream().flatMap(student -> student.getSubjects().stream())
				.distinct().sorted().toList();
		uniqueSubjectsAndSorted.forEach(System.out::println);
		System.out.println();

		System.out.println("From the Student,     Find the student with the highest single score across all students.");
		Optional<Student> highestScoreStudent = students.stream()
				.max(Comparator.comparingInt(student -> Collections.max(student.getScores())));
		highestScoreStudent
				.ifPresent(s -> System.out.println(s.getName() + " with score " + Collections.max(s.getScores())));
		System.out.println();
	}

}
