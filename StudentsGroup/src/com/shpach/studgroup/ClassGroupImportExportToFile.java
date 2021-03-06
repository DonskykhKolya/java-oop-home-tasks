package com.shpach.studgroup;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.shpach.studgroup.ClassGroup.ClassFullExeption;
import com.shpach.studgroup.ClassGroup.NullStudentExeption;
import com.shpach.studgroup.ClassGroup.StudentAllreadyExistExeption;
import com.shpach.studgroup.ClassGroup.WrongGradeExeption;




public final class ClassGroupImportExportToFile implements DataImportExport {
	
	public ClassGroupImportExportToFile() {
		super();
	}
 
	@Override
	public void exportGroup(ClassGroup group) throws IOException {
		try (FileWriter fr = new FileWriter("group.txt")) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			StringBuilder sb = new StringBuilder();
			sb.append(group.getClassName()).append(";" + System.lineSeparator());
			sb.append(group.getGrade()).append(";" + System.lineSeparator());
			for (Student student : group.getStudents()) {
				sb.append(student.getSurName()).append(";");
				sb.append(student.getName()).append(";");
				sb.append(student.getSex()).append(";");
				sb.append(format1.format(student.getDateOfBirth().getTime())).append(";");
				sb.append(student.getAdress()).append(";");
				sb.append(student.getGrade()).append(";");
				sb.append(System.lineSeparator());
			}
			fr.write(sb.toString());
		}

	}
	@Override
	public ClassGroup importGroup() throws IOException, ParseException  {
		try (BufferedReader fr = new BufferedReader( new FileReader("group.txt"))) {
			StringBuilder sb = new StringBuilder();
			String name=(fr.readLine()).replaceAll(";", "");
			String grade=(fr.readLine()).replaceAll(";", "");
			Student.Grade gr;
			try{
			  gr= Student.Grade.valueOf(grade);
			}
			catch(Exception e){
				throw new ParseException(grade, 0);
			}
			ClassGroup group1=new ClassGroup(name, gr);
			String stud="";
			for(;(stud=fr.readLine())!=null;){
				sb.append(stud).append(System.lineSeparator());
			}
			String[] studArr=sb.toString().split(System.lineSeparator());
			for (String string : studArr) {
				String [] param=string.split(";");
				if (param.length==6){
					Calendar cal;
					Human.Sex sex;
					try {
						cal = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
						cal.setTime(sdf.parse(param[3]));
						
					} catch (ParseException e) {
						throw new ParseException(param[3], 0);
					}
					
					try {
						gr = Student.Grade.valueOf(param[5]);
						
					} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
						throw new ParseException(param[5], 0);
					}
					try {
						sex = Human.Sex.valueOf(param[2]);
						
					} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
						//JOptionPane.showMessageDialog(null, "wrong grade");
						throw new ParseException(param[2], 0);
					}
					
					Student st=new Student(param[0], param[1], sex, cal, param[4], gr);
					try {
						group1.addStudent(st);
					} catch (ClassFullExeption | NullStudentExeption | StudentAllreadyExistExeption
							| WrongGradeExeption e) {
						// TODO Auto-generated catch block
						throw new ParseException("Cant add student to Class", 0);
					}
				}
				else{
					throw new ParseException("Wrong cout of Students param", 0);
				}
			}
			return group1;
		}
		
	}

	
	

	

}
