package com.yogi;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pageConfig.PageConfig;
import sofPages.LoginPage;

public class HomePage extends PageConfig{
	
	
	public HomePage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name = "GENERAL INFORMATION")
	@CacheLookup
	private MobileElement GENERAL_INFORMATION;
	
	@AndroidFindBy( name ="LOCATE CENTRE")
	@CacheLookup
	private MobileElement LOCATE_CENTRE;
	
	@AndroidFindBy( name ="FEE CALCULATOR")
	@CacheLookup
	private MobileElement FEE_CALCULATOR;
	
	@AndroidFindBy( name ="DOCUMENT ADVISOR")
	@CacheLookup
	private MobileElement DOCUMENT_ADVISOR;
	
	@AndroidFindBy( name ="CONTACT US")
	@CacheLookup
	private MobileElement CONTACT_US;
	
	@AndroidFindBy( id ="gov.mea.psp:id/exit")
	@CacheLookup
	private MobileElement EXIT_APP;
	
	@AndroidFindBy( id ="android:id/button1")
	@CacheLookup
	private MobileElement EXIT_POPUP_YES;
	
	@AndroidFindBy(name ="NO")
	@CacheLookup
	private MobileElement EXIT_POPUP_NO;
	
	@FindBy(id="com.sof.revise:id/loginButton")
	private MobileElement LOGIN_BUTTON;
	
	@FindBy(id="com.sof.revise:id/logoutButton")
	private MobileElement LOGOUT_BUTTON;
	
	@FindBy(id="android:id/button1")
	private MobileElement LOGOUT_CONFIRM;
	
	
	public LoginPage taoOnLoginButton(){
		waitUntil(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON),20);
		driver.tap(1, LOGIN_BUTTON, 1);
		return new LoginPage(driver);
	}
	
	public HomePage taoOnLogoutButton(){
		waitUntil(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON),20);
		driver.tap(1, LOGOUT_BUTTON, 1);
		driver.tap(1, LOGOUT_CONFIRM, 1);
		
		return this;
	}
	
	public GeneralInformationPage tapOnGeneralInformation(){
		driver.tap(1, GENERAL_INFORMATION, 1);
		return new GeneralInformationPage(driver);

	}
	
	
	public FeeCalculatorPage tapOnFeeCalculator(){
		driver.tap(1, FEE_CALCULATOR, 1);
		return new FeeCalculatorPage(driver);
	}
	
	public LocateCenterPage tapOnLocateCenter(){
		driver.tap(1, LOCATE_CENTRE, 1);
		return new LocateCenterPage(driver);
	}
	 
	public HomePage  tapOnExitApp(){
		driver.tap(1, EXIT_APP, 1);
		return this;		
	}

	public HomePage  tapOnExitOk(){
		driver.tap(1, EXIT_POPUP_YES, 1);
		return this;		
	}

}
