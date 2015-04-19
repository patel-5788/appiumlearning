package sofPages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageConfig.PageConfig;


public class SubmitTestPage extends PageConfig{
	
	
	@FindBy(name="End Test")
	private MobileElement END_TEST;
	
	@FindBy(name="Ok")
	private MobileElement SECOND_OK;
	
	
	public SubmitTestPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public SubmitTestPage endTest(){
		
		driver.scrollToExact("10");
		driver.scrollToExact("1");		
		driver.tap(1, END_TEST, 1);
		return this;
	}
	
	public SubmitTestPage testEndConfirmatio(String action){
		driver.tap(1, driver.findElementByName(action), 1);
		return this;
	}
   
	public TestResultPage secondEndTestConfirmation(){
		driver.tap(1, SECOND_OK, 1);
		return new TestResultPage(driver);
	}
	
}