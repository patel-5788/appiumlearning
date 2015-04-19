package sofPages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageConfig.PageConfig;

public class TestPage extends PageConfig{
	
	
	
	
	@FindBy(id="com.sof.revise:id/nextButton")
	private MobileElement QUESTION_NUMBER;
	
	@FindBy(id="com.sof.revise:id/noOfQuestionTextView")
	private MobileElement NEXT_BUTTON;
	
	public TestPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	


	public String questionNumber(){
		String  questionNumber= QUESTION_NUMBER.getText();
		 return questionNumber;
	}
	
	public TestPage ChooseAnserOption(String option){
		driver.tap(1, driver.findElementByName(option), 1);
		return this;
	}
	
	public TestPage nextButton(){		
		driver.tap(1, NEXT_BUTTON, 1);
		return this;
	}
	
	public SubmitTestPage runTest(String Option){
		
		
		//List<WebElement> buttons=dr.findElementsById("com.sof.revise:id/nextButton");
		
		while(isElementDisplayedID("com.sof.revise:id/nextButton"))
		 {
			ChooseAnserOption(Option);
			nextButton();
					
		 }
		
		return new SubmitTestPage(driver);
		}
}
