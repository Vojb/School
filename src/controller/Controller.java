package controller;

import java.util.ArrayList;

import model.Course;
import model.Student;
import model.Studied;
import model.Studying;
import dal.CourseAccess;
import dal.StudentAccess;

public class Controller {

	//Course
	public static boolean createCourse(String cName, String cCode, int cPoints) {
		return CourseAccess.createCourse(cName, cCode, cPoints);
	}
	public static ArrayList<Course> getAllCourses() {
		return CourseAccess.getAllCourses();
	}
	public static void deleteCourse(String cCode){
		CourseAccess.deleteCourse(cCode);
	}
	public static Course getCourse(String cCode){
		return CourseAccess.getCourse(cCode);
	}
	public static int getStudentsCoursesPoints(String sPnr,String semester){
		return StudentAccess.getStudentsCoursesPoints(sPnr,semester);
	}
	public static String getPrecentageinCourse(String cCode){
		return CourseAccess.getPrecentageinCourse(cCode);
	}
	//Student
	public static boolean createStudent(String sName, String Address, String sPnr) {
		return StudentAccess.createStudent(sName, Address, sPnr);
	}
	
	public static ArrayList<Student> getAllStudents() {
		return StudentAccess.getAllStudents();
	}
	public static Student getStudent(String sPnr) {
		return StudentAccess.getStudent(sPnr);
	}
	public static Studying getStudyingStudent(String sPnr,String cCode){
		return StudentAccess.getStudyingStudent(sPnr, cCode);
	}
	
	public static void deleteStudent(String sPnr){
		StudentAccess.deleteStudent(sPnr);
	}
	public static Studied getStudentStudied(String sPnr, String cCode) {
		return StudentAccess.getStudentStudied(sPnr, cCode);
	}
	
	// Studying Student
	public static boolean createStudyingStudent(String cCode, String sPnr,String semester) {
	return StudentAccess.createStudyingStudent(cCode, sPnr, semester);
	
	}
	public static ArrayList<Studying> getAllStudyingStudents() {
		return StudentAccess.getAllStudyingStudents();
	}
	public static void deleteStudyingStudent(String cCode, String sPnr){
		StudentAccess.deleteStudyingStudent(cCode, sPnr);
		
	}
	
	//Studied Students 
	
	public static void createStudiedStudent(String grade,
				String cCode,String sPnr,String semester) {
		StudentAccess.createStudiedStudent(grade, cCode, sPnr, semester);
	}
	public static ArrayList<Studied> getAllStudentsStudied() {
		return StudentAccess.getAllStudentsStudied();
	}
	public static ArrayList<Studied> showAvgflow(){
		return StudentAccess.getAvgFlow();
	}
	
	//Finishing Student
	
	public static void finishingStudent(String cCode, String sPnr, String semester,String grade){
	deleteStudyingStudent(cCode, sPnr);
	createStudiedStudent(grade, cCode, sPnr, semester);
		
	}
	public static ArrayList<Studied> showGradeCourse(String cCode) {
		
		return CourseAccess.showGradeCourse(cCode);
	}
	public static boolean getStudentStudiedAlready(String sPnr, String cCode) {
		return StudentAccess.getStudentStudiedAlready(sPnr, cCode);
	}
public static ArrayList<Studying> showStudyingCourses(String cCode) {
		
		return CourseAccess.showStudyingCourses(cCode);
	}
	
	public static int getTime(){
		long startTime = System.currentTimeMillis();
		long estimatedTime = System.currentTimeMillis() - startTime;
		int t= (int) estimatedTime;
		return t;
	}
}
