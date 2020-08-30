package com.java.api.component;

import org.springframework.stereotype.Component;

@Component("c1") //Bean id/name
public class Course {

	private int courseId;
	private String courseName;

	public Course() {
		System.out.println("In Course Constructor....");
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void compile() {
		System.out.println("In Course compile().....");
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}

}
