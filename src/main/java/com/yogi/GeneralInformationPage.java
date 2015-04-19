package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {
	
public AndroidDriver driver;
	
	public GeneralInformationPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "gov.mea.psp:id/back")
	@CacheLookup
	private MobileElement BACK_BUTTON;
	
	@AndroidFindBy(id = "gov.mea.psp:id/exit")
	@CacheLookup
	private MobileElement HOME_BUTTON;
	
	@AndroidFindBy(name = "www.passportindia.gov.in")
	@CacheLookup
	private MobileElement WEBSITE_LINK;
	
	public WebSitePage switchToChromeWindow(){
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		 // click some link that opens a new window
		tabOnWebLink();

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    System.out.println("title is--- "+ driver.getTitle());
		    
		}

		return new WebSitePage(driver);             


	}
	
	public HomePage backButton(){
		driver.tap(1, BACK_BUTTON, 1);
		return new HomePage(driver);
		}
	
	public HomePage homeButton(){
		driver.tap(1, HOME_BUTTON, 1);
		return new HomePage(driver);
		
	}
	
	public WebSitePage tabOnWebLink(){
		driver.tap(1, WEBSITE_LINK, 1);
		return new WebSitePage(driver);
	}

}
