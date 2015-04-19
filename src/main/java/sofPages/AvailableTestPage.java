package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import pageConfig.PageConfig;

public class AvailableTestPage extends PageConfig{
	
	
	@AndroidFindBy(id="com.sof.revise:id/list_item_title")
	private AndroidElement TEST_NAME;
	
	
	public AvailableTestPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void selectTest(){
		driver.tap(1, TEST_NAME, 1);
	}
}
