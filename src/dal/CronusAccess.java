package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class CronusAccess {

	public static String[][] getKeys() {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getKeys());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			// DatabaseMetaData dma = con.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getIndex() {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getIndex());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getTableCons() {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getTableCons());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getAllTablesTwo() {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getAllTablesTwo());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getAllTablesOne() {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getAllTablesOne());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getEmployeeOne() {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getEmployeeOne());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getTableMaxRows() {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getTableMaxRows());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static String[][] getMetadata(String from) {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getMetaData(from));
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();
		
			
			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	

	}

	public static String[][] getEmployeeTwo() {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getEmployeeTwo());
			rs = preState.executeQuery();
			rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			int rowcount = rs.getFetchSize();
			String[][] arr = new String[rowcount][columnsNumber];
			int i = 0;
			while (rs.next() && i < rowcount) {
				for (int j = 0; j < arr[j].length; j++) {
					arr[i][j] = rs.getString(j + 1);
				}
				i++;

			}

			return arr;
		} catch (SQLException e) {
		}
		return null;
	}

	public static ArrayList<String> getColumnNames(String from) {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		ArrayList<String> arr = new ArrayList<String>();

		try {

			con = DbCronus.getConn();
			preState = con.prepareStatement(DbCronus.getColumnNames());
			preState.setString(1, from );
			rs = preState.executeQuery();

			String tmp;
			while (rs.next()) {
				tmp = rs.getString(1);
				arr.add(tmp);
			}

		} catch (SQLException e) {
		}
		return arr;
	}

}
