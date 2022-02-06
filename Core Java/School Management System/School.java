package School.Management.System;


import java.util.List;

public class School {
private List<Teacher> teachers;
private List<Student> students;
private  static int   totalMoneyEarned;
private  static  int totalMoneySpent;
public School(List<Teacher> teachers, List<Student> students) {
	this.teachers = teachers;
	this.students = students;
	totalMoneySpent=0;
	totalMoneyEarned=0; 
	
}
/*
 * @return the list of teacher in the school
 */
public List<Teacher> getTeachers() {
	return teachers;
}
/*
 * @adding a teacher to the  school
 */
public void addTeachers(Teacher teacher) {
	teachers.add(teacher);
}
/*
 * @list of students in school
 */
public List<Student> getStudents() {
	return students;
}
/*
 * @adding a student to the  school
 */
public void addStudents(Student student) {
	students.add(student);
}
/*
 * @return the total money earned by the school
 */
public int getTotalMoneyEarned() {
	return totalMoneyEarned;
}
/*
 * Adds the total money earned by the school
 * MoneyEarned money that is supposed to be added
 */
public static void upadteTotalMoneyEarned(int MoneyEarned) {
	totalMoneyEarned+=MoneyEarned;
}
/*
 * @return the total money spent by the school
 */
public int getTotalMoneySpent() {
	return totalMoneySpent;
}
/*
 * update the money that is spent by the school which
 * is the salary given by school to its teachers
 * moneySpent the money spent by school
 */
public  static void updateTotalMoneySpent(int MoneySpent) {
	totalMoneyEarned-=totalMoneySpent;
}


}

