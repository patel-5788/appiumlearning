package webAppTests;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testConfig.TestConfig;

public class ChromeTest {
public AndroidDriver driver;
	
@Parameters({"RunOn","deviceName","ApplicationPath"})
@BeforeTest
public void init(String runon,String deviceName, String apppath) throws InterruptedException, MalformedURLException{
	driver=TestConfig.startAppium(runon,deviceName, apppath);
}

@ AfterTest(alwaysRun= true)
public void tearDown(){
	driver.quit();
}	


@Test(priority=1)
public void registertTest() throws InterruptedException{
   Thread.sleep(10000L);
   driver.get("http://gmail.com/");
	Thread.sleep(2000);
	driver.findElement(By.id("Email")).sendKeys("test");
	Thread.sleep(2000);
	driver.findElement(By.id("Passwd")).sendKeys("test");
	Thread.sleep(2000);
	driver.findElement(By.id("signIn")).click();
	Thread.sleep(2000);
	driver.quit();
   Thread.sleep(10000L);
   
}

}