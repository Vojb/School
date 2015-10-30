package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCronus { 
	
	static Connection con = null;
	static PreparedStatement preState= null;
	static ResultSet rs = null;

	public static Connection getConn() throws SQLException {
		String connStr = "jdbc:sqlserver://172.16.198.129:1433;databaseName=Uppgift2;user=sa;password=mats;";

		return DriverManager.getConnection(connStr);

	}
public static String getKeys(){
	return "SELECT TABLE_NAME, COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE";		
}
public static String getIndex(){
	return "SELECT * FROM sys.indexes";
}
public static String getTableCons() {
	return "SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE";
}
public static String getAllTablesOne(){
	return "SELECT * FROM INFORMATION_SCHEMA.TABLES";
}
public static String getAllTablesTwo(){
	return "SELECT sobjects.name FROM sysobjects sobjects WHERE sobjects.xtype = 'U'";
}
public static String getEmployeeOne(){
	return "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
}
public static String getEmployeeTwo(){
	return "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";

}
public static String getTableMaxRows(){
	return "SELECT TOP 1 t.name AS TableName, SUM(p.rows) AS RowCounts FROM sys.tables t INNER JOIN sys.indexes i ON t.object_id = i.object_id INNER JOIN sys.partitions p ON i.object_id = p.object_id AND i.index_id = p.index_id GROUP BY t.name, i.object_id, i.index_id, i.name ORDER BY SUM(p.rows) desc";
}
public static String getMetaData(String from){
	return "SELECT * FROM "+from+" ";
	
}public static String getColumnNames(){

return "SELECT top 5 INFORMATION_SCHEMA.COLUMNS.COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = ? ";
	
}
}
