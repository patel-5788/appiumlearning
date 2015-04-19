package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class LoginPage extends PageConfig{
	
	//private AndroidDriver driver;
	
	@AndroidFindBy(name="New User? Please register first.")
	private AndroidElement REGISTER_LINK;
	
	@AndroidFindBy(id="com.sof.revise:id/userNameEditText")
	private AndroidElement EMAIL;
	
	@AndroidFindBy(id="com.sof.revise:id/passwordEditText")
	private AndroidElement PASSWORD;
	
	@AndroidFindBy(name="Submit")
	private AndroidElement SUBMIT_BUTTON;

	
	public LoginPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public RegistrationPage registrationLink(){
		driver.tap(1, REGISTER_LINK, 1);	
		return new RegistrationPage(driver);
	}
	
	public LoginPage enterEmail(String email){
		waitUntil(ExpectedConditions.elementToBeClickable(EMAIL),20);
		//EMAIL.clear();
		EMAIL.sendKeys(email);
		// driver.hideKeyboard();
		 return this;
	}
	
	
	public LoginPage enterPassword(String password){
		waitUntil(ExpectedConditions.elementToBeClickable(PASSWORD),20);
		//EMAIL.click();
		PASSWORD.sendKeys(password);
		//driver.hideKeyboard();
		 return this;
		
	}
	
	public SOFHomePage submitButton(){
		driver.tap(1, SUBMIT_BUTTON, 1);
		return new SOFHomePage(driver);
		
	}
		
		
}
