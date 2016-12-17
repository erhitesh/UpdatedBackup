package com.eduven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eduven.constants.DataConstants;

public class Db {
	
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
			}
		catch(Exception e){
			e.printStackTrace();
			}
	}
	/**
	 * This method is used to get the main Category list.
	 * @param languageName : for selection the word based on the language name.
	 * @return : Type ArrayList, list of value.
	 */
	public static ArrayList<Object> getMainCategories(String languageName){
		ArrayList<Object> mainCategoryList = new ArrayList<Object>();
		/*HashMap<String, Integer> mapList1 = new HashMap<String, Integer>();
		HashMap<Integer, String> mapList2 = new HashMap<Integer, String>();*/
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select "+languageName+", cat_id from category where type ='category' order by cat_id";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				/*mapList1.put(resultSet.getString(1), resultSet.getInt(2));
				mapList2.put(resultSet.getInt(2), resultSet.getString(1));*/
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*mainCategoryList.add(mapList1);
		mainCategoryList.add(mapList2);*/
		mainCategoryList.add(list);
		
		return mainCategoryList;
	}


	/**
	 * This method is used to get term list.
	 * @param mainCatgory : Category Name
	 * @param languageType : String value for language.
	 * @return : ArrayList
	 */
	public static List<String> getTermList(String mainCatgory, String languageType){
		List<String> list = new ArrayList<String>();
		String category_type = mainCatgory.toUpperCase();
		String regular = "";
		String sqlQuery = "select "+languageType+" from masterword where category='"+category_type+"' ";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				regular = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
				list.add(regular);
			}
			}
		catch(SQLException e){
		}
		return list;
	}
	
	/**
	 *  This method is used to get free term.
	 * @param mainCatgory : Category Name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String as free term
	 */
	public static String getUnLockTerm(String mainCatgory, String languageType){
		String freeTerm = "";
		String category_type = mainCatgory.toUpperCase();
		String sqlQuery = "select "+languageType+" from masterword where category='"+category_type+"' and is_sample='1' order by random() limit 1";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
			}
		}catch(SQLException e){
		}
		
		return freeTerm;
	}
	
	/**
	 * This method is used to get lock term.
	 * @param mainCatgory : category name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String as paid term.
	 */
	public static String getLockTerm(String mainCatgory, String languageType){
		String lockTerm = "";
		String category_type = mainCatgory.toUpperCase();
		String sqlQuery = "select "+languageType+" from masterword where category='"+category_type+"' and is_sample='0' order by random() limit 1";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				lockTerm = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
			}
		}catch(SQLException e){
		}
		return lockTerm;
	}
	
	/* Quick List */
	/**
	 * This method is used to get the Quick List Category list.
	 * @param languageName : for selection particular language word.
	 * @return : ArrayList as quick list category.
	 */
	public static ArrayList<Object> getQuickListCategory(String languageName){
		ArrayList<Object> quichSearchList = new ArrayList<Object>();
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select "+languageName+", cat_id from category where type ='user category' order by cat_id";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		quichSearchList.add(list);
		return quichSearchList;
	}
	
	/**
	 * This method is used to get term list of Quick List.
	 * @param mainCatgory : Category Name
	 * @param languageType : String value for language.
	 * @return : List
	 */
	public static List<String> getQuickTermList(String mainCatgory, String languageType){
		List<String> list = new ArrayList<String>();
		String category_type = mainCatgory.toUpperCase();
		String sqlQuery = "select "+languageType+" from masterword where user_category like '"+category_type+"' ";
		String regular = "";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				regular = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
				list.add(regular);
			}
		}catch(SQLException e){
		}
		
		return list;
	}
	
	/**
	 * This method is used to get free term.
	 * @param mainCategory : Category Name
	 * @param languageType : String value for language.
	 * @return : String
	 */
	public static String getUnLockTermForQuickList(String mainCategory, String languageType){
		String freeTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select "+languageType+" from masterword where user_category like '"+category_type+"' and is_sample='1' order by random() limit 1";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
			}
		}catch(SQLException e){
		}
		
		
		return freeTerm;
	}
	
	/**
	 * This method is used to get lock term.
	 * @param mainCategory : Category Name
	 * @param languageType : String value for language.
	 * @return : String
	 */
	public static String getLockTermForQuickList(String mainCategory, String languageType){
		String lockTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select "+languageType+" from masterword where user_category like '"+category_type+"' and is_sample='0' order by random() limit 1";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				lockTerm = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
			}
		}catch(SQLException e){
		}
		return lockTerm;
	}
	
	
	public static void main(String args[]) {
		System.out.println(getLockTermForQuickList("General", "english"));
	}
	
	}
