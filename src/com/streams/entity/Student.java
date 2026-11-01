package com.streams.entity;

import java.util.List;

public class Student {
	String name;
	int grade;
	List<String> subjects;
	List<Integer> scores;

	public Student(String name, int grade, List<String> subjects, List<Integer> scores) {
		this.name = name;
		this.grade = grade;
		this.subjects = subjects;
		this.scores = scores;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	@Override
	public String toString() {
		return name + " (Grade " + grade + ")";
	}
}