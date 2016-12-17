package com.eduven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public static List<String> getMainCategories(String languageName){
		List<String> mainCategoryList = new ArrayList<String>();
		String sqlQuery = "select ["+languageName+"], cat_id from category where type ='category' order by cat_order";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				mainCategoryList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mainCategoryList;
	}


	/**
	 * This method is used to get term list.
	 * @param mainCategory : Category Name
	 * @param languageName : String value for language.
	 * @return : ArrayList
	 */
	public static List<String> getTermList(String mainCategory, String languageName){
		List<String> list = new ArrayList<String>();
		String category_type = mainCategory.toUpperCase();
		String regular = "";
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' order by set_order";
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
	 * This method is used to get term list.
	 * @param mainCategory : Category Name
	 * @param languageName : String value for language.
	 * @return : ArrayList
	 */
	public static List<String> getTermListAsRenderingName(String mainCategory, String languageName){
		List<String> list = new ArrayList<String>();
		String category_type = mainCategory.toUpperCase();
		String regular = "";
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' and is_sample=1 order by set_order;";
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
	 * This method is used to get term list.
	 * @param mainCategory : Category Name
	 * @param languageName : String value for language.
	 * @return : ArrayList
	 */
	public static List<String> getTermListAsPhoneticsName(String mainCategory, String languageName){
		List<String> list = new ArrayList<String>();
		String category_type = mainCategory.toUpperCase();
		String regular = "";
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' and is_sample=1 order by set_order";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				regular = resultSet.getString(1).substring(resultSet.getString(1).indexOf("|phonetic=")+1,resultSet.getString(1).indexOf("|audio")).replaceAll("phonetic=", "");
				list.add(regular);
			}
			}
		catch(SQLException e){
		}
		return list;
	}
	
	
	/**
	 * This method is used to get the unlock term count.
	 * @param mainCategory : Category Name
	 * @param languageName : language for term name.
	 * @return : integer value for unlock term count.
	 */
	public static int getUnlockTermCount(String mainCategory, String languageName){
		int count = 0;
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' and is_sample=1;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				count++;
			}
		}catch(SQLException e){
		}
		
		return count;
	}
	
	/**
	 * This method is used to get the 50 percent terms of unlock terms.
	 * @param mainCategory : Category Name
	 * @param languageName : language for term name.
	 * @return : integer value for unlock term count.
	 */
	public static ArrayList<String> getFiftyPercentOfUnlockTerm(String mainCategory, String languageName){
		ArrayList<String> unlockTerm50 = new ArrayList<String>();
		String category_type = mainCategory.toUpperCase();
		String regular = "";
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' and is_sample=1 order by set_order limit "+getUnlockTermCount(mainCategory, languageName)/2+"";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				regular = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
				unlockTerm50.add(regular);
			}
		}catch(SQLException e){
		}
		
		return unlockTerm50;
	}
	
	/**
	 * This method is used to get free term.
	 * @param mainCategory : Category Name
	 * @param languageName : language for term name.
	 * @return : String as free term
	 */
	public static String getUnLockTerm(String mainCategory, String languageName){
		String freeTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' and is_sample='1' order by random() limit 1";
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
	 * @param mainCategory : category name
	 * @param languageName : language for term name.
	 * @return : String as paid term.
	 */
	public static String getLockTerm(String mainCategory, String languageName){
		String lockTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select ["+languageName+"] from masterword where category='"+category_type+"' and is_sample='0' order by random() limit 1";
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
	public static List<String> getQuickListCategory(String languageName){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select ["+languageName+"], cat_id from category where type ='user category' order by cat_id";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		
		return list;
	}
	
	/**
	 * This method is used to get term list of Quick List.
	 * @param mainCategory : Category Name
	 * @param languageName : String value for language.
	 * @return : List
	 */
	public static List<String> getQuickTermList(String mainCategory, String languageName){
		List<String> list = new ArrayList<String>();
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select ["+languageName+"] from masterword where user_category like '%"+category_type+"%' order by set_order";
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
	 * @param languageName : String value for language.
	 * @return : String
	 */
	public static String getUnLockTermForQuickList(String mainCategory, String languageName){
		String freeTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select ["+languageName+"] from masterword where user_category like '%"+category_type+"%' and is_sample='1' order by random() limit 1";
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
	 * @param languageName : String value for language.
	 * @return : String
	 */
	public static String getLockTermForQuickList(String mainCategory, String languageName){
		String lockTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select ["+languageName+"] from masterword where user_category like '%"+category_type+"%' and is_sample='0' order by random() limit 1";
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
	
	/**
	 * This method is used to get Language name corresponding to translation name.
	 * @param switchLingoName : String type for get the language name.
	 * @return : String name as language name.
	 */
	public static String getLanguageNameCorresSwitchLingo(String switchLingoName){
		String language_name = "";
		String sqlQuery = "select key_type_name from ctrl_language where key_type_translation = '"+switchLingoName+"' ";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				language_name = resultSet.getString(1);
			}
		}catch(SQLException e){
		}
		
		return language_name;
	}

	
	public static void main(String args[]) {
		List<String> phoneticNameList = getTermListAsPhoneticsName("Colors", DataConstants.languageNameForPhonetics);
		List<String> renderingNameList = getTermListAsRenderingName("Colors", DataConstants.languageNameForRendering);
		System.out.print(phoneticNameList+"\n"+renderingNameList);
	}
	}
