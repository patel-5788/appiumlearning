package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageConfig.PageConfig;

public class SOFHomePage extends PageConfig{
	//private AndroidDriver driver;	
	
	@AndroidFindBy(id="com.sof.revise:id/loginButton")
	private AndroidElement LOGIN_BUTTON;
	
	@AndroidFindBy(id="com.sof.revise:id/logoutButton")
	private AndroidElement LOGOUT_BUTTON;
	
	@AndroidFindBy(name="Logout")
	private AndroidElement LOGOUT_CONFRM_BUTTON;
	
	@AndroidFindBy(name="Cancel")
	private AndroidElement LOGOUT_CANCEL_BUTTON;
	
	@AndroidFindBy(id="com.sof.revise:id/gridImageView")
	private List<WebElement> GRID;	
	
	@AndroidFindBy(name="Select Class")
	private AndroidElement SELECT_CLASS;
	
	@AndroidFindBy(name="OK")
	private AndroidElement OK_BUTTON;
	
	public SOFHomePage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	} 

	public LoginPage loginButton(){
		waitUntil(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON),20);
		driver.tap(1, LOGIN_BUTTON, 1);
		return new LoginPage(driver);
	}
	
	public SOFHomePage logoutButton(){
		waitUntil(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON),20);
		driver.tap(1, LOGOUT_BUTTON, 1);
		return this;
	}
	
	public SOFHomePage logoutConfirmation(){
		waitUntil(ExpectedConditions.elementToBeClickable(LOGOUT_CONFRM_BUTTON),20);
		driver.tap(1, LOGOUT_CONFRM_BUTTON, 1);
		return this;
	}
	
	public SOFHomePage logoutCancel(){
		waitUntil(ExpectedConditions.elementToBeClickable(LOGOUT_CANCEL_BUTTON),20);
		driver.tap(1, LOGOUT_CANCEL_BUTTON, 1);	
		return this;
	}
	
	public SOFHomePage logout(){
		logoutButton();
		logoutConfirmation();
		return this;
				
	}
	
	public SOFHomePage gridMenu(int MenuItem){
		waitUntil(ExpectedConditions.visibilityOfAllElements(GRID),20);
		
		driver.tap(1,GRID.get(MenuItem), 1);
		return this;
	}
	
	public BookListPage selectClassPopup(String classname){
		//SELECT_CLASS
		driver.tap(1, SELECT_CLASS, 1);
		//driver.scrollToExact("Class 8");
		//driver.scrollToExact("Class 1");
		AndroidElement classname1 =(AndroidElement) driver.findElementByName(classname);
		driver.tap(1, classname1, 1);
		driver.tap(1, OK_BUTTON, 1);
		return new BookListPage(driver);
	}
	
}
