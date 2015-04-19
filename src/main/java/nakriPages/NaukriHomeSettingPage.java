package nakriPages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageConfig.PageConfig;

public class NaukriHomeSettingPage extends PageConfig{

	public NaukriHomeSettingPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/header")
	private AndroidElement settingPageTitle;
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/logout_textview")
	private AndroidElement logOut;
	
	@AndroidFindBy(name="Yes")
	private AndroidElement logoutPopupYes;
	
	@AndroidFindBy(name="Cancel")
	private AndroidElement logoutPopupCancel;
	
	//naukriApp.appModules.login:id/exit_textview
	
	public NaukriHomeSettingPage waitForHomeSettingPageAppear(){
		 waitUntil(ExpectedConditions.visibilityOf(settingPageTitle), 10);
			return this;	
	}
	
	public NaukriHomeSettingPage tapOnLogOut(){
		 driver.tap(1, logOut, 1);
			return this;	
	}
	
	public NaukriFrontPage logoutPopupYes(){
		 driver.tap(1, logoutPopupYes, 1);
		 return new NaukriFrontPage(driver);	
	}
	
	public NaukriHomeSettingPage logoutPopupCancel(){
		 driver.tap(1, logoutPopupCancel, 1);
			return this;	
	}
	
}
