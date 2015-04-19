package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebSitePage {
	
public AndroidDriver driver;
	
	public WebSitePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@FindBy(id = "menurite_login_key")
	@CacheLookup
	private WebElement LOGIN_BUTTON;
	
	@FindBy(id = "userName")
	@CacheLookup
	private WebElement LOGIN_ID;
	
	@FindBy(id = "Login")
	@CacheLookup
	private WebElement CONTINUE_BUTTON;
	
	
	
	public WebSitePage switchToWebView(){
		
		Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);
            }
            
        }
		return this;
	}
	public WebSitePage clickOnLoginButton(){
		LOGIN_BUTTON.click();;
		return this;
	}
	
	public WebSitePage enterLoginID(){
		LOGIN_ID.sendKeys("patel5788@gmail.com");
		return this;
	}
	
	public WebSitePage clickOnContinueButton(){
		CONTINUE_BUTTON.click();
		return this;
	}
	
	
	
	
	

}
