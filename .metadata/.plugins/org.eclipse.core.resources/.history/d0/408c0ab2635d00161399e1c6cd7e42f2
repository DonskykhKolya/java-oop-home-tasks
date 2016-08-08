package com.shpach.studgroup;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Human {
	private String name;
	private Sex sex;
	private Calendar dateOfBirth = new GregorianCalendar();
	private double weigth;
	private double heigth;
	public static enum Sex {
		mail, femail
	}

	public Human(String name, Sex sex, Calendar dateOfBirth, double weigth, double heigth) {
		super();
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.weigth = weigth;
		this.heigth = heigth;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;

	}

	public void setDateOfBirth(int yy, int mm, int dd) throws IllegalArgumentException {

		this.dateOfBirth = new GregorianCalendar(yy, mm, dd);

	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public int getAge() {
		Calendar c = Calendar.getInstance();
		int currYear = c.get(Calendar.YEAR);
		int yearOfBirth = dateOfBirth.get(Calendar.YEAR);
		int age = currYear - yearOfBirth;
		if (age < 0) {
			return 0;
		} else {
			return age;
		}
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", age=" + this.getAge()
				+ ", weigth=" + weigth + ", heigth=" + heigth + "]";
	}

}
