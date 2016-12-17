package com.eduven.constants;


public interface DataConstants {
	
	/* App Header text */
	public static String appName = "Seafood Recipes";
	
	/* DB Location */
	static String dbLoc = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/RecipeFrameworkForAndroid/chefchili.db";
	
	/* Home Page Related Data */
	public static String homePageHeaderTxt = "Home";
	
	/* Buy Subscription Related Data */
	static String alert_message_before_app_purchase = "Sample Title";
	static String already_purchase_app_message = "You've already purchased this. Would you like to get it again for free?";
	
	
	/* FeedBack related data */
	static String get_in_touch_fb_txt = "facebook.com";
	static String get_in_touch_twitter_txt = "twitter.com";
	static String get_in_touch_instagram_txt = "instagram.com";
	static String get_in_touch_mail_txt = "";
	static String get_in_touch_tumblr_txt = "tumblr.com";
	
	/* Information and support */
	static String term_and_condition_url_text = "terms.php";
	static String privacy_policy_url_text = "privacy.php";
	
	/* FaceBook Related Data */
    static String facebook_userName = "ma2011.test@gmail.com";
    static String facebook_userPass = "evtesters";
    static String facebook_post_message = appName;
    
    /* DRI Alert message popup */
    static String dri_alert_message = "DRI is the general term for a set of reference values used for planning and assessing nutrient intakes of healthy people. These values, which vary by age, gender & ethnicity.";
    
    /* Menu planner related data */
    static String menu_planner_header_txt = "Menu Planner";
    static String toastMessageForInvalidMenuPlanner = "Please choose a valid future date and time for the event";
    static String toastMessageForSuccessfullyAddedMenuPlanner = "Successfully";
    static String breakfastTiming = "6:00 AM";
    static String lunchTiming = "10:00 AM";
    static String dinnerTiming = "6:00 PM";
    
    /* Method related data */
    static String voice_command_txt_msg = "You can listen to the step by step recitation of recipe preparation by using Voice Commands";
    static String method_txt = "Mince onion and clove and fry in the oil till soft.";
    
    /* type of diet name */
    static String typeOfDietForVegetarian = "Vegetarian";
    static String typeOfDietForNonVegetarian = "Non-Vegetarian";
    static String typeOfDietForVegan = "Vegan";
    static String typeOfDietForAll = "All";
    static String typeOfDietForSeafood = "Seafood";
	
	/* Search Related Data */
	public static String searchTypeRecipe = "byrecipe";
	public static String searchTypeIngredient = "byingredient";
	public static String search_type_for_lookup_by_recipe = "Aloo Parathas";
	public static String search_type_for_lookup_by_ingredient = "Ginger";
	
	/* Filter Related Data */
	public static String filerAlertMessage = "Please note that ingredients, process & products are subject to change by a manufacturer at any time. All food & products should be considered at risk for cross-contamination";
	public static String filterPageHeaderTxt = "Filter";
	public static String filter_with_include_ingredients = "Ginger";
	public static String filter_with_exclude_ingredients = "Onion";
	public static String filter_with_diet_need = "";
	
	
	/* Tips Related Data */
	public static String tip_page_header_txt = "Tips";
	public static String tip_description_name_for_beauty = "BEAUTY";
	public static String tip_description_name_for_food = "FOOD";
	public static String tip_description_name_for_home_made = "HOME MADE";
	public static String tip_description_name_for_household = "HOUSEHOLD";
	public static String tip_description_name_for_miscellaneous = "MISCELLANEOUS";
	public static String tip_description_name_for_remedy = "REMEDY";
	public static String tip_description_name_for_wellness = "WELLNESS";
	
	/* Contribute Related Data */
	public static String recipeName = "TestRecipe";
	public static String servings = "4";
	public static String cookingtime = "30";
	public static String ingredientName = "AllSpice";
	public static String quantity = "10";
	public static String unit = "kg";
	public static String preparationDescriptionTxt = "RecipeMethod";
	
	
	/* Toast Message Verification */
	static String toastMessageForEduBank = "Add Recipes in EduBank for a quick";
	static String toastMessageForDeleteRecipeFromEdubank = "Deleted";//"Add Recipes in EduBank for a quick";
	static String toastMessageForMethod = "You can enable voice Commands";
	static String toastMessageForContribute = "Great! You have successfully";//"Great! You have successfully contributed and you will see this in our next update!";
	
	/* EduBak Page Data */
	public static String eduBank_header_value = "EduBank";
	public static String eduBankDeleteMessage = "Delete recipe(s) from EduBank?";
	
	/* App Purchase Title */
	public static String app_purchase_confirmatim_title = "Confirm Your In-App Purchase Do you want to buy one Be Pro-Indian (All Pack) for ₹ 190?  [Environment: Sandbox]";

	/* Detail Page Related Data */
	public static String detail_page_header = "Recipe Detail";
	public static String more_recipes_alert_txt = "More Recipes! Can you smell something delicious? If not, then get the Premium version of this app for more recipes!";
	
	/* Select Unit Related Data */
	static String select_unit_message = "Select a Unit system to measure Ingredients";
	static String alcoholicTxt = "You must be over the legal drinking age as per your country";
	static String downloadRecipeImagesMessage = "Get recipe images now and view the delicacies before you try them out. Else you can";
	
	/* Course Page Data */
	public static String course_header_value = "Courses";
	
	/* Taste Bud Page Data */
	public static String taste_bud_header_value = "Taste Buds";

	/* All Recipes Page Data */
	public static String all_recipes_header_value = "Recipes";
	
	/* Cook with Page Data */
	public static String cook_with_header_value = "Cook with";
	public static String cook_with_alert_message = "Add Ingredients and shake your gadget for delicious recipes!";
	
	/* Cooking Type Data */
	public static String cooking_type_header_value = "Cooking Type";
	
	/* User Related Data */
	static String user_name = "Test MA";
	
	/* Wait Related Data */
	static int implicitWaitTime = 30;
}
