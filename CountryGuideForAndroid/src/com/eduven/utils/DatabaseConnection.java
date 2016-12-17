package com.eduven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.eduven.constants.DataConstants;


public class DatabaseConnection {
	
	
	/* Global Declaration */
	static Connection connection = null;  
	static ResultSet resultSet = null;  
	static Statement statement = null;
	
	/**
	 * This method is used to create connection.
	 */
	public static void createConnection(){
		try{
			/* Load the driver class */
			Class.forName("org.sqlite.JDBC");
			
			/* Create the connection object */
			connection = DriverManager.getConnection("jdbc:sqlite:"+DataConstants.dbLoc);
			
			/* Create Statement Object */
			statement = connection.createStatement();
		}catch(Exception e){
			e.printStackTrace();
			}
	}
	
	/**
	 * This method is used to get the main Category list.
	 * @return : Type ArrayList, list of value.
	 */
	public static ArrayList<String> getMainCategories(){
		
		ArrayList<String> mainCategortList = new ArrayList<String>();
		String sqlQuery = "select name_to_show from category where data_line != 'NULL'";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				mainCategortList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			/*e.printStackTrace();*/
		}
		//System.out.println("Main Category List...>"+mainCategortList);
		return mainCategortList;
	}
	
	/**
	 * This method is used to get the table name.
	 * @return : Type String, return category with table name.
	 */
	public static HashMap<String, String> getTableName(){
		HashMap<String, String> tableList = new HashMap<String, String>();
		try{
			getMainCategories();
			for (String str : getMainCategories()){
				String sqlQuery = "select table_name from category where name_to_show='"+str.replaceAll("'", "''")+"'; ";
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()){
					tableList.put(str, resultSet.getString(1));
					}
				}
		}catch(SQLException e){
			/*e.printStackTrace();*/
		}
		//System.out.println("Table List..>"+tableList);
		
		return tableList;
	}
	
	/**
	 * This method is used to get SubCategory list.
	 * @param mainCategoryName: Type String,
	 * @return : List of sub category list.
	 */
	public static ArrayList<String> getSubCategoryList(String mainCategoryName){
		String tableName = getTableName().get(mainCategoryName);
		String sqlQuery = "select distinct(category) from "+tableName;
		ArrayList<String> subCategortList = new ArrayList<String>();
		/* Execute Query */
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				subCategortList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			/*e.printStackTrace();*/
			}
		return subCategortList;
	}
	
	/**
	 * This method is used to get Unlock term list.
	 * @return : Type ArrayList, return list of unlock term.
	 */
	public static String getUnlockTerms(String mainCategoryName, String subCategoryName){
		String randomSubCategoryName = subCategoryName;
		String tableName = getTableName().get(mainCategoryName);
		String freeTerm = "";
		String sqlQuery = "select name from "+tableName+" where category = '"+randomSubCategoryName+"' and is_free = '1' order by random() limit 1 ";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1).toString();
			}
		}catch(SQLException e){
			/*e.getCause().getMessage();*/
		}
		//System.out.println("Free Terms..>"+freeTerm);
		
		return freeTerm;
	}
	
	
	/**
	 * This method is used to get Lock term list.
	 * @return : Type ArrayList, return list of unlock term.
	 */
	public static String getLockTerms(String mainCategoryName, String subCategoryName){
		String paidTerm = "";
		String randomSubCategoryName = subCategoryName;
		String tableName = getTableName().get(mainCategoryName);
		String sqlQuery = "select name from "+tableName+" where category = '"+randomSubCategoryName+"' and is_free = '0' order by random() limit 1 ";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				paidTerm = resultSet.getString(1);
			}
		}catch(SQLException e){
			/*e.printStackTrace();*/
		}
		//System.out.println("Lock Terms..>"+paidTerm);
		
		return paidTerm;
	}
	
	/**
	 * This method is used to get city name for specified term name.
	 * @param mainCategoryName
	 * @param subCategoryName
	 * @param termName : generate city name based on term name. 
	 * @return : String type as city name.
	 */
	public static String categoryCityName(String mainCategoryName, String subCategoryName, String termName){
		String city_name = "";
		//String name = getUnlockTerms(mainCategoryName, subCategoryName);
		String tableName = getTableName().get(mainCategoryName);
		String sqlQuery = "select city from "+tableName+" where category = '"+subCategoryName+"' and name='"+termName+"'";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				city_name = resultSet.getString(1);
			}
			/*System.out.println("City Name.."+city_name);*/
		}
		catch(SQLException e){
			/*e.printStackTrace();*/
		}
		
		return city_name;
	}
	
	
	/**
	 * This method is used to get cities list.
	 * @return : cities list, type ArrayList.
	 */
	public static ArrayList<String> getCitiesList(){
		ArrayList<String> citiesList = new ArrayList<String>();
		String sqlQuery = "select distinct(name) from ed_city_master;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				citiesList.add(resultSet.getString(1));
			}
		}catch(SQLException e){
			/*e.printStackTrace();*/
		}
		//System.out.println("Cities List..>"+citiesList);
		
		return citiesList;
	}
	
	
	
	/**
	 * This method is used to get country list.
	 * @return : ArrayList type as country name list.
	 */
	public static List<String> getCountryName(){
		List<String> country_name_list = new ArrayList<String>();
		String sqlQuery = "select distinct(country) from ed_city_master order by country; ";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				country_name_list.add(resultSet.getString(1));
			}
		}
		catch(SQLException e){
			/*e.printStackTrace();*/
		}
		
		return country_name_list;
	}
	
	
	/**
	 * This method is used to get removed city name.
	 * @param countryName :
	 * @return : String type as city name.
	 */
	public static String getRemovedCityName(String countryName){
		String removedCityName = "";
		String sqlQuery = "select name from ed_city_master where country='"+countryName+"';";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				removedCityName = resultSet.getString(1);
			}
		}
		catch(SQLException e){
			/*e.printStackTrace();*/
		}
		
		return removedCityName;
	}
	
	/**
	 * This method is used to get event description from DB.
	 * @return : event description as String type.
	 */
	public static String getEventDescription(){
		String event_desc = "";
		String table_name = getTableName().get("Historical Events");
		String sqlQuery = "select event from '"+table_name+"' limit 1; ";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				event_desc = resultSet.getString(1);
			}
			
		}catch(SQLException e){
			/*e.printStackTrace();*/
		}
		
		return event_desc;	
	}
	
	public static void main(String args[]){
		System.out.println(getTableName());
/*		getTableName();
		getCitiesList();
		getUnlockTerms(DataConstants.historical_hangout_header_text, "Building");
		getLockTerms(DataConstants.historical_hangout_header_text, "Building");*/ 
		}
}
