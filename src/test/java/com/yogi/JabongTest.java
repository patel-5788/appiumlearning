package com.yogi;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JabongTest {
	public AndroidDriver driver;
public JabongHomePage homepage;
	@Parameters("RunOn")
	@BeforeTest
	public void init(String runon) throws MalformedURLException, InterruptedException{
		//driver=TestConfig.startAppium(runon);
		homepage= new JabongHomePage(driver);
		new MainPage(driver);
		
	}

	@Test(priority=1)
	public void loginTest(){
		homepage
		.openLeftHandMenu()
		.clickOnLogin()
		.enterLoginId("itspatel5788@gmail.com")
		.enterPassword("9993712760")
		.clickOnLoginButton();
	}
	
	@AfterTest(alwaysRun=true)
	public void quit(){
		driver.quit();
	}
	
	
}
