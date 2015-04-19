package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class LocateCenterPage {
public AndroidDriver driver;
	
	public LocateCenterPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "gov.mea.psp:id/back")
	@CacheLookup
	private MobileElement BACK_BUTTON;
	
	@AndroidFindBy(id = "gov.mea.psp:id/exit")
	@CacheLookup
	private MobileElement HOME_BUTTON;
	
	public HomePage backButtonFromLocationCeenterPage(){
		driver.tap(1, BACK_BUTTON, 1);
		return new HomePage(driver);
		}
	public HomePage homeButtonFromLocationCeenterPage(){
		driver.tap(1, HOME_BUTTON, 1);
		return new HomePage(driver);
		
	}

}
