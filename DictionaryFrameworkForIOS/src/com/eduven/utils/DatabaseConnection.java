package com.eduven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;


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
	 * @return : Type ArrayList, list of value.
	 */
	public static List<String> getMainCategories(){
		List<String> mainCategoryList = new ArrayList<String>();
		String sqlQuery = "select category_name from category order by order_sequence;";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				mainCategoryList.add(resultSet.getString(1).trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mainCategoryList;
	}

	
	/**
	 * This method is used to get random category name.
	 * @return
	 */
	public static String randomCategoryName(){
		String randomName = "";
		List<String> mainCategoryList = getMainCategories();
		Random random = new Random();
		randomName = mainCategoryList.get(random.nextInt(mainCategoryList.size()));
		
		return randomName;
	}

	/**
	 * This method is used to get term list.
	 * @param mainCategory : Category Name
	 * @return : ArrayList
	 */
	public static List<String> getTermList(String mainCategory){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select entity_name from entity_master where entity_category='"+mainCategory+"' order by entity_name;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
			}
			}
		catch(SQLException e){
		}
		
		return list;
	}
	
	
	/**
	 * This method is used to get the unlock term count.
	 * @param mainCategory : Category Name
	 * @return : integer value for unlock term count.
	 */
	public static int getUnlockTermCount(String mainCategory){
		int count = 0;
		String sqlQuery = "select entity_name from entity_master where entity_category='"+mainCategory+"' and lite=1;";
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
	 * @return : integer value for unlock term count.
	 */
	public static List<String> getFiftyPercentOfUnlockTerm(String mainCategory){
		List<String> unlockTerm50 = new ArrayList<String>();
		String sqlQuery = "select entity_name from entity_master where entity_category='"+mainCategory+"' and lite=1 order by entity_id limit "+getUnlockTermCount(mainCategory)/2+";";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				unlockTerm50.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		
		return unlockTerm50;
	}

	
	/**
	 * This method is used to get free term.
	 * @param mainCategory : Category Name
	 * @return : String as free term
	 */
	public static String getUnLockTerm(String categoryName){
		String freeTerm = "";
		String sqlQuery = "select entity_name from entity_master where entity_category='"+categoryName+"' and lite=1 order by random() limit 1;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1);
			}
		}catch(SQLException e){
		}
		
		return freeTerm;
	}
	
	/**
	 * This method is used to get lock term.
	 * @param mainCategory : category name
	 * @return : String as paid term.
	 */
	public static String getLockTerm(String mainCategory){
		String lockTerm = "";
		String sqlQuery = "select entity_name from entity_master where entity_category='"+mainCategory+"' and lite=0 order by random() limit 1;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				lockTerm = resultSet.getString(1);
			}
		}catch(SQLException e){
		}
		return lockTerm;
	}
	
	
	/**
	 * This method is used to check the status of term.
	 * @param termName
	 * @return : boolean value for term name.
	 */
	public static boolean checkTermStatus(String termName){
		boolean status = false;
		String sqlQuery = "select lite from entity_master where entity_name='"+termName+"';";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				if (resultSet.getInt(1)==1){
					status = true;
				}
			}
		} catch (SQLException e) {
		}
		return status;
	}
	
	/**
	 * This method is used to return the description name based on below conditions.
	 * @param categoryName : String type categoryName.
	 * @param termName : String type termName.
	 * @return : String value as term description
	 */
	public static String termDescription(String categoryName, String termName){
		String descriptionTxt = "";
		String sqlQuery = "select definition from entity_master where entity_category='"+categoryName+"'  and entity_name='"+termName+"';";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				descriptionTxt = resultSet.getString(1);
			}
		}catch(SQLException e){
		}
		
		return descriptionTxt;
	}
	
	
	/**
	 * This method is used to return the description text.
	 * @return : String value as term description
	 */
	public static String termDescription(){
		String categoryName = randomCategoryName();;
		String termName = "";
		String descriptionTxt = "";
		try{
			termName = getUnLockTerm(categoryName);
			String sqlQuery = "select definition from entity_master where entity_category='"+categoryName+"'  and entity_name='"+termName+"';";
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				descriptionTxt = resultSet.getString(1);
			}
		}catch(SQLException e){
		}
		
		return descriptionTxt;
	}
	
	public static String getTermWithLargerTxt(String categoryName){
		String termName = "";
		String sqlQuery = "select entity_name from entity_master where entity_category like '%"+categoryName+"%' and lite ='1' and length(definition) > 200 order by random() limit 1;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				termName = resultSet.getString(1);
			}
		}catch(SQLException w){
			
		}
		
		return termName;
	}
	
	
	/**
	 * This method is used to get the heading list of term detail page.
	 * @return : List 
	 */
	public static List<String> termDetailPageHeadingList(){
		List<String> headingList = new ArrayList<String>();
		String sqlQuery = "select attribute_name from control where is_used='1'";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				headingList.add(resultSet.getString(1));
			}
		}catch(SQLException e){
			Logs.error("Not found any heading name. "+e.getClass().getName());
		}
		
		return headingList;
	}
	
	/**
	 * This method is used to return the heading value present on the term detail page.
	 * @param termName : String type term name.
	 * @param category : String type category name.
	 * @return : List type as headin values.
	 */
	public static List<String> termDetailPageHeadingValue(String categoryName, String termName){
		
		List<String> headingValue = new ArrayList<>();
		List<String> headingList = termDetailPageHeadingList();
		String sqlQuery = "";
		for (int i = 0; i < headingList.size() ; i++){
			sqlQuery = "select "+headingList.get(i)+" from entity_master where entity_name like '%"+termName+"%' and entity_category like '%"+categoryName+"%' ;";
			try{
				createConnection();
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()){
					if (resultSet.getString(1) != null){
						headingValue.add(resultSet.getString(1));
					}
				}
			}catch(SQLException e){
				//Logs.error("Heading Value not found. "+e.getClass().getName());
			}
		}
		return headingValue;
	}
	public static List<String> getPatternListValue(String strText){
		List<String> list = new ArrayList<String>();
		ArrayList<String> strData = new ArrayList<String>(Arrays.asList(strText.split("_")));
		System.out.println(strData);
		/* Create Pattern Object */
		Pattern pattern = Pattern.compile("_[0-9]{9}#@#|_[0-9]{9}");
		/* Create a Matcher object */
		for (int i = 0; i < strData.size(); i++){
			Matcher matcher = pattern.matcher(strData.get(i));
			if (matcher.find()){
				list.add(matcher.group(0));
			}
		}
		
		return list;
	}
	
	public static void main(String args[]) {
		System.out.println(termDetailPageHeadingList());
		List<String> list = termDetailPageHeadingValue("2010 - After", "Roman Reigns");
		for (int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	}
