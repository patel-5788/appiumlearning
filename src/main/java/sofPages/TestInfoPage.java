package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class TestInfoPage extends PageConfig{
		
	@FindBy(name="Start Test")
	private AndroidElement START_TEST;
	
	@FindBy(id="com.sof.revise:id/checcckall")
	private AndroidElement ELEMENT1;
	
	@FindBy(id="com.sof.revise:id/custum_test_start")
	private AndroidElement ELEMENT2;
	
	public TestInfoPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	public TestPage  startTest(){
		waitUntil(ExpectedConditions.elementToBeClickable(START_TEST),20);
		driver.tap(1, START_TEST, 1);
		return new TestPage(driver);
		
	}
	
	public void  selectAll(){
		driver.tap(1, ELEMENT1, 1);
	}
	
	public void startTestCustom(){
		//tapOnElement("com.sof.revise:id/custum_test_start", 1, 1);
	}

}
