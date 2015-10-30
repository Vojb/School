package dal;

import java.sql.*;

public class DbUtil {

	static Connection con = null;
	static PreparedStatement preState = null;
	static ResultSet rs = null;

	public static Connection getConn() throws SQLException {
		String connStr = "jdbc:sqlserver://172.16.198.149:1433;databaseName=uppgift1;user=sa;password=mats;";

		return DriverManager.getConnection(connStr);

	}

	public static String getStudent() {
		return "SELECT * FROM Student WHERE sPnr = ?";
	}

	public static String getStudentsCourses() {
		return "SELECT * FROM Studying WHERE sPnr = ?";
	}

	public static String getStudyingPoints() {
		return "SELECT SUM(c.cPoints) FROM Course c WHERE c.ccode IN (SELECT h.ccode FROM Studying h WHERE h.sPnr = ? and semester = ?)";
	}

	public static String getStudiedForStudent() {
		return "SELECT * FROM Studied WHERE sPnr= ? AND cCode= ? ";
	}

	public static String getStudyingStudent() {
		return "SELECT * FROM Studying WHERE sPnr= ? AND cCode= ? ";
	}

	public static String getAllStudents() {
		return "SELECT * FROM Student ORDER BY sPnr";
	}

	public static String getCourse() {
		return "SELECT * FROM Course WHERE cCode = ?";
	}

	public static String getCourses() {
		return "SELECT * FROM Course ORDER BY cCode";
	}

	public static String getStudied() {
		return "SELECT * From Studied ORDER BY sPnr";
	}

	public static String getStudiedStudent() {
		return "SELECT * From Studied where sPnr = ? and cCode = ? ORDER BY sPnr";
	}

	public static String getStudentStudieds() {
		return "SELECT * From Studied where sPnr = ? ";
	}

	public static String deleteCourse() {
		return "Delete FROM Course WHERE cCode= ?";
	}

	public static String deleteStudent() {
		return "Delete FROM Student WHERE sPnr= ?";
	}

	public static String deleteAllStudiedStudent() {
		return "DELETE FROM Studied WHERE sPnr= ?";

	}

	public static String deleteStudentfromAllStudying() {
		return "Delete FROM Studying AND sPnr= ?";

	}

	public static String deleteStudyingStudent() {
		return "Delete FROM Studying WHERE cCode= ? AND sPnr= ?";

	}

	public static String createStudent() {
		return "INSERT INTO Student VALUES(?,?,?)";
	}

	public static String createCourse() {
		return "INSERT INTO Course VALUES(?,?,?)";
	}

	public static String studyingStudent() {
		return "INSERT INTO Studying VALUES(?,?,?)";
	}

	public static String studentStudied() {
		return "INSERT INTO Studied VALUES(?,?,?,?)";
	}

	public static String showCurrentStudentInCourse() {
		return "SELECT s.sName AS Namn,s.spnr AS Personnummer,s.sAddress AS Adress "
				+ "FROM Student s "
				+ "JOIN Studying r "
				+ "ON s.spnr=r.spnr "
				+ "WHERE cCode= ?";
	}

	public static String showGradeCourse() {
		return "SELECT *" + "FROM Studied " + "WHERE cCode =  ?";
	}

	public static String showGradeStudentCourse() {
		return "SELECT s.sName, s.sPnr, s.sAddress, r.cCode,r.grade "
				+ "FROM Student s " + "JOIN Studied r " + "ON s.sPnr = r.sPnr "
				+ "WHERE cCode =  ?" + "AND s.sPnr =  ?";

	}

	public static String showPrecentageAinCourse() {
		return "SELECT (COUNT(grade)* 100 / (SELECT COUNT(*) FROM Studied WHERE ccode=?)) FROM Studied GROUP BY ccode, grade HAVING ccode= ? AND Grade='A' ";
	}

	public static String showAvgStudentStudied() {
		return "SELECT cCode, Count(*)Totalt FROM Studied WHERE grade != 'U' GROUP BY cCode ORDER BY Totalt DESC";
	}

	public static String getStudying() {
		return "SELECT * From Studying ORDER BY sPnr";
	}

	public static String showStudyingCourses() {
		return "SELECT * From Studying where cCode = ?";
		}

}
