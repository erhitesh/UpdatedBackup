package com.eduven.testcase;

import org.testng.annotations.Test;

import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.utils.Reusables;


public class NotificationTest {
	
	/* Global Declaration */
	String languageName = "";
	String notificationText = "Speak SMART Italian";
	
	@Test(priority=0)
	public void install_app_and_language_selection_test(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=1)
	public void handling_rate_app_popup_test(){
		SplashScreen.hideAppRatePopup();
	}
	
	@Test(priority=5)
	public void notification_test(){
		Reusables.checkPushNotifiaction(notificationText);
	}

}
