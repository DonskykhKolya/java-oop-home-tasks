package com.shpach.studgroup;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student extends Human implements Serializable {
	
	private String className="";
	private String adress="";
	private Grade grade;
	public static enum Grade{year_1,year_2,year_3, year_4,year_5}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String surName,String name,  Sex sex, Calendar dateOfBirth, String adress, Grade grade) {
		super(surName,name, sex, dateOfBirth, 0, 0);
		this.adress = adress;
		this.grade = grade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getDateOfBirth().getTime());
		return "Student [surname=" + this.getSurName() + ", name=" + this.getName() + ", sex=" + this.getSex() + ", dateOfBirth=" + formatted
						+ ", age=" + this.getAge()+", className=" + className + ", adress=" + adress + ", grade=" + grade + "]";
	}
	
	
	
	

}
