package com.Aniket.StudentModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserControl {	
	
	protected Student[] totalStudentList;
	private short totalStudents;		//max : (short)32,767 students
	//private Student std;
	Scanner input;
	
	public UserControl(){
		
		//this.std = new Student();
		this.input = new Scanner(System.in); 
		System.out.println("Enter total Students to be added to database : ");
		this.getTotalStudentsToAdd();
		System.out.println("students entered by this user : "+ this.totalStudents);
		System.out.println("\nEnter name and year for "+this.totalStudents+" students");
		this.setStudentNameYear();
	}
	
	public void getTotalStudentsToAdd() {
		try {
			this.totalStudents = input.nextShort();
		} catch (InputMismatchException inputEx) {	//To check whether input entered correctly or not
			System.out.println("ERROR : INPUT ENTERED INCORRECTLY...!!");
			System.exit(-1);
		}
	}
	
	public void setStudentNameYear() {	
		
		this.totalStudentList = new Student[this.totalStudents];
		
		for(int i=0; i<this.totalStudentList.length; i++) {	
			this.totalStudentList[i] = new Student();
			System.out.print("name : "+(i+1));
			try {
				this.totalStudentList[i].name = input.next();
				this.totalStudentList[i].year = input.nextShort();
			} catch (InputMismatchException inputEx) {
				System.out.println("ERROR : name or year entered incorrectly..!!");
				System.exit(-1);
			}
		}//for-end
		
		
		
		
		
	}

	


}
