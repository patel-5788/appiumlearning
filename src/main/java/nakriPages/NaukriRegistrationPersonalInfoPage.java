package nakriPages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sun.xml.internal.bind.v2.runtime.Name;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageConfig.PageConfig;

public class NaukriRegistrationPersonalInfoPage extends PageConfig{

	public NaukriRegistrationPersonalInfoPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(name="Registration")
	private AndroidElement registrationPageTitle;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.FrameLayout\").index(0).instance(0)"
			+ ".childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(1)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(1)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.widget.EditText\")).instance(0);")
	private AndroidElement fullNameElement;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.FrameLayout\").index(0).instance(0)"
			+ ".childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(1)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(4)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.widget.EditText\")).instance(0);")
	private AndroidElement mobileNumber;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.FrameLayout\").index(0).instance(0)"
			+ ".childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(1)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(6)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.widget.EditText\")).instance(0);")
	private AndroidElement emailAddress;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.FrameLayout\").index(0).instance(0)"
			+ ".childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(1)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(8)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.widget.EditText\")).instance(0);")
	private AndroidElement passwordElement;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.FrameLayout\").index(0).instance(0)"
			+ ".childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.webkit.WebView\").index(0)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(1)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.view.View\").index(10)).instance(0)."
			+ "childSelector(new UiSelector().className(\"android.widget.EditText\")).instance(0);")
	private AndroidElement confirmPasswordElement;
	
	@AndroidFindBy(id="Your Full Name")
	private AndroidElement test1; 
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/iv_cancelHeader")
	private AndroidElement cancelButton;
	
	@AndroidFindBy(accessibility="Next")
	private AndroidElement nextButton;
	
	
	
	 public  NaukriRegistrationPersonalInfoPage  waitForRegistrationPageAppear(){
		 waitUntil(ExpectedConditions.visibilityOf(registrationPageTitle), 20);
		return this;		 
	 }
	 
	 public  NaukriRegistrationPersonalInfoPage  enterTextInUsername(String fullName){
		 //switchToWebView();
		 waitUntil(ExpectedConditions.visibilityOf(fullNameElement), 10);
		 fullNameElement.clear();
		 fullNameElement.sendKeys(fullName);
		 driver.hideKeyboard();
		return this;		 
	 }
	 
	 public  NaukriRegistrationPersonalInfoPage  enterTextInMobileNumebr(String mobileNumebr){
		 mobileNumber.sendKeys(mobileNumebr);
		 driver.hideKeyboard();
		return this;		 
	 }
	 
	 public  NaukriRegistrationPersonalInfoPage  enterTextInEmailAddess(String email){
		 emailAddress.sendKeys(email);
		 driver.hideKeyboard();
		return this;		 
	 }
	 
	 public  NaukriRegistrationPersonalInfoPage  enterTextInPassword(String password){
		 passwordElement.sendKeys(password);
		 driver.hideKeyboard();
		return this;		 
	 }
	 
	 public  NaukriRegistrationPersonalInfoPage  enterTextInConfirmPassword(String confirmPassword){
		 confirmPasswordElement.sendKeys(confirmPassword);
		 driver.hideKeyboard();
		return this;		 
	 }
	 
	 public  NaukriRegistrationExperienceInfoPage clcikOnNextButton(){
		 nextButton.click();;
		return new NaukriRegistrationExperienceInfoPage(driver);
	 }
	 
	 
	 
	 
	 
}
