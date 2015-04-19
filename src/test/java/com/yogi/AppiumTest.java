package com.yogi;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testConfig.TestConfig;

public class AppiumTest{
	public AndroidDriver driver;
		// TODO Auto-generated constructor stub
	

	private HomePage homepage;
	@Parameters({"RunOn","deviceName","ApplicationPath"})
	@BeforeTest
	public void init(String runon,String deviceName,String apppath) throws InterruptedException, MalformedURLException{
		driver=TestConfig.startAppium(runon,deviceName,apppath);
		homepage= new HomePage(driver);
		new MainPage(driver);
		
	}
	
	@Test(priority=1)
	public void FeeCalculater(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("test started");
		homepage
		.tapOnFeeCalculator()
		.selectTypeOfService()
		.chooseTypeOfService()
		.applicantAge()
		.selectAge()
		.bookletPage()
		.choosePages()
		.schemeName()
		.chooseScheme()
		.submit()
		.AssertFeeCalculation("    Rs. 2000")
		.backButtonFromFeeCalculatorPage();
		/*.tapOnExitApp()
		.tapOnExitOk();*/
		
		
		
		
	}
	//@Test(priority=2) // window handle is not implemented in appium java client 2.1.0
	public void CheckOnWeb(){
		homepage
		.tapOnGeneralInformation()
		.tabOnWebLink()
		.switchToWebView()
		.clickOnLoginButton()
		.enterLoginID()
		.clickOnContinueButton();
	}

}
