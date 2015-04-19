package nakriPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageConfig.PageConfig;

public class NaukriFrontPage extends PageConfig{
public NaukriFrontPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/textViewRegisterText")
	private AndroidElement registerButton;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/loginOrReg")
	private AndroidElement loginButton;
	
	@AndroidFindBy(name="Search Jobs")
	private AndroidElement searchJobsButton;

	public NaukriRegistrationPersonalInfoPage clickOnRegisterButton(){
		waitUntil(ExpectedConditions.visibilityOf(registerButton), 20);
		registerButton.click();
	    return new NaukriRegistrationPersonalInfoPage(driver);
	}
	
	public NaukriLoginPage clickOnLoginButton(){
		waitUntil(ExpectedConditions.visibilityOf(loginButton), 20);
		loginButton.click();
	    return new NaukriLoginPage(driver);
	}
	
}
