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
	 * This method is used to get the main Category list.
	 * @param languageName : for selection the word based on the language name.
	 * @return : Type ArrayList, list of value.
	 */
	public static List<String> getMainCategories(String languageName){
		List<String> mainCategoryList = new ArrayList<String>();
		String sqlQuery = "select "+languageName+", cat_id from category where type ='category' order by cat_order;";
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
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' order by set_order";
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
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' and is_sample=1 order by set_order";
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
	public static List<String> getTermListAsPhoenticsName(String mainCategory, String languageName){
		List<String> list = new ArrayList<String>();
		String category_type = mainCategory.toUpperCase();
		String regular = "";
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' and is_sample=1 order by set_order";
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
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' and is_sample=1;";
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
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' and is_sample=1 order by set_order limit "+getUnlockTermCount(mainCategory, languageName)/2+"";
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
	 *  This method is used to get free term.
	 * @param mainCategory : Category Name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String as free term
	 */
	public static String getUnLockTerm(String mainCategory, String languageName){
		String freeTerm = "";
		String updatedTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' and is_sample='1' order by random() limit 1";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1).substring(resultSet.getString(1).indexOf("=")+1,resultSet.getString(1).indexOf("|"));
				/*if (freeTerm.startsWith("I'")){
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Inside");
					updatedTerm = freeTerm.replace("I'", "I'");
				}*/
			}
		}catch(SQLException e){
		}
		
		return freeTerm;
	}
	
	/**
	 * This method is used to get lock term.
	 * @param mainCategory : category name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String as paid term.
	 */
	public static String getLockTerm(String mainCategory, String languageName){
		String lockTerm = "";
		String category_type = mainCategory.toUpperCase();
		String sqlQuery = "select "+languageName+" from masterword where category='"+category_type+"' and is_sample='0' order by random() limit 1";
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
		//ArrayList<Object> quichSearchList = new ArrayList<Object>();
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
		String sqlQuery = "select "+languageName+" from masterword where user_category like '%"+category_type+"%' order by set_order";
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
		String sqlQuery = "select "+languageName+" from masterword where user_category like '%"+category_type+"%' and is_sample='1' order by random() limit 1";
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
		String sqlQuery = "select "+languageName+" from masterword where user_category like '%"+category_type+"%' and is_sample='0' order by random() limit 1";
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
		String sqlQuery = "select key_type_name from ctrl_language where key_type_translation='"+switchLingoName+"' ";
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
	

/*	*//**
	 * This method is used to get the main Category list.
	 * @return : Type ArrayList, list of value.
	 *//*
	public static ArrayList<Object> getMainCategories(int key_type_id_for_language){
		ArrayList<Object> mainCategoryList = new ArrayList<Object>();
		HashMap<String, Integer> mapList1 = new HashMap<String, Integer>();
		HashMap<Integer, String> mapList2 = new HashMap<Integer, String>();
		List<String> list = new ArrayList<String>();
		String sqlQuery = "select key_cat_text , key_cat_id from key_cat_language where key_type_id="+key_type_id_for_language+" order by key_grp_cat_id";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				mapList1.put(resultSet.getString(1), resultSet.getInt(2));
				mapList2.put(resultSet.getInt(2), resultSet.getString(1));
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mainCategoryList.add(mapList1);
		mainCategoryList.add(mapList2);
		mainCategoryList.add(list);
		//System.out.println(mainCategoryList.get(1));
		
		return mainCategoryList;
	}
	
	*//**
	 * This method is used to get term list.
	 * @param mainCatgory : Category Name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : ArrayList
	 *//*
	public static ArrayList<String> getTermList(String mainCatgory, int key_type_id_for_language){
		HashMap<String, Integer> catIdList = (HashMap<String, Integer>) getMainCategories(key_type_id_for_language).get(0);
		ArrayList<String> list = new ArrayList<String>();
		try{
		String sqlQuery = "select key_name from pair_key where key_cat_id = "+catIdList.get(mainCatgory)+" and key_type_id = "+key_type_id_for_language+" ";
		resultSet = statement.executeQuery(sqlQuery);
		while (resultSet.next()){
			list.add(resultSet.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			}
		//System.out.println("Term List."+list);
		
		return list;
	}
	
	
	*//**
	 *  This method is used to get free term.
	 * @param mainCatgory : Category Name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String
	 *//*
	public static String getUnLockTerm(String mainCatgory, int key_type_id_for_language){
		String freeTerm = "";
		HashMap<String, Integer> catIdList = (HashMap<String, Integer>) getMainCategories(key_type_id_for_language).get(0);
		try{
			//getMainCategories(key_type_id_for_language);
			String sqlQuery = "select key_name from pair_key where key_cat_id = "+catIdList.get(mainCatgory)+" and key_type_id = "+key_type_id_for_language+" and is_sample = '1' order by random() limit 1  ";
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1);
				}
			}catch(Exception e){
				e.printStackTrace();
				}
		//System.out.println("Free Term Name. "+freeTerm);
		return freeTerm;
		}
	
	*//**
	 * This method is used to get lock term.
	 * @param mainCatgory : category name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String.
	 *//*
	public static String getLockTerm(String mainCatgory, int key_type_id_for_language){
		String LockTerm = "";
		HashMap<String, Integer> catIdList = (HashMap<String, Integer>) getMainCategories(key_type_id_for_language).get(0);
		try{
			//getMainCategories();
			String sqlQuery = "select key_name from pair_key where key_cat_id = "+catIdList.get(mainCatgory)+" and key_type_id = "+key_type_id_for_language+" and is_sample = '0' order by random() limit 1  ";
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				LockTerm = resultSet.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("Lock Term Name. "+LockTerm);
		return LockTerm;
	}
	
	
	 Quick List 
	*//**
	 * This method is used to get the Quick List Category list.
	 * @return : HashMap.
	 *//*
	public static ArrayList<Object> getQuickListCategory(int key_type_id_for_langauge){
		ArrayList<Object> quickListCategory = new ArrayList<Object>();
		HashMap<String, Integer> mapList1 = new HashMap<String, Integer>();
		HashMap<Integer, String> mapList2 = new HashMap<Integer, String>();
		String sqlQuery = "select user_cat_text, user_cat_id from user_cat_language where key_type_id="+key_type_id_for_langauge+"";//"select user_cat, user_cat_id from user_cat;";
		try {
			createConnection();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				mapList1.put(resultSet.getString(1), resultSet.getInt(2));
				mapList2.put(resultSet.getInt(2), resultSet.getString(1));
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		quickListCategory.add(mapList1);
		quickListCategory.add(mapList2);
		//System.out.println("Quick List. "+quickListCategory.get(0));
		
		return quickListCategory;
	}
	
	
	*//**
	 * This method is used to get term list of Quick List.
	 * @param mainCatgory : Category Name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : ArrayList
	 *//*
	public static ArrayList<String> getQuickTermList(String mainCatgory, int key_type_id_for_langauge){
		HashMap<String, Integer> catIdList = (HashMap<String, Integer>) getQuickListCategory(key_type_id_for_langauge).get(0);
		System.out.println(catIdList.get(mainCatgory));
		ArrayList<String> list = new ArrayList<String>();
		try{
			String sqlQuery = "select c.key_name from key_tag a, user_cat b, pair_key c where b.user_cat_id=a.user_cat_id and a.pair_key_id=c.key_id and c.key_type_id="+key_type_id_for_langauge+" and b.user_cat_id="+catIdList.get(mainCatgory)+";";
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
				}
			}
		catch(Exception e){
			e.printStackTrace();
			}
		//System.out.println("Quick Term List."+list);
		return list;
	}
	
	
	*//**
	 *  This method is used to get free term.
	 * @param mainCategory : Category Name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String
	 *//*
	public static String getUnLckTermForQuickList(String mainCategory, int key_type_id_for_langauge){
		String freeTerm = "";
		HashMap<String, Integer> catIdList = (HashMap<String, Integer>) getQuickListCategory(key_type_id_for_langauge).get(0);
		try{
			String sqlQuery = "select c.key_name from key_tag a, user_cat b, pair_key c where b.user_cat_id=a.user_cat_id and a.pair_key_id=c.key_id and c.key_type_id="+key_type_id_for_langauge+" and b.user_cat_id="+catIdList.get(mainCategory)+" and c.is_sample = 1 order by random() limit 1  ";
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				freeTerm = resultSet.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//System.out.println("Free Term Name. "+freeTerm);
		
		return freeTerm;
	}
	
	*//**
	 * This method is used to get lock term.
	 * @param mainCatgory : category name
	 * @param key_cat_id_for_language : int value for language.
	 * @return : String.
	 *//*
	public static String getLockTermForQuickList(String mainCatgory, int key_type_id_for_langauge){
		String LockTerm = "";
		HashMap<String, Integer> catIdList = (HashMap<String, Integer>) getQuickListCategory(key_type_id_for_langauge).get(0);
		try{
			String sqlQuery = "select c.key_name from key_tag a, user_cat b, pair_key c where b.user_cat_id=a.user_cat_id and a.pair_key_id=c.key_id and c.key_type_id="+key_type_id_for_langauge+" and b.user_cat_id="+catIdList.get(mainCatgory)+" and c.is_sample = 0 order by random() limit 1  ";
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()){
				LockTerm = resultSet.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//System.out.println("Lock Term Name. "+LockTerm);
		
		return LockTerm;
	}
	
	*//**
	 * This method is used to get language code corresponding to language name.
	 * @param languageName : String type language name.
	 * @return : integer value as language code.
	 *//*
	public static int getLanguageCode(String languageName){
		int language_code = 0;
		String sqliteQuery = "select key_type_id from key_type where key_type_name='"+languageName+"'";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqliteQuery);
			while (resultSet.next()){
				language_code = resultSet.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("Language Code Value."+language_code);
		
		return language_code;
	}
	
	*//**
	 * This method is used to get language translation name corresponding to language name.
	 * @param languageName : String type language name.
	 * @return : integer value as language code.
	 *//*
	public static String languageTranslationName(String languageName){
		String translation_name = "";
		String sqliteQuery = "select key_type_translation from key_type where key_type_name='"+languageName+"'";
		try{
			createConnection();
			resultSet = statement.executeQuery(sqliteQuery);
			while (resultSet.next()){
				translation_name = resultSet.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Language Translation Name."+translation_name);
		
		return translation_name;
	}*/
	
	public static String convertToUTF8(String s) {
    	String out = "";
        try {
        	byte before[]=s.getBytes("UTF-8");
        	out = new String(before, "UTF-8");
        	}
        catch (java.io.UnsupportedEncodingException e) {
        	return null;
        	}
        return out;
    }
	
	public static void main(String args[]) {
		/*String str=convertToUTF8("ç");
		System.out.println(convertToUTF8("Français").equalsIgnoreCase(convertToUTF8("Français")));
		System.out.println(convertToUTF8("ç").equalsIgnoreCase("ç"));
		String native1 = convertToUTF8("Français");
		System.out.println("yagaag:"+native1);
		
		System.out.println(getLanguageNameCorresSwitchLingo(native1)); //Français,*/
		
		
		System.out.println(getTermListAsPhoenticsName("Colors", DataConstants.languageNameForRendering));
		System.out.println(getTermListAsRenderingName("Colors", DataConstants.languageNameForRendering));

//		for (int i = 0; i< 100; i++){
//			System.out.println(getUnLockTerm("Health & Medical I", "english"));
//		}
		
	}
}
