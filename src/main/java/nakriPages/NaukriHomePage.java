package nakriPages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageConfig.PageConfig;

public class NaukriHomePage extends PageConfig{

	public NaukriHomePage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/mnjUserPhoto")
	private AndroidElement profileImage;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/hamburger")
	private AndroidElement openLeftHandMenu;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/body_bottom")
	private AndroidElement bodyBottom;
	
	
	@AndroidFindBy(name="Settings")
	private AndroidElement setting;
	
	@AndroidFindBy(name="Profile Completion")
	private AndroidElement profileCompletion;
	
	@FindBy(id="naukriApp.appModules.login:id/contactDetailsFlagged")
	private MobileElement employmentDetails;
	
	
	public  NaukriHomePage  removeHelpOverlay(){
		 waitUntil(ExpectedConditions.elementToBeClickable(bodyBottom), 20);
		 driver.tap(2, bodyBottom, 2);
		 
		MobileElement el = (MobileElement) driver.findElementById("naukriApp.appModules.login:id/resumeFlagged");
		MobileElement el2 = (MobileElement) driver.findElementById("naukriApp.appModules.login:id/contactDetailsFlagged");
		el.swipe(SwipeElementDirection.LEFT,2000);
		el2.swipe(SwipeElementDirection.LEFT,2000);
		return this;		 
	 }
	
public NaukriMyProfilePage tapOnMyProfile(){
		driver.tap(1, profileImage, 1);
		return new NaukriMyProfilePage(driver);
	}

}
