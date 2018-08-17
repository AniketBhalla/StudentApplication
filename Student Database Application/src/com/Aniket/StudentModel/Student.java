package com.Aniket.StudentModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	
	protected static short EACH_COURSE_COST;	//cost of each course to be enrolled in
	static {
		EACH_COURSE_COST = 600;		//initializing cost of each course 
	}
	
	protected String name;
	protected short year;
	protected int balance; 		//remained amount in bank after enrolling courses
	protected int tutionFees;
	protected ArrayList<String> enrolledCourses;
	protected Scanner input;
	//protected short studentID;

	public Student() {
		this.input = new Scanner(System.in);
		this.balance = 3000;
		System.out.println("Please select courses : ");
		this.enrolledCourses = new ArrayList<String>();
		this.selectCourses();
		this.getStudentDetails();
	}
	
	public void selectCourses() {
		
		System.out.println("\nEnter :");
		System.out.println("his -> HISTORY");
		System.out.println("math -> MATHEMATICS");		
		System.out.println("eng -> ENGLISH");
		System.out.println("ch -> CHEMISTRY");
		System.out.println("cs -> COMPUTER_SCIENCE");
		System.out.println("Please enter like a string, don't press 'ENTER' while selecting..!!");
		try {
			String subjects = input.nextLine();	//h m e c t
			if(subjects.contains("his")) {
				enrolledCourses.add("HISTORY");
			}if(subjects.contains("math")) {
				enrolledCourses.add("MATHEMATICS");
			}if(subjects.contains("eng")) {
				enrolledCourses.add("ENGLISH");
			}if(subjects.contains("ch")) {
				enrolledCourses.add("CHEMISTRY");
			}if(subjects.contains("cs")) {
				enrolledCourses.add("COMPUTER_SCIENCE");
			}
			this.tutionFees = (this.enrolledCourses.size())*Student.EACH_COURSE_COST;
			this.balance -= this.tutionFees;
		} catch (InputMismatchException inpEx) {
			System.out.println("[ERROR] : Subjects selected incorrectly..!!");
			System.exit(-1);
		}		
	}
	
	public int getSudentBalance() { return this.balance; }
	
	protected String getStudentDetails() { return "Name : "+this.name+", Balance : "+this.balance+this.enrolledCourses; }
}
