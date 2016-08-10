package com.shpach.studgroup;

import java.io.IOException;
import java.text.ParseException;
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
		Student st1 = new Student("Ivanov", "Ivan", Human.Sex.mail, new GregorianCalendar(1991, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st2 = new Student("Sidorov", "Vitaly", Human.Sex.mail, new GregorianCalendar(1987, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st3 = new Student("Astahov", "Ivan", Human.Sex.mail, new GregorianCalendar(1992, Calendar.MAY, 30),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st4 = new Student("Penrenko", "Tanya", Human.Sex.femail, new GregorianCalendar(1997, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st5 = new Student("Zuev", "Ioan", Human.Sex.mail, new GregorianCalendar(1980, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st6 = new Student("Almazov", "Sergey", Human.Sex.mail, new GregorianCalendar(1981, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st7 = new Student("Opanasenko", "Oleksii", Human.Sex.mail,
				new GregorianCalendar(1999, Calendar.MAY, 22), "Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st8 = new Student("Astahova", "Valentina", Human.Sex.femail,
				new GregorianCalendar(1994, Calendar.MAY, 22), "Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st9 = new Student("Bublickov", "Fedor", Human.Sex.mail,
				new GregorianCalendar(1987, Calendar.JANUARY, 22), "Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st10 = new Student("Voronov", "Sergey", Human.Sex.mail, new GregorianCalendar(1988, Calendar.MAY, 22),
				"Kyiv, Lenin str,1", Student.Grade.year_1);
		Student st11 = new Student("Marchenko", "Dmitry", Human.Sex.mail, new GregorianCalendar(1994, Calendar.MAY, 22),
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

		// Interactive adding student
		/*
		 * try { class1.addInteractiveStudent(); } catch (ClassFullExeption e) {
		 * System.out.println(e.getMessage()); } catch (NullStudentExeption e) {
		 * System.out.println(e.getMessage()); } catch
		 * (StudentAllreadyExistExeption e) {
		 * System.out.println(e.getMessage()); } catch (WrongGradeExeption e) {
		 * System.out.println(e.getMessage()); }
		 */

		System.out.println(class1);
		// add 11
		addStudentToClass(class1, st11);
		// add existing
		Student stExist = class1.getStudentBySurName("Astahov");
		addStudentToClass(class1, stExist);
		// add null
		addStudentToClass(class1, null);
		// remove
		try {
			class1.deleteStudent(stExist);
		} catch (StudentDoesNotExistExeption e) {
			System.out.println(e.getMessage());
		} catch (NullStudentExeption e) {
			System.out.println(e.getMessage());
		}
		// add wrong grade
		st11.setGrade(Student.Grade.year_2);
		addStudentToClass(class1, st11);
		st11.setGrade(Student.Grade.year_1);
		addStudentToClass(class1, st11);

		// sort ClassGroup
		System.out.println(class1);
		System.out.println("sortBySurName by Comparable:" + System.lineSeparator());
		class1.sort();
		System.out.println(class1);
		System.out.println("sortBySurName:" + System.lineSeparator());
		class1.sortBySurName();
		System.out.println(class1);
		System.out.println("sortByName:" + System.lineSeparator());
		class1.sortByName();
		System.out.println(class1);
		System.out.println("sortByAge:" + System.lineSeparator());
		class1.sortByAge();
		System.out.println(class1);

		// VoenKom interface
		Student[] recruits = class1.getRecruts();
		StringBuilder sb = new StringBuilder();
		sb.append("Recruints: " + System.lineSeparator());
		for (int i = 0; i < recruits.length; i++) {
			sb.append((i + 1) + ") ").append(recruits[i]).append(System.lineSeparator());
		}
		System.out.println(sb.toString());

		// Export ClassGroup to file
		ClassGroupImportExportToFile importExport = new ClassGroupImportExportToFile();

		try {
			importExport.Export(class1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Deleting students
		try {
			class1.deleteStudent(st4);
			class1.deleteStudent(st1);
			class1.deleteStudent(st2);
		} catch (StudentDoesNotExistExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullStudentExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// import ClassGroup from File

		try {
			class1 = importExport.Import();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
