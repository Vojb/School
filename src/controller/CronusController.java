package controller;

import java.util.ArrayList;

import dal.CronusAccess;

public class CronusController {

public static String [][] getKeys(){
	return CronusAccess.getKeys();
}
	
public static String[][] getIndex(){
	return CronusAccess.getIndex();
	
}
public static String[][] getTableCons(){
	return CronusAccess.getTableCons();
	
}
public static String[][] getTableMaxRows(){
	return CronusAccess.getTableMaxRows();
	
}
public static String[][] getEmployeeOne(){
	return CronusAccess.getEmployeeOne();
}
public static String[][] getEmployeeTwo(){
	return CronusAccess.getEmployeeTwo();
	
}

public static String[][] getAllTablesOne(){
	return CronusAccess.getAllTablesOne();
	
}
public static String[][] getAllTablesTwo(){
	return CronusAccess.getAllTablesTwo();
	
}
public static String[][] getMetaData(String from){
 return CronusAccess.getMetadata(from);
}
public static ArrayList<String> getColumnNames(String from) {
	return CronusAccess.getColumnNames(from);
}
}