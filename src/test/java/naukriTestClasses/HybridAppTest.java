package naukriTestClasses;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import nakriPages.NaukriFrontPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testConfig.TestConfig;

public class HybridAppTest {
	public AndroidDriver driver;
	// TODO Auto-generated constructor stub

	@Parameters({"RunOn","deviceName","ApplicationPath"})
	@BeforeTest
	public void init(String runon,String deviceName, String apppath) throws MalformedURLException, InterruptedException{
		driver=TestConfig.startAppium(runon,deviceName, apppath);
	
}
@Test
public void registerationTest() throws InterruptedException{
	 Thread.sleep(5000L);
	 driver.tap(1, driver.findElementById("com.shaadi.android:id/registerfree"), 1);
	
	 Thread.sleep(50000L);
	 TestConfig.switchToWebView();
	 System.out.println("Context is-" +driver.getContext());
	 driver.findElement(By.id("email")).sendKeys("Arvind.patel@ness.com");
	 driver.findElement(By.id("password1")).sendKeys("Password@123");
	 
	 Select select = new Select(driver.findElement(By.id("postedby")));
	 select.selectByValue("Friend");
	 driver.findElement(By.id("first_name")).sendKeys("Arvind");
	 driver.findElement(By.id("last_name")).sendKeys("patel");
	 
	 Select gender = new Select(driver.findElement(By.id("gender")));
	 select.selectByValue("Male");
	 
	 
	 Thread.sleep(30000L);

}

@AfterTest(alwaysRun=true)
public void quit(){
	//Log.info("quiting appium " );
	driver.quit();
}

}
