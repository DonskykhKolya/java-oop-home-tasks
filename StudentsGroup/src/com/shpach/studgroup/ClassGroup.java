package com.shpach.studgroup;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.shpach.studgroup.Student.Grade;

public class ClassGroup implements VoenKom, Serializable{
	private String className = "";
	private Student.Grade grade;
	private Student[] students = new Student[0];
	private static int maxStudents = 10;
	

	public ClassGroup(String className, Grade grade) {
		super();
		this.className = className;
		this.grade = grade;
	}

	public ClassGroup() {
		super();
	}

	public Student[] getStudents() {
		return students;
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
			// if (this.students[i] == null) {
			// freeIndx = i;
			// } else {
			if (this.students[i].equals(st))
				throw new StudentAllreadyExistExeption();
			// }
		}
		// if (freeIndx != -1) {
		if (this.students.length < ClassGroup.maxStudents) {
			this.addStudentToArray(st);
			st.setClassName(this.getClassName());
		} else

		{
			throw new ClassFullExeption();
		}

	}

	private void addStudentToArray(Student st) {
		Student[] stud = new Student[students.length + 1];
		System.arraycopy(students, 0, stud, 0, students.length);
		stud[students.length] = st;
		students = stud;
	}

	public void deleteStudent(Student st) throws StudentDoesNotExistExeption, NullStudentExeption {
		int freeIndx = -1;
		if (st == null)
			throw new NullStudentExeption();
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null) {
				if (this.students[i].equals(st))
					freeIndx = i;
			}
		}
		if (freeIndx != -1) {
			this.students[freeIndx] = null;
			Student[] stud = new Student[students.length - 1];
			System.arraycopy(students, 0, stud, 0, freeIndx);
			System.arraycopy(students, freeIndx + 1, stud, freeIndx, students.length - freeIndx - 1);
			students = stud;

		} else {
			throw new StudentDoesNotExistExeption();
		}
	}

	public Student getStudentBySurName(String name) {
		for (Student student : students) {
			if (student != null) {
				if (student.getSurName() == name)
					return student;
			}
		}
		return null;
	}

	private static Comparator<Student> nameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student e1, Student e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};
	private static Comparator<Student> ageComparator = new Comparator<Student>() {

		@Override
		public int compare(Student e1, Student e2) {
			return e1.getAge() - e2.getAge();
		}
	};
	private static Comparator<Student> surNameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student e1, Student e2) {
			return e1.getSurName().compareTo(e2.getSurName());
		}
	};

	public void sortByName() {
		Arrays.sort(this.students, ClassGroup.nameComparator);
	}

	public void sortBySurName() {
		Arrays.sort(this.students, ClassGroup.surNameComparator);
	}

	public void sortByAge() {
		Arrays.sort(this.students, ClassGroup.ageComparator);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ClassGroup" + System.lineSeparator() + "className=" + className + System.lineSeparator() + "grade="
				+ grade + System.lineSeparator());
		sb.append("Students list:" + System.lineSeparator());
		for (int i = 0; i < this.students.length; i++) {
			sb.append((i + 1) + ") ").append(this.students[i]).append(System.lineSeparator());
		}
		return sb.toString();
	}

	public void sort() {
		Arrays.sort(students);

	}

	@Override
	public Student[] getRecruts() {
		int[] indx = new int[students.length];
		int j = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getAge() > 18 && students[i].getSex() == Human.Sex.mail) {
					indx[j++] = i + 1;
				}
			}
		}
		Student[] res = new Student[j];
		for (int i = 0; i < j; i++) {
			res[i] = students[indx[i] - 1];

		}
		return res;
	}

	public void addInteractiveStudent()
			throws ClassFullExeption, NullStudentExeption, StudentAllreadyExistExeption, WrongGradeExeption {
		String name;
		String surName;
		Human.Sex sex;
		Calendar cal;
		String addr;
		Student.Grade grade;

		for (;;) {
			try {
				surName = JOptionPane.showInputDialog("Input surname:");
				// TODO: make testings on non letters symbols
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "wrong surname");
			}
		}
		for (;;) {
			try {
				name = JOptionPane.showInputDialog("Input name:");
				// TODO: make testings on non letters symbols
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "wrong name");
			}
		}
		for (;;) {
			try {
				sex = Human.Sex.values()[Integer
						.valueOf(JOptionPane.showInputDialog("Input sex (0)-mail (1) -femail:"))];
				break;
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "wrong sex value");
			}
		}
		for (;;) {
			try {
				cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
				cal.setTime(sdf.parse(JOptionPane.showInputDialog("Input date of birth (yyyy-MM-dd):")));
				break;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "wrong date format");
			}
		}
		for (;;) {
			try {
				addr = JOptionPane.showInputDialog("Input adress:");
				// TODO: make testings on non adress symbols
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "wrong adress");
			}
		}
		for (;;) {
			try {
				grade = Student.Grade
						.values()[Integer.valueOf(JOptionPane.showInputDialog("Input grade (from 1 to 5):")) - 1];
				break;
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "wrong grade");
			}
		}

		this.addStudent(new Student(surName, name, sex, cal, addr, grade));

	}

}
