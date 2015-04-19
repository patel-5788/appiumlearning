package nakriPages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageConfig.PageConfig;

public class NaukriMyProfilePage extends PageConfig{

	public NaukriMyProfilePage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	
@AndroidFindBy(id="naukriApp.appModules.login:id/header")
	private AndroidElement profilePageTitle;
	
public  NaukriMyProfilePage  waitForProfilePageAppear(){
		 waitUntil(ExpectedConditions.visibilityOf(profilePageTitle), 10);
		return this;		 
	 }

}
