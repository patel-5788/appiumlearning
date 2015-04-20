package naukriTestClasses;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import nakriPages.NaukriFrontPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Configuration;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testConfig.TestConfig;

public class NaukriRegisterTest {
	public AndroidDriver driver;
	// TODO Auto-generated constructor stub

	@Parameters({"RunOn","deviceName","ApplicationPath"})
	@BeforeTest
	public void init(String runon,String deviceName, String apppath) throws MalformedURLException, InterruptedException{
		driver=TestConfig.startAppium(runon,deviceName, apppath);
	
}
//@Test
public void registerationTest() throws InterruptedException{
	new NaukriFrontPage(driver)	 
	 .clickOnRegisterButton()
	 .waitForRegistrationPageAppear()
	 .enterTextInUsername("QA Automation")
	 .enterTextInMobileNumebr("9993712760")
	 .enterTextInEmailAddess("mailtotyogi@gmail.com")
	 .enterTextInPassword("p7108959")
	 .enterTextInConfirmPassword("p7108959")
	 .clcikOnNextButton();
	 //.clickOnTotalExpYears();
}

//@Test
public void loginTest() throws InterruptedException{
	new NaukriFrontPage(driver)	 
	 .clickOnLoginButton()
	 .tapOnEmailTab()
	 .enterEmailOrUserName("itsmailtoyogi@gmail.com")
	 .enterPassword("p7108959")
	 .tapOnLoginButton()
	 .removeHelpOverlay()
	 .tapToOpenleftHandMenu()
	 .tapOnSetting()
	 .waitForHomeSettingPageAppear()
	 .tapOnLogOut()
	 .logoutPopupYes();
	  Thread.sleep(10000L);
}


@Test
public void EditProfileTest() throws InterruptedException{
	new NaukriFrontPage(driver)	 
	 .clickOnLoginButton()
	 .tapOnEmailTab()
	 .enterEmailOrUserName("itsmailtoyogi@gmail.com")
	 .enterPassword("p7108959")
	 .tapOnLoginButton()
	 .removeHelpOverlay()
	 .tapOnMyProfile()
	 .waitForProfilePageAppear()
	 
	 
	 
	 
	 .tapToOpenleftHandMenu()
	 .tapOnSetting()
	 .waitForHomeSettingPageAppear()
	 .tapOnLogOut()
	 .logoutPopupYes();
	  Thread.sleep(10000L);
}


@AfterMethod(alwaysRun=true)
	public void after(){
		driver.quit();
	}
}
