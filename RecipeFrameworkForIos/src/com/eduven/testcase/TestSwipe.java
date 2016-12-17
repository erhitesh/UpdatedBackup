package com.eduven.testcase;

import org.testng.annotations.Test;

import com.eduven.modules.AllRecipes;
import com.eduven.modules.RecipeDetailPage;
import com.eduven.utils.Reusables;


public class TestSwipe {
	

	@Test(priority=2)
	public void testall(){
		AllRecipes.navigateToAllRecipePage();
		
	}
	
	@Test(priority=3)
	public void testran(){
		AllRecipes.clickOnRandomAllRecipesList("all");
		Reusables.dragAndDrop(RecipeDetailPage.methodBtn, RecipeDetailPage.ingredientsBtn);
		RecipeDetailPage.clickOnTag();
		
	}

}
