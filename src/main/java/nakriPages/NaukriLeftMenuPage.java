package nakriPages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageConfig.PageConfig;

public class NaukriLeftMenuPage extends PageConfig{

	public NaukriLeftMenuPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(name="Settings")
	private AndroidElement setting;
	
	
	public  NaukriHomeSettingPage  tapOnSetting(){
		driver.tap(1,setting, 1);
		return new NaukriHomeSettingPage(driver);		 
	 }

}
