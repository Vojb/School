package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Course;
import model.Studied;
import model.Studying;

public class CourseAccess {

	public static ArrayList<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getCourses());
			rs = preState.executeQuery();

			while (rs.next()) {
				Course c = new Course();
				c.setcCode(rs.getString(2));
				c.setcName(rs.getString(1));
				c.setcPoints(rs.getInt(3));
				courses.add(c);

			}
		} catch (SQLException e) {

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (preState != null) {
				try {
					preState.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return courses;
	}

	public static boolean createCourse(String cName, String cCode, int cPoints) {
		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.createCourse());
			preState.setString(1, cName);
			preState.setString(2, cCode);
			preState.setInt(3, cPoints);

			preState.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public static void deleteCourse(String cCode) {

		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteCourse());
			preState.setString(1, cCode);

			preState.execute();

		} catch (SQLException e) {

		}

	}

	public static ArrayList<Studied> showGradeCourse(String cCode) {

		ArrayList<Studied> studiedList = new ArrayList<Studied>();

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.showGradeCourse());
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			while (rs.next()) {

				Studied stud = new Studied();
				stud.setGrade(rs.getString(3));
				stud.setcCode(rs.getString(2));
				stud.setsPnr(rs.getString(1));
				stud.setSemester(rs.getString(4));

				studiedList.add(stud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studiedList;

	}

	public static Course getCourse(String cCode) {
		Course c = null;
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getCourse());
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			while (rs.next()) {
				c = new Course();
				c.setcCode(rs.getString("cCode"));
				c.setcName(rs.getString("cName"));
				c.setcPoints(rs.getInt("cPoints"));

			}
		} catch (SQLException e) {

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (preState != null) {
				try {
					preState.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return c;
	}
	public static String getPrecentageinCourse(String cCode) {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		String percent= new String();

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.showPrecentageAinCourse());
			preState.setString(1, cCode);
			preState.setString(2, cCode);
			rs = preState.executeQuery();
			
			while(rs.next()){
				percent = rs.getString(1);	
			}
			
}catch (SQLException e) {

} finally {
	if (rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
		}
	}

	if (preState != null) {
		try {
			preState.close();
		} catch (SQLException e) {
		}
	}

	if (con != null) {
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
}
		return percent;
		
}

	public static ArrayList<Studying> showStudyingCourses(String cCode) {

		ArrayList<Studying> studyingList = new ArrayList<Studying>();

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.showStudyingCourses());
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			while (rs.next()) {

				Studying stud = new Studying();
				stud.setcCode(rs.getString(2));
				stud.setsPnr(rs.getString(1));
				stud.setSemester(rs.getString(3));

				studyingList.add(stud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studyingList;

	}
		
	

}