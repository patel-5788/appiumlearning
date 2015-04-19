package sofPages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class TestResultPage extends PageConfig{
	
	private String CORRECT="Correct";
	private String WRONG="Wrong";
	private String SKIP="UnAttempted";
			
public TestResultPage(AndroidDriver driver) {
	super(driver);
	//waitUntil(ExpectedConditions.elementToBeClickable(START_TEST),20);
	}

public void filterQuestions(String filter){
	try{
		//tapOnElementByName(filter, 1, 1);
	}catch(Exception e){
		if(filter.equals(CORRECT)){
			//tapOnElement("com.sof.revise:id/radiobutton2", 1, 1);
		}
		if(filter.equals(WRONG)){
			//tapOnElement("com.sof.revise:id/radiobutton3", 1, 1);
		}
		if(filter.equals(SKIP)){
		}
			//tapOnElement("com.sof.revise:id/radiobutton4", 1, 1);
		}
		
	}
	
}
