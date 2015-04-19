package nakriPages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageConfig.PageConfig;

public class NaukriLoginPage extends PageConfig {

	public NaukriLoginPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name="Login")
	private AndroidElement loginPageTitle;
	
	@AndroidFindBy(name="Email")
	private AndroidElement loginByEmail;
	
	@AndroidFindBy(name="Username")
	private AndroidElement loginByUsername;
	                 
	@AndroidFindBy(id="naukriApp.appModules.login:id/et_email")
	private AndroidElement loginTextBox;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/et_password")
	private AndroidElement passwordTextBox;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/bt_login")
	private AndroidElement loginButton;
	
	@AndroidFindBy(id="	naukriApp.appModules.login:id/tv_forgotpass")
	private AndroidElement forgetPasswordLink;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/bt_register")
	private AndroidElement registerButton;
	
	
	 public  NaukriLoginPage  tapOnEmailTab(){
		 waitUntil(ExpectedConditions.elementToBeClickable(loginByEmail), 20);
		 driver.tap(1, loginByEmail, 1);
		return this;		 
	 }
	 
	 public  NaukriLoginPage  clickOnUsernameTab(){
		 waitUntil(ExpectedConditions.elementToBeClickable(loginByUsername), 20);
		 driver.tap(1, loginByUsername, 1);
		return this;		 
	 }
	 
	 public  NaukriLoginPage  enterEmailOrUserName(String emailOrUsername){
		 waitUntil(ExpectedConditions.elementToBeClickable(loginTextBox), 20);
		 loginTextBox.sendKeys(emailOrUsername);
		return this;		 
	 }
	 
	 public  NaukriLoginPage  enterPassword(String password){
		 waitUntil(ExpectedConditions.elementToBeClickable(passwordTextBox), 20);
		 passwordTextBox.sendKeys(password);
		return this;		 
	 }
	 
	 public  NaukriHomePage  tapOnLoginButton(){
		 waitUntil(ExpectedConditions.elementToBeClickable(loginButton), 20);
		 loginButton.click();
		return new NaukriHomePage(driver);		 
	 }
	 
	 public  NaukriForgetPasswordPage  tapOnForgetPasswordLink(){
		 waitUntil(ExpectedConditions.elementToBeClickable(forgetPasswordLink), 20);
		 driver.tap(1, forgetPasswordLink, 1);
		return new NaukriForgetPasswordPage(driver);		 
	 }
	 
	 public  NaukriRegistrationPersonalInfoPage  tapOnRegisterButton(){
		 waitUntil(ExpectedConditions.elementToBeClickable(registerButton), 20);
		 driver.tap(1, registerButton, 1);
		return new NaukriRegistrationPersonalInfoPage(driver);		 
	 }
	 
}
