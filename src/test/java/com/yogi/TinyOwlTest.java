package com.yogi;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testConfig.TestConfig;
import tinyOwnPages.MainPage;

public class TinyOwlTest {
	public AndroidDriver driver;
	// TODO Auto-generated constructor stub


@Parameters({"RunOn","deviceName","ApplicationPath"})
@BeforeTest
public void init(String runon,String deviceName, String apppath) throws InterruptedException, MalformedURLException{
	driver=TestConfig.startAppium(runon,deviceName, apppath);
	
}
@Test
public void LoginPage() throws InterruptedException{
	Thread.sleep(10000L);
	new MainPage(driver)
	    .editLocation("andheri")
	    .selectFirstLocation()
	    .ssearrchRestaurent("Shivam")
	    .getMenuTitle();
	Thread.sleep(10000L);
	
	
	
}
@AfterTest(alwaysRun=true)
	public void after(){
		driver.quit();
	}
}

