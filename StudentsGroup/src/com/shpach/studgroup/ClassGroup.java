package com.shpach.studgroup;

import java.util.Arrays;

import com.shpach.studgroup.Student.Grade;

public class ClassGroup {
	private String className = "";
	private Student.Grade grade;
	private Student[] students = new Student[10];

	public ClassGroup(String className, Grade grade) {
		super();
		this.className = className;
		this.grade = grade;
	}

	public ClassGroup() {
		super();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Student.Grade getGrade() {
		return grade;
	}

	public static class ClassFullExeption extends Exception {

		@Override
		public String getMessage() {
			return "Class is full";
		}
	}

	public static class NullStudentExeption extends Exception {

		@Override
		public String getMessage() {
			return "Input param is null";
		}
	}

	public static class StudentAllreadyExistExeption extends Exception {

		@Override
		public String getMessage() {
			return "Student allready exist";
		}
	}

	public static class WrongGradeExeption extends Exception {

		@Override
		public String getMessage() {
			return "Wrong grade";
		}
	}

	public static class StudentDoesNotExistExeption extends Exception {

		@Override
		public String getMessage() {
			return "Student doesn't exist";
		}
	}

	public void addStudent(Student st)
			throws ClassFullExeption, NullStudentExeption, StudentAllreadyExistExeption, WrongGradeExeption {
		int freeIndx = -1;
		if (st == null)
			throw new NullStudentExeption();
		if (st.getGrade() != this.grade)
			throw new WrongGradeExeption();
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] == null) {
				freeIndx = i;
			} else {
				if (this.students[i].equals(st))
					throw new StudentAllreadyExistExeption();
			}
		}
		if (freeIndx != -1) {
			this.students[freeIndx] = st;
			st.setClassName(this.getClassName());
		} else {
			throw new ClassFullExeption();
		}

	}

	public void deleteStudent(Student st) throws StudentDoesNotExistExeption, NullStudentExeption {
		int freeIndx = -1;
		if (st == null)
			throw new NullStudentExeption();
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i].equals(st))
				freeIndx = i;
		}
		if (freeIndx != -1) {
			this.students[freeIndx] = null;
		} else {
			throw new StudentDoesNotExistExeption();
		}
	}

	public Student getStudentByName(String name) {
		for (Student student : students) {
			if (student != null) {
				if (student.getName() == name)
					return student;
			}
		}
		return null;
	}

	private String[] sortStudents() {
		String[] res = new String[10];
		int k = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null)
				res[k++] = students[i].toString();
		}
		String[] res1 = new String[k];
		System.arraycopy(res, 0, res1, 0, k);
		Arrays.sort(res1);
		return res1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ClassGroup" + System.lineSeparator() + "className=" + className + System.lineSeparator() + "grade="
				+ grade + System.lineSeparator());
		sb.append("Students list:" + System.lineSeparator());
		String[] st = sortStudents();
		
		for (int i=0;i<st.length;i++) {
			sb.append((i+1)+") ").append(st[i]).append(System.lineSeparator());
		}
		return sb.toString();
	}

}