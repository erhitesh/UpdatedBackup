package com.eduven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.eduven.constants.DataConstants;


public class DatabaseConnection {
	
	
	/* Global Declaration */
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;  
	
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
	 * This method is used to return the type for diet list.
	 * @return : List as value for type of diet.
	 */
	public static List<String> verifyTypeOfDietList(){
		List<String> typeOfDietList = new ArrayList<String>();
		typeOfDietList.add("Vegetarian");
		typeOfDietList.add("Non-Vegetarian");
		typeOfDietList.add("Vegan");
		typeOfDietList.add("All");
		return typeOfDietList;
	}
	
	/**
	 * This method is used to return the type for diet list.
	 * @return : List as value for type of diet.
	 */
	public static List<String> getTypeOfDietList(){
		List<String> typeOfDietList = new ArrayList<String>();
		typeOfDietList.addAll(verifyTypeOfDietList());
		
		return typeOfDietList;
	}
	
	
	/**
	 * This method is used to get the random type of diet name.
	 * @return : String as type of diet name.
	 */
	public static String getTypeOfDiet(){
		String typeOfDiet ="";
		List<String> list = getTypeOfDietList();
		typeOfDiet = list.get(new Random().nextInt(list.size()-1));
		
		return typeOfDiet;
	}
	
	/* Courses related data */
	/**
	 * This method is used to get the List of taste bud category name.
	 * @param typeOfDiet : String type
	 * @return : List as tatse bud values.
	 */
	public static List<String> coursesCategory(String typeOfDiet){
		List<String> courses_cat = new ArrayList<String>();
		String sqlQuery = "";
		if (typeOfDiet.equalsIgnoreCase("all")){
			sqlQuery = "select course_name from course order by [order];";
		}	
		else if (typeOfDiet.equalsIgnoreCase("vegetarian")){
			sqlQuery = "select c.course_name from course c,recipe where lower(recipe.[course]) like lower('%,'||c.[course_name]||',%') and recipe.type_of_diet like '%vegetarian%' and status = 1  GROUP BY c.[course_name] order by c.[order];";
		}
		else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select c.course_name from course c,recipe where lower(recipe.[course]) like lower('%,'||c.[course_name]||',%') and (recipe.type_of_diet like '%meat%' or recipe.type_of_diet like '%seafood%' or recipe.type_of_diet like '%poultry%') and status = 1  GROUP BY c.[course_name] order by c.[order];";
		}
		else if (typeOfDiet.equalsIgnoreCase("vegan")){
			sqlQuery = "select c.course_name from course c,recipe where lower(recipe.[course]) like lower('%,'||c.[course_name]||',%')  and recipe.type_of_diet like '%vegan%' and status = 1  GROUP BY c.[course_name] order by c.[order];";
		}
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				courses_cat.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		
		return courses_cat;
	}
	
	
	/**
	 * This method is used to get random tatse bud name.
	 * @return : String name as tatse bud.
	 */
	public static String randomCoursesCategory(String typeOfDiet){
		String random_courses_cat = "";
		List<String> list = coursesCategory(typeOfDiet);
		random_courses_cat = list.get(new Random().nextInt(list.size()-1));
		
		return random_courses_cat;
	}

	
	/**
	 * This method is used to get the courses term list.
	 * @param typeOfDietName : String type.
	 * @param coursesCategoryName : for getting the taste bud term list based on taste bud category name.
	 * @return : List as taste bud recipe name.
	 */
	public static List<String> getCoursesCategoryRecipeNameList(String typeOfDietName, String coursesCategoryName){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where course like '%"+coursesCategoryName.replaceAll("'", "''")+"%' order by is_paid desc;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and course like '%"+coursesCategoryName.replaceAll("'", "''")+"%' order by is_paid desc;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")) {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and course like '%"+coursesCategoryName.replaceAll("'", "''")+"%' order by is_paid desc;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and course like '%"+coursesCategoryName.replaceAll("'", "''")+"%' order by is_paid desc;";
		}
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
	 * This method is used to get free term recipe name for course.
	 * @param typeOfDietName : String type.
	 * @param courseCategoryName : String type.
	 * @return String name as free recipe name.
	 */
	public static String getCourseUnLockTerm(String typeOfDietName, String courseCategoryName){
		String freeTerm = "";
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where course like '%"+courseCategoryName.replaceAll("'", "''")+"%' and is_paid=1 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where course like '%"+courseCategoryName.replaceAll("'", "''")+"%' and (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and is_paid=1 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")) {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName.replaceAll("'", "''")+"%' and course like '%"+courseCategoryName+"%' and is_paid=1 order by random() limit 1;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName.replaceAll("'", "''")+"%' and course like '%"+courseCategoryName+"%' and is_paid=1 order by random() limit 1;";
		}
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
	 * This method is used to get lock term recipe name for course.
	 * @param typeOfDietName : String type.
	 * @param courseCategoryName : String type.
	 * @return String name as lock recipe name.
	 */
	public static String getCourseLockTerm(String typeOfDietName, String courseCategoryName){
		String lockTerm = "";
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where course like '%"+courseCategoryName.replaceAll("'", "''")+"%' and is_paid=0 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where course like '%"+courseCategoryName.replaceAll("'", "''")+"%' and (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and is_paid=0 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")) {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName.replaceAll("'", "''")+"%' and course like '%"+courseCategoryName+"%' and is_paid=0 order by random() limit 1;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName.replaceAll("'", "''")+"%' and course like '%"+courseCategoryName+"%' and is_paid=0 order by random() limit 1;";
		}
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
	 * This method is used to get the List of taste bud category name.
	 * @param typeOfDiet : String type
	 * @return : List as tatse bud values.
	 */
	public static List<String> tasteBudCategory(String typeOfDiet){
		List<String> taste_bud_cat = new ArrayList<String>();
		String sqlQuery = "";
		if (typeOfDiet.equalsIgnoreCase("all")){
			sqlQuery = "select taste_bud_name from taste_bud order by [order];";
		}
		else if (typeOfDiet.equalsIgnoreCase("vegetarian")){
			sqlQuery = "select c.taste_bud_name from taste_bud c,recipe where lower(recipe.[taste_bud]) like lower('%,'||c.[taste_bud_name]||',%')  and recipe.type_of_diet like '%vegetarian%' and status = 1  GROUP BY c.[taste_bud_name] order by c.[order];";
		}
		else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select c.taste_bud_name from taste_bud c,recipe where lower(recipe.[taste_bud]) like lower('%,'||c.[taste_bud_name]||',%')  and (recipe.type_of_diet like '%meat%' or recipe.type_of_diet like '%seafood%' or recipe.type_of_diet like '%poultry%') and status = 1  GROUP BY c.[taste_bud_name] order by c.[order];";
		}
		else if (typeOfDiet.equalsIgnoreCase("vegan")){
			sqlQuery = "select c.taste_bud_name from taste_bud c,recipe where lower(recipe.[taste_bud]) like lower('%,'||c.[taste_bud_name]||',%')  and recipe.type_of_diet like '%vegan%' and status = 1  GROUP BY c.[taste_bud_name] order by c.[order];";
		}
		createConnection();
		try {
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				taste_bud_cat.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return taste_bud_cat;
	}

	
	/**
	 * This method is used to get random tatse bud name.
	 * @param typeOfDiet : String type
	 * @return : String name as tatse bud.
	 */
	public static String randomTasteBudCategory(String typeOfDiet){
		String taste_bud_subcat = "";
		List<String> list = tasteBudCategory(typeOfDiet);
		taste_bud_subcat = list.get(new Random().nextInt(list.size()-1));
		
		return taste_bud_subcat;
	}

	
	/**
	 * This method is used to get the taste bud term list.
	 * @param typeOfDietName : String type.
	 * @param tasteBudCategoryName : for getting the taste bud term list based on taste bud category name.
	 * @return : List as taste bud recipe name.
	 */
	public static List<String> getTasteBudCategoryRecipeNameList(String typeOfDietName, String tasteBudCategoryName){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryName+"%' order by is_paid desc;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and taste_bud like '%"+tasteBudCategoryName+"%' order by is_paid desc;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' order by is_paid desc;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' order by is_paid desc;";
		}
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
	 * This method is used to get free term recipe name for taste bud.
	 * @param typeOfDietName : String type.
	 * @param tasteBudCategoryName : String type.
	 * @return String name as free recipe name.
	 */
	public static String getTasteBudUnLockTerm(String typeOfDietName, String tasteBudCategoryName){
		String freeTerm = "";
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryName+"%' and is_paid=1 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' and is_paid=1 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryName+"%' and (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and is_paid=1 order by random() limit 1;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' and is_paid=1 order by random() limit 1;";
		}
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
	 * This method is used to get lock term recipe name for taste bud.
	 * @param typeOfDietName : String type.
	 * @param tasteBudCategoryName : String type.
	 * @return String name as lock recipe name.
	 */
	public static String getTasteBudLockTerm(String typeOfDietName, String tasteBudCategoryName){
		String lockTerm = "";
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryName+"%' and is_paid=0 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryName+"%' and (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and is_paid=0 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' and is_paid=0 order by random() limit 1;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' and is_paid=0 order by random() limit 1;";
		}
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
	 * This method is used to get the all recipe list.
	 * @param typeOfDietName : for getting the recipe list based on the type of diet.
	 * @return : List as recipe name list.
	 */
	public static List<String> allRecipeList(String typeOfDietName){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe order by recipe_name;";//"select recipe_name from recipe order by is_paid desc;";//
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') order by is_paid desc;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' order by is_paid desc;";
		}
		else{
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' order by is_paid desc;";
		}
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
				}
		}
		catch(SQLException e){}
		return list;
	}
	
	
	
	/**
	 * This method is used to get free term recipe name for All Recipe.
	 * @param typeOfDietName : String type.
	 * @return String name as free recipe name.
	 */
	public static String getRecipeUnLockTerm(String typeOfDietName){
		String freeTerm = "";
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where is_paid=1 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
			sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and is_paid=1 order by random() limit 1;";
		}
		else if (typeOfDietName.equalsIgnoreCase("vegetarian")) {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and is_paid=1 order by random() limit 1;";
		}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and is_paid=1 order by random() limit 1;";
		}
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1);
			}
		}catch(SQLException e){}
		
		return freeTerm;
	}
	
	
	/**
	 * This method is used to get the recipe list base on the below following conditions.
	 * @param typeOfDiet : String type, for type of diet.
	 * @param tasteBudCategoryType : String type for taste bud category.
	 * @param ingredientName : String type for filter
	 * @return : based on the above conditions returns list of recipes name.
	 */
	public static List<String> recipesNameListIncludeFilter(String typeOfDiet, String tasteBudCategoryType, String ingredientName){
		List<String> includeRecipeNameList = new ArrayList<String>();
		String sqlQuery = "";
		try{
			if (tasteBudCategoryType.length() > 0){
				if (typeOfDiet.equalsIgnoreCase("all")){
					sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryType+"%' and base_ing like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
					sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and taste_bud like '%"+tasteBudCategoryType+"%' and base_ing like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("vegetarian")) {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and taste_bud like '%"+tasteBudCategoryType+"%' and base_ing like '%|"+ingredientName+"|%' order by recipe_name;";
				} 
				else {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and taste_bud like '%"+tasteBudCategoryType+"%' and base_ing like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				}
			else if (tasteBudCategoryType.length() == 0){
				if (typeOfDiet.equalsIgnoreCase("all")){
					sqlQuery = "select recipe_name from recipe where base_ing like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
					sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and base_ing like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("vegetarian")) {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and base_ing like '%|"+ingredientName+"|%' order by recipe_name";
				}
				else {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and base_ing like '%|"+ingredientName+"|%' order by recipe_name";
				}
			}
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				includeRecipeNameList.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		
		return includeRecipeNameList;
	}
	
	
	/**
	 * This method is used to get the recipe list base on the below following conditions.
	 * @param typeOfDiet : String type, for type of diet.
	 * @param tasteBudCategoryType : String type for taste bud category.
	 * @param DietaryNeeds : String type for dietary needs.
	 * @return : based on the above conditions returns list of recipes name.
	 */
	public static List<String> recipesNameListForDietaryNeeds(String typeOfDiet, String tasteBudCategoryType, String dietaryNeeds){
		List<String> dietaryRecipeNameList = new ArrayList<String>();
		String sqlQuery = "";
		try{
			if (tasteBudCategoryType.length() > 0){
				if (typeOfDiet.equalsIgnoreCase("all")){
					sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryType+"%' and type_of_diet like '%"+dietaryNeeds+"%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
					sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryType+"%' and type_of_diet like '%"+dietaryNeeds+"%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("vegetarian")) {
					sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryType+"%' and type_of_diet like '%"+typeOfDiet+"%' and type_of_diet like '%"+dietaryNeeds+"%' order by recipe_name;";
				}
				else {
					sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryType+"%' and type_of_diet like '%"+typeOfDiet+"%' and type_of_diet like '%"+dietaryNeeds+"%' order by recipe_name;";
				}
				}
			else if (tasteBudCategoryType.length() == 0){
				if (typeOfDiet.equalsIgnoreCase("all")){
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%|"+dietaryNeeds+"|%' order by recipe_name";
				}
				else{
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and type_of_diet like '%"+dietaryNeeds+"%' order by recipe_name";
				}
			}
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				dietaryRecipeNameList.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		
		return dietaryRecipeNameList;
	}
	
	
	/**
	 * This method is used to get the recipe list base on following conditions.
	 * @param typeOfDiet : String type, for type of diet.
	 * @param tasteBudCategoryType : String type for taste bud category.
	 * @param ingredientName : String type for filter
	 * @return : based on the above conditions returns list of recipes name.
	 */
	public static List<String> recipesNameListExcludeFilter(String typeOfDiet, String tasteBudCategoryType, String ingredientName){
		List<String> excludeRecipeNameList = new ArrayList<String>();
		String sqlQuery = "";
		try{
			if (tasteBudCategoryType.length() > 0){
				if (typeOfDiet.equalsIgnoreCase("all")){
					sqlQuery = "select recipe_name from recipe where taste_bud like '%"+tasteBudCategoryType+"%' and base_ing not like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
					sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and taste_bud like '%"+tasteBudCategoryType+"%' and base_ing not like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("vegetarian")) {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and taste_bud like '%"+tasteBudCategoryType+"%' and base_ing not like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and taste_bud like '%"+tasteBudCategoryType+"%' and base_ing not like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				}
			else if (tasteBudCategoryType.length() == 0){
				if (typeOfDiet.equalsIgnoreCase("all")){
					sqlQuery = "select recipe_name from recipe where base_ing not like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
					sqlQuery = "select recipe_name from recipe where (type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and base_ing not like '%|"+ingredientName+"|%' order by recipe_name;";
				}
				else {
					sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDiet+"%' and base_ing not like '%|"+ingredientName+"|%' order by recipe_name";
				}
			}
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				excludeRecipeNameList.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		
		return excludeRecipeNameList;
	}
	
	/**
	 * This method is used to get lock term recipe name for All Recipe.
	 * @param typeOfDietName : String type.
	 * @return String name as lock recipe name.
	 */
	public static String getRecipeLockTerm(String typeOfDietName){
		String lockTerm = "";
		String sqlQuery = "";
		if (typeOfDietName.equalsIgnoreCase("all")){
			sqlQuery = "select recipe_name from recipe where is_paid=0 order by random() limit 1;";
			}
		else {
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+typeOfDietName+"%' and is_paid=0 order by random() limit 1;";
		}
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
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<< Recipe Detail Page lower part.
	public static String ingredientsOnRecipeDetailPage(String recipeName){
		String ingredientStr = "";
		String sqlQuery = "select Ingredients from recipe where recipe_name like '%"+recipeName+"%';";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				ingredientStr = resultSet.getString(1);
			}
		}catch(SQLException e){
		}
		return ingredientStr;
	}
	
	
	/**
	 * This method is used to get the benefits list based on ingredients name.
	 * @param ingredients_name
	 * @return : Benefits list.
	 */
	public static List<String> ingredientsBenefits(String ingredients_name){
		List<String> benefits_list = new ArrayList<String>();
		String sqlQuery = "select benefits from benefits_tips where base_ing_id=(select base_ing_id from actual_xref_base_ingredient where actual_ing_id=(select ingredient_id from ingredient where ingredient_name like '"+ingredients_name+"'));";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				benefits_list.add(resultSet.getString(1));
			}
		}catch(SQLException e){
		}
		
		return benefits_list;
	}
	
	/**
	 * This method is used to get method text.
	 * @param recipeName : String type.
	 * @return : String value as method text or description.
	 */
	public static String methodText(String recipeName){
		String method_txt = "";
		String sqlQuery = "select method from recipe where recipe_name like '%"+recipeName+"%';";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				method_txt = resultSet.getString(1);
			}
		}catch(SQLException r){	
		}
		
		return method_txt;
	}
	
	/**
	 * This method is used to return the list of recipe name for turbo search.
	 * @param typeOfDietName : String type
	 * @param searchCategory : Search Category
	 * @param searchSubCategory : Search Sub Category.
	 * @return : based on the above parameters returns the list.
	 */
	public static List<String> getRecipeNameForTurboSearch(String typeOfDietName, String searchCategory, String searchSubCategory){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "";
		if (searchCategory.equalsIgnoreCase("taste buds")){
			sqlQuery = "select recipe_name from recipe where taste_bud like '%"+searchSubCategory+"%' order by recipe_name;";
		}
		else if (searchCategory.equalsIgnoreCase("country")){
			sqlQuery = "select recipe_name from recipe where country like '%"+searchSubCategory+"%' order by recipe_name;";
		}
		else if (searchCategory.equalsIgnoreCase("ethnicity")){
			sqlQuery = "select recipe_name from recipe where ethnicity like '%"+searchSubCategory+"%' order by recipe_name;";
		}
		else if (searchCategory.equalsIgnoreCase("type of diet")){
			sqlQuery = "select recipe_name from recipe where type_of_diet like '%"+searchSubCategory+"%' order by recipe_name;";
		}
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
	 * This method is used to find out actual recipe time.
	 * @param typeOfDietName : String type.
	 * @param recipeName : String type.
	 * @return : recipe time.
	 */
	public static String recipeActualTime(String typeOfDietName, String recipeName){
		String recipeActualTime = "";
		String sqlQuery = "";
		try{
			if (typeOfDietName.equalsIgnoreCase("all")){
				sqlQuery = "select actual_time from recipe where recipe_name like '"+recipeName+"';";
			}
			else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
				sqlQuery = "select actual_time from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '"+recipeName+"';";
			}
			else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
				sqlQuery = "select actual_time from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '"+recipeName+"';";
			}
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				recipeActualTime = resultSet.getString(1);
			}
		}catch(SQLException e){
			
		}
		return recipeActualTime;
	}
	
	
	/**
	 * This method is used to find out the recipe servings.
	 * @param typeOfDietName : String type.
	 * @param recipeName : String type.
	 * @return : recipe time.
	 */
	public static String recipeServings(String typeOfDietName, String recipeName){
		String recipeServings = "";
		String sqlQuery = "";
		try{
			if (typeOfDietName.equalsIgnoreCase("all")){
				sqlQuery = "select servings from recipe where recipe_name like '"+recipeName+"';";
			}
			else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
				sqlQuery = "select servings from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '"+recipeName+"';";
			}
			else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
				sqlQuery = "select servings from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '"+recipeName+"';";
			}
			else if (typeOfDietName.equalsIgnoreCase("vegan")){
				sqlQuery = "select servings from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '"+recipeName+"';";
			}
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				recipeServings = resultSet.getString(1);
			}
		}catch(SQLException e){
			
		}
		
		return recipeServings;
	}
	
	
	/**
	 * This method is used to find out the recipe ratings.
	 * @param typeOfDietName : String type.
	 * @param recipeName : String type.
	 * @return : recipe time.
	 */
	public static String recipeRatings(String typeOfDietName, String recipeName){
		String recipeRatings = "";
		String sqlQuery = "";
		try{
			if (typeOfDietName.equalsIgnoreCase("all")){
				sqlQuery = "select rating from recipe where recipe_name like '%"+recipeName+"%';";
			}
			else if (typeOfDietName.equalsIgnoreCase("vegetarian")){
				sqlQuery = "select rating from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '%"+recipeName+"%';";
			}
			else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
				sqlQuery = "select rating from recipe where type_of_diet like '%"+typeOfDietName+"%' and recipe_name like '%"+recipeName+"%';";
			}
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				recipeRatings = resultSet.getString(1);
			}
		}catch(SQLException e){
			
		}
		
		return recipeRatings;
	}
	
	
	/**
	 * This method is used to get tips description text.
	 * @param tipsCategory : String type for 
	 * @param premiumStatus : boolean value for returing the tips value
	 * @return List of tips description.
	 */
	public static List<String> tipsDescription(String tipsCategory, boolean premiumStatus){
		List<String> tips_description = new ArrayList<String>();
		String sqlQuery = "";
		if (premiumStatus == true){
			sqlQuery = "select tips_msg from tips where sub_cat like '%"+tipsCategory+"%' limit 10;";
		}
		else {
			sqlQuery = "select tips_msg from tips where sub_cat like '%"+tipsCategory+"%';";
		}
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				tips_description.add(resultSet.getString(1));
			}
		}catch(SQLException e){
			
		}
		//System.out.println(tipsCategory+"<<<<<<<<<<>>>>>>>>>>>>> "+tips_description);
		return tips_description;
	}
	
	public static List<String> tipsCategory(){
		List<String> tips_cat = new ArrayList<String>();
		String sqlQuery = "select distinct sub_cat from tips order by sub_cat;";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				tips_cat.add(resultSet.getString(1));
			}
		}catch(SQLException e){
			
		}
		return tips_cat;
	}
	
	/**
	 * This method is used to return the tags value list.
	 * @return : ArrayList
	 */
	public static List<String> tagsList(){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select category_name from category where status=1 order by [order];";
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
	 * This method is used to verify tags value.
	 * @param recipeName
	 * @return
	 */
	public static List<String> tagsValue(String recipeName){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select taste_bud, country, continent, ethnicity, eating_time, type_of_diet, also_known_as from recipe where recipe_name='"+recipeName+"';";
		List<String> tags_list = tagsList();
		for (int i = 0; i < tags_list.size(); i++){
			sqlQuery = "select "+tags_list.get(i).replaceAll(" ", "_")+" from recipe where recipe_name='"+recipeName+"';";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
			}
		}catch(SQLException e){
			}
		}
		return list;
	}
	/**
	 * This method is used to return the list.
	 * @return : Type List,returns values are Recipe Name, servings, cooking time
	 */
	public static List<String> contributeRelatedData(){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select recipe_name, servings, actual_time from recipe where type_of_diet like '%vegetarian%' order by random() limit 1";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
		}catch(SQLException e){
		}
		return list;
	}


	/**
	 * This method is used to get the nutrition value list.
	 * @return List
	 */
	public static List<String> nutritionName(){
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select nutrition_name from nutrition;";
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
	

	public static ArrayList<Object> nutritionValue(String ingredientName){
		ArrayList<Object> obj = new ArrayList<Object>();
		List<String> nutrition_name = new ArrayList<String>();
		List<String> nutrition_qty = new ArrayList<String>();
		List<String> nutritionNameList = nutritionName();
		for (int i = 0; i < nutritionNameList.size(); i++){
			String sqlQuery = "select "+nutritionNameList.get(i)+" from base_ingredient_nutritional_value where base_ing_id=(select base_ing_id  from actual_xref_base_ingredient where actual_ing_id=(select ingredient_id from ingredient where ingredient_name='"+ingredientName+"'));";
			try{
				createConnection();
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()){
					if (resultSet.getString(1) == null){
					}
					else if (resultSet.getString(1).contentEquals("0.0") == true){
					}
					else{
						nutrition_name.add(nutritionNameList.get(i));
						nutrition_qty.add(resultSet.getString(1));
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		obj.add(nutrition_name);
		obj.add(nutrition_qty);
		return obj;
	}
	
	/**
	 * @param ingredientName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> nutritionNameList(String ingredientName){
		List<String> list = new ArrayList<String>();
		List<String> dbNutrition = (List<String>) nutritionValue(ingredientName).get(0);
		for (int i = 0; i < dbNutrition.size(); i++){
			String sqlQuery = "select ui_name from nutrition_unit where nutrition_name='"+dbNutrition.get(i)+"';";
			try{
				createConnection();
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()){
					list.add(resultSet.getString(1));
				}
			}catch(SQLException w){
			}
		}
		return list;
	}
	
	/**
	 * This method is used to get the nutrition quantity list.
	 * @param ingredientName : String type.
	 * @return List.
	 */
	public static List<String> actualNutritionQuantityList(String ingredientName){
		@SuppressWarnings("unchecked")
		List<String> dbNutrition = (List<String>) nutritionValue(ingredientName).get(1);
		
		return dbNutrition;
	}
	
	
	/**
	 * This method is used to get nutrition dri value.
	 * @return : List.
	 */
	@SuppressWarnings("unchecked")
	public static List<String> nutritionDriValues(String ingredientName){
		List<String> list = new ArrayList<String>();
		List<String> ingredientList = (List<String>) nutritionValue(ingredientName).get(0);
		String sqlQuery = "";
		for (int i = 0; i < ingredientList.size(); i++){
			try{
				sqlQuery = "select daily_values from nutrition where nutrition_name='"+ingredientList.get(i)+"' ;";
				createConnection();
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()){
					list.add(resultSet.getString(1));
				}
			}catch(SQLException e){
			}
		}
		
		return list;
	}
	
	public static boolean checkRecipeStatus(String recipeName){
		boolean recipeStatus = false;
		String sqlQuery = "select is_paid from recipe where recipe_name='"+recipeName+"'";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				//System.out.println(resultSet.getInt(1));
				if (resultSet.getInt(1)==1){
					recipeStatus = true; 
				}
			}
			
		}catch(SQLException e){	
		}
		
		return recipeStatus;
	}
	
	
	public static String ingredientName(String typeOfDietName, String tasteBudCategoryName){
		String ingredientStr = "";
		String sqlQuery = "";
		if (tasteBudCategoryName.length() > 0){
			if (typeOfDietName.equalsIgnoreCase("all")){
				sqlQuery = "select ingredients from recipe where taste_bud like '%"+tasteBudCategoryName+"%' order by  random() limit 1;";
			}
			else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
				sqlQuery = "select ingredients from recipe where(type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') and taste_bud like '%"+tasteBudCategoryName+"%' order by  random() limit 1;";
			}
			else {
				sqlQuery = "select ingredients from recipe where type_of_diet like '%"+typeOfDietName+"%' and taste_bud like '%"+tasteBudCategoryName+"%' order by  random() limit 1;";
			}
		}
		else if (tasteBudCategoryName.length() == 0){
			if (typeOfDietName.equalsIgnoreCase("all")){
				sqlQuery = "select ingredients from recipe order by  random() limit 1;";
			}
			else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
				sqlQuery = "select ingredients from recipe where(type_of_diet like '%meat%' or type_of_diet like '%seafood%' or type_of_diet like '%poultry%') order by  random() limit 1;";
			}
			else {
				sqlQuery = "select ingredients from recipe where type_of_diet like '%"+typeOfDietName+"%' order by  random() limit 1;";
			}
		}
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				ingredientStr = resultSet.getString(1);
			}
		}catch(SQLException e){}
		
		return ingredientStr;
	}
	
	public static void main(String args[]){
		List<String> list = allRecipeList("all");
		for (String str : list){
			System.out.println(str);
		}
		/*for (int i = 0; i < list.size(); i++){
			List<String> cat = getTasteBudCategoryRecipeNameList("vegan", list.get(i));
			for (int j = 0; j < cat.size(); j++){
				System.out.println(cat.get(j));
			}
		}*/
		/*for (int i = 0; i < list.size(); i++){
			List<String> cat = getTasteBudCategoryRecipeNameList("vegetarian", list.get(i));
			System.out.println("Category name....>>>"+list.get(i)+"<<<<<<>>>>"+cat.get(0)+"Last Term>>>>>>>"+cat.get(cat.size()-1) +"<<<<>>>>>>Size...>"+cat.size());
			for (int i = 0; i < cat.size(); i++){
				System.out.println(cat.get(i));
			}
		}*/
	}
	
	
}
