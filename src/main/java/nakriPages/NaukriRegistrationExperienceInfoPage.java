package nakriPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class NaukriRegistrationExperienceInfoPage extends PageConfig {

	public NaukriRegistrationExperienceInfoPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(accessibility="Experience")
	private AndroidElement pageTitle;
	
	@AndroidFindBy(accessibility="Years")
	private AndroidElement expInYear;
	
	
	 public  NaukriRegistrationExperienceInfoPage  waitForRegistrationPageAppear(){
		 waitUntil(ExpectedConditions.visibilityOf(pageTitle), 10);
		return this;		 
	 }
	 
	 public  NaukriRegistrationExperienceInfoPage  clickOnTotalExpYears(){
		 waitForRegistrationPageAppear();
		 expInYear.click();
		return this;		 
	 }
	
}
