package com.yogi;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class FirstTest {
	
	
	public AppiumDriver driver;
	
@Test
public void FirstSampleTest() throws MalformedURLException, InterruptedException{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	File app = new File("D:\\Appium\\selendroid-test-app.apk");
	capabilities.setCapability("deviceName", "emulator-5554");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("app", app.getAbsolutePath());
	driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Thread.sleep(10000L);
	
	driver.findElementById("io.selendroid.testapp:id/startUserRegistration").click();
	//driver.tap(1, driver.findElementById("io.selendroid.testapp:id/startUserRegistration"), 1);
}
}
