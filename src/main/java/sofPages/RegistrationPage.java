package sofPages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.yogi.HomePage;

import pageConfig.PageConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage extends PageConfig {
	
	/*private String EMAIL="com.sof.revise:id/userNameEditText";
	private String PASSWORD="com.sof.revise:id/passwordEditText";
	private String RETYPE_PASSWORD="com.sof.revise:id/cnfrmPasswordEditText";
	private String SUBMIT_BUTTON="Submit";
	private String CONFIRMATION_MSG="android:id/message";
	private String OK_BUTTON ="android:id/button1";
	*/
	public RegistrationPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(id="com.sof.revise:id/userNameEditText")
	private MobileElement EMAIL;
	
	@FindBy(id="com.sof.revise:id/passwordEditText")
	private MobileElement PASSWORD;
	
	@FindBy(id="com.sof.revise:id/cnfrmPasswordEditText")
	private MobileElement RETYPE_PASSWORD;
	
	@FindBy(id="com.sof.revise:id/registerSubmitButton")
	private MobileElement SUBMIT_BUTTON;
	
	@FindBy(id="android:id/message")
	private MobileElement CONFIRMATION_MSG;
	
	@FindBy(id="android:id/button1")
	private MobileElement OK_BUTTON;


	public RegistrationPage enterEmail(String email){
		waitUntil(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON),20);
		EMAIL.sendKeys(email);
		 driver.hideKeyboard();
		 return this;
	}
	
	
	public RegistrationPage enterPassword(String password){
		PASSWORD.sendKeys(password);
		// driver.hideKeyboard();
		 return this;
	}
	
	public RegistrationPage enterConfirmPassword(String RetypePassword) throws InterruptedException{
		RETYPE_PASSWORD.sendKeys(RetypePassword);
		// driver.hideKeyboard();
		 return this;
	}
	
	public RegistrationPage submitButton(){
		driver.tap(1, SUBMIT_BUTTON, 1);
		return this;
	}
	
	public String confirmationMsg(){
		return CONFIRMATION_MSG.getText();
	}
	
	public HomePage confirmationBoxOK(){
		driver.tap(1, OK_BUTTON, 1);
		return new HomePage(driver);
	}
	
/*public void login(String email,String password){
		
		enterEmail(email);
		enterPassword(password);
		submitButton();
		
		
	}
*/
}
