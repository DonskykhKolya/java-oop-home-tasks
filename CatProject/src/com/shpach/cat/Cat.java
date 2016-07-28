package com.shpach.cat;

import java.util.Calendar;

public class Cat {
	public static enum sexType {
		mail, femail
	};

	private String nickname;
	private String breed;
	private sexType sex;
	private String color;
	private int yearOfBirth;
	private int age;
	private boolean neuter = false;
	private int hungry = 0; // in percents 0-100%
	private int happiness = 0;// in percents 0-100%

	public Cat(String nickname, String breed, sexType sex, String color, int yearOfBirth, boolean neuter) {
		super();
		this.nickname = nickname;
		this.breed = breed;
		this.sex = sex;
		this.color = color;
		setYearOfBirth(yearOfBirth);
		this.neuter = neuter;
	}
	public Cat() {
		super();
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int dateOfBirth) {
		this.yearOfBirth = dateOfBirth;
		setAge();
	}

	public boolean isNeuter() {
		return neuter;
	}

	public sexType getSex() {
		return sex;
	}

	public int getHungry() {
		return hungry;
	}

	public int getHappiness() {
		return happiness;
	}

	private void AddToHungry(int hungry) {
		this.hungry = AddPercents(this.hungry, hungry);
	}

	private void AddToHappiness(int happiness) {
		this.happiness = AddPercents(this.happiness, happiness);
	}

	private int AddPercents(int percents, int delta) {
		int res = percents + delta;
		if (res > 100) {
			res = 100;
		} else if (res < 0) {
			res = 0;
		}
		return res;
	}

	public int getAge() {
		return age;
	}

	private void setAge() {
		Calendar c = Calendar.getInstance();
		int currYear = c.get(Calendar.YEAR);
		int age = currYear-yearOfBirth;
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	public void makeNeuter() {
		this.neuter = true;
		AddToHappiness(-100);
	}

	public void feed() {
		AddToHappiness(10);
		AddToHungry(10);
	}

	public void play() {
		AddToHappiness(10);
		AddToHungry(-10);
	}

	public void punish() {
		AddToHappiness(-10);
	}

	public void takeCare() {
		AddToHappiness(10);
	}
	@Override
	public String toString() {
		return "Cat [nickname=" + nickname + ", breed=" + breed + ", sex=" + sex + ", color=" + color + ", yearOfBirth="
				+ yearOfBirth + ", age=" + age + ", neuter=" + neuter + ", hungry=" + hungry + ", happiness="
				+ happiness + "]";
	}
	

}
