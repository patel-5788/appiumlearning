package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import pageConfig.PageConfig;

public class JabongHomePage {
public AndroidDriver driver;
	
	public JabongHomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(accessibility = "Closed")
	@CacheLookup
	private MobileElement LEFT_HAND_MENU;
	
	@AndroidFindBy(name = "Login")
	@CacheLookup
	private MobileElement LOGIN;
	
	@AndroidFindBy(name = "Logout")
	@CacheLookup
	private MobileElement LOGOUT;
	
	
	
	public JabongHomePage openLeftHandMenu(){
		LEFT_HAND_MENU.click();
		return this;		
	}

	public JabongLoginPage clickOnLogin(){
		/*if( new PageConfig(driver).isElementDisplayedName("Login")){
		driver.scrollToExact("Login");
		LOGIN.click();
		}else{
			System.out.println("Already loggedin");
			LOGOUT.click();
			LEFT_HAND_MENU.click();
			driver.scrollToExact("Login");
			LOGIN.click();*/
			//driver.findElementById("android:id/action_bar_title").click();
			//openLeftHandMenu();
			
		//}
		return new JabongLoginPage(driver);		
	}
}
