package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;
import model.Studied;
import model.Studying;

public class StudentAccess {

	public static ArrayList<Student> getAllStudents() {

		ArrayList<Student> students = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getAllStudents());
			rs = preState.executeQuery();
			while (rs.next()) {

				Student stud = new Student();
				stud.setsPnr(rs.getString(1));
				stud.setsName(rs.getString(2));
				stud.setAddress(rs.getString(3));

				students.add(stud);
			}
		} catch (SQLException e) {
		System.out.println(e);
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
		return students;
	}

	public static boolean createStudent(String sName, String Address, String sPnr) {

		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.createStudent());
			preState.setString(1, sName);
			preState.setString(2, sPnr);
			preState.setString(3, Address);

			preState.execute();
			return true;

		} catch (SQLException e) {
			return false;
		}

	}

	public static boolean createStudyingStudent(String cCode, String sPnr,
			String semester) {
		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.studyingStudent());
			preState.setString(1, cCode);
			preState.setString(2, sPnr);
			preState.setString(3, semester);

			preState.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public static void createStudiedStudent(String grade, String cCode,
			String sPnr, String semester) {

		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.studentStudied());
			preState.setString(3, sPnr);
			preState.setString(2, cCode);
			preState.setString(1, grade);
			preState.setString(4, semester);

			preState.execute();

		} catch (SQLException e) {

		}

	}

	public static ArrayList<Studied> getAllStudentsStudied() {
		ArrayList<Studied> studentStudied = new ArrayList<Studied>();
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudied());
			rs = preState.executeQuery();

			while (rs.next()) {

				Studied stud = new Studied();
				stud.setsPnr(rs.getString(3));
				stud.setcCode(rs.getString(2));
				stud.setGrade(rs.getString(1));
				stud.setSemester(rs.getString(4));

				studentStudied.add(stud);
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
		return studentStudied;
	}

	public static ArrayList<Studying> getAllStudyingStudents() {
		ArrayList<Studying> studentStudying = new ArrayList<Studying>();
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudying());
			rs = preState.executeQuery();
			while (rs.next()) {

				Studying stud = new Studying();
				stud.setsPnr(rs.getString(2));
				stud.setcCode(rs.getString(1));
				stud.setSemester(rs.getString(3));

				studentStudying.add(stud);
			}
		} catch (SQLException e) {
			// throw new DalException("Fel när du la till kund!");

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
		return studentStudying;
	}

	public static void deleteStudent(String sPnr) {

		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteStudent());
			preState.setString(1, sPnr);

			preState.execute();

		} catch (SQLException e) {

		}

	}

	public static void deleteStudyingStudent(String cCode, String sPnr) {

		Connection con = null;
		PreparedStatement preState = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteStudyingStudent());
			preState.setString(1, cCode);
			preState.setString(2, sPnr);

			preState.execute();

		} catch (SQLException e) {

		}

	}

	public static ArrayList<Student> showCurrentStudentsInCourse(String cCode) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con
					.prepareStatement(DbUtil.showCurrentStudentInCourse());
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			while (rs.next()) {

				Student stud = new Student();
				stud.setsName(rs.getString(1));
				stud.setsPnr(rs.getString(2));
				stud.setAddress(rs.getString(3));

				studentList.add(stud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;

	}

	public static Student getStudent(String sPnr) {
		Student stud = null;
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudent());
			preState.setString(1, sPnr);
			rs = preState.executeQuery();

			while (rs.next()) {
				stud = new Student();
				stud.setsName(rs.getString("sName"));
				stud.setsPnr(rs.getString("sPnr"));
				stud.setAddress(rs.getString("sAddress"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

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
		return stud;

	}

	public static Studying getStudyingStudent(String sPnr, String cCode) {
		Studying studying = null;
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudyingStudent());
			preState.setString(1, sPnr);
			preState.setString(2, cCode);
			rs = preState.executeQuery();

			while (rs.next()) {
				studying = new Studying();
				studying.setsPnr(rs.getString("sPnr"));
				studying.setcCode(rs.getString("cCode"));
				studying.setSemester(rs.getString("semester"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

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
		return studying;

	}

	public static void deleteCoursesFromStudent(String sPnr) {
		Connection con = null;
		PreparedStatement preState = null;

		PreparedStatement preState2 = null;
		try {
			con = DbUtil.getConn();

			preState = con.prepareStatement(DbUtil
					.deleteStudentfromAllStudying());
			preState.setString(1, sPnr);

			preState.execute();

			preState2 = con.prepareStatement(DbUtil.deleteAllStudiedStudent());

			preState2.setString(1, sPnr);

			preState2.execute();

		} catch (SQLException e) {

		}

	}

	public static int getStudentsCoursesPoints(String sPnr, String semester) {
		int sum = 0;

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudyingPoints());
			preState.setString(1, sPnr);
			preState.setString(2, semester);
			rs = preState.executeQuery();

			while (rs.next()) {
				sum = rs.getInt(1);
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
		return sum;
	}

	public static Studied getStudentStudied(String sPnr, String cCode) {
		
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		Studied stud = new Studied();
		
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudiedStudent());
			preState.setString(1, sPnr);
			preState.setString(2, cCode);
			rs = preState.executeQuery();

			while (rs.next()) {
				stud.setsPnr(rs.getString("sPnr"));
				stud.setcCode(rs.getString("cCode"));
				stud.setGrade(rs.getString("grade"));
				stud.setSemester(rs.getString("semester"));
				
				
				
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
		return stud;
	}
	
	public static ArrayList<Studied> getAvgFlow() {
		ArrayList<Studied> studentStudied = new ArrayList<Studied>();
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.showAvgStudentStudied());
			rs = preState.executeQuery();
			while (rs.next()) {

				Studied stud = new Studied();
				stud.setcCode(rs.getString("cCode"));
				stud.setTotal(rs.getString("Totalt"));

				studentStudied.add(stud);
			}
		} catch (SQLException e) {
			// throw new DalException("Fel när du la till kund!");
			System.out.println(e.getMessage());
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
		return studentStudied;
	}

	

public static boolean getStudentStudiedAlready(String sPnr, String cCode) {
	
	Connection con = null;
	PreparedStatement preState = null;
	ResultSet rs = null;
	
	try {
		con = DbUtil.getConn();
		preState = con.prepareStatement(DbUtil.getStudiedStudent());
		preState.setString(1, sPnr);
		preState.setString(2, cCode);
		rs = preState.executeQuery();
		
		return rs.next();

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
	return false;
}
}
//
// public static ArrayList<Student> showAvgCourse(String
// cCode,String sPnr) {
//
// Connection con = null;
// PreparedStatement preState = null;
// ResultSet rs = null;
// ArrayList<Course> course = new ArrayList<Course>();
// ArrayList<Studied> studylist= new ArrayList<Studied>();
//
// try {
// while (rs.next()) {
// con= DbUtil.getConn();
// preState= con.prepareStatement(DbUtil.showAvgStudentStudied());
// rs= preState.executeQuery();
//
// Student stud = new Student();
// Studied study = new Studied();
// studylist = stud.getStudiedList();
// stud.setsName(rs.getString(1));
// stud.setsPnr(rs.getString(2));
// stud.setAddress(rs.getString(3));
//
// study.setcCode(rs.getString(4));
// study.setGrade(rs.getString(5));
//
// studylist.add(study);
//
// studentList.add(stud);
//
// }
//
// } catch (SQLException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// return studentList;
//
// }
//
// }
