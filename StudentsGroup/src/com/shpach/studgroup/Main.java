package com.shpach.studgroup;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.shpach.studgroup.ClassGroup.ClassFullExeption;
import com.shpach.studgroup.ClassGroup.NullStudentExeption;
import com.shpach.studgroup.ClassGroup.StudentAllreadyExistExeption;
import com.shpach.studgroup.ClassGroup.StudentDoesNotExistExeption;
import com.shpach.studgroup.ClassGroup.WrongGradeExeption;

public class Main {

	public static void main(String[] args) {
		ClassGroup class1 = new ClassGroup("java OOP", Student.Grade.year_1);
		Student st1 = new Student("Ivanov Ivan", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st2 = new Student("Sidorov Ivan", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st3 = new Student("Astahov Ivan", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st4 = new Student("Penrenko Tanya", Human.Sex.femail, new GregorianCalendar(1992, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st5 = new Student("Zuev Ivan", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st6 = new Student("Almazov Ivan", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st7 = new Student("Opanasenko Ivan", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st8 = new Student("Astahova Valentina", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st9 = new Student("Bublickov Fedor", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st10 = new Student("Voronov Sergey", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st11 = new Student("Marchenko Dmitry", Human.Sex.mail, new GregorianCalendar(1990, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		
		addStudentToClass(class1, st1);
		addStudentToClass(class1, st2);
		addStudentToClass(class1, st3);
		addStudentToClass(class1, st4);
		addStudentToClass(class1, st5);
		addStudentToClass(class1, st6);
		addStudentToClass(class1, st7);
		addStudentToClass(class1, st8);
		addStudentToClass(class1, st9);
		addStudentToClass(class1, st10);
		
		System.out.println(class1);
		//add 11
		addStudentToClass(class1, st11);
		//add existing
		Student stExist=class1.getStudentByName("Astahov Ivan");
		addStudentToClass(class1, stExist);
		//add null
		addStudentToClass(class1, null);
		//remove
		try {
			class1.deleteStudent(stExist);
		} catch (StudentDoesNotExistExeption e) {
			System.out.println(e.getMessage());
		} catch (NullStudentExeption e) {
			System.out.println(e.getMessage());
		}
		//add wrong grade
		st11.setGrade(Student.Grade.year_2);
		addStudentToClass(class1, st11);
		st11.setGrade(Student.Grade.year_1);
		addStudentToClass(class1, st11);
		System.out.println(class1);
	}

	private static void addStudentToClass(ClassGroup classGroup, Student student) {
		if (classGroup != null) {
			try {
				classGroup.addStudent(student);
			} catch (ClassFullExeption e) {
				System.out.println(e.getMessage());
			} catch (NullStudentExeption e) {
				System.out.println(e.getMessage());
			} catch (StudentAllreadyExistExeption e) {
				System.out.println(e.getMessage());
			} catch (WrongGradeExeption e) {
				System.out.println(e.getMessage());
			}
		}

	}

}