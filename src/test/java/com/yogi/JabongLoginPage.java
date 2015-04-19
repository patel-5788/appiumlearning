package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class JabongLoginPage {
public AndroidDriver driver;
	
	public JabongLoginPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.jabong.android:id/edt_email")
	@CacheLookup
	private MobileElement LOGIN_ID;
	
	@AndroidFindBy(id = "com.jabong.android:id/edt_password")
	@CacheLookup
	private MobileElement PASSWORD;
	
	@AndroidFindBy(id = "com.jabong.android:id/btn_login")
	@CacheLookup
	private MobileElement LOGIN_BUTTON;
	
	public JabongLoginPage enterLoginId(String loginid){
		LOGIN_ID.sendKeys(loginid);
		return this;		
	}
	
	public JabongLoginPage enterPassword(String password){
		PASSWORD.sendKeys(password);
		driver.hideKeyboard();
		return this;		
	}
	
	public JabongHomePage clickOnLoginButton(){
		LOGIN_BUTTON.click();
		return new JabongHomePage(driver);		
	}
	
}
