package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FeeCalculatorPage {
public AndroidDriver driver;
	
	public FeeCalculatorPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "gov.mea.psp:id/back")
	@CacheLookup
	private MobileElement BACK_BUTTON;
	
	@AndroidFindBy(id = "gov.mea.psp:id/exit")
	@CacheLookup
	private MobileElement HOME_BUTTON;
	
	
	@AndroidFindBy(id = "gov.mea.psp:id/SpinnerType")
	@CacheLookup
	private MobileElement SERVICE_TYPE;
	
	@AndroidFindBy(name = "Fresh")
	@CacheLookup
	private MobileElement SERVICESTYPE_FRESH;

	@AndroidFindBy(id = "gov.mea.psp:id/SpinnerAge")
	@CacheLookup
	private MobileElement APPLICANT_AGE;
	
	@AndroidFindBy(name = "18 Years  And Above")
	@CacheLookup
	private MobileElement SELECT_APPLICANT_AGE;
	
	
	@AndroidFindBy(id = "gov.mea.psp:id/SpinnerPages")
	@CacheLookup
	private MobileElement BOOKLET_PAGE;
	
	@AndroidFindBy(name = "60 Pages")
	@CacheLookup
	private MobileElement SELCT_PAGES;
	
	@AndroidFindBy(id = "gov.mea.psp:id/SpinnerScheme")
	@CacheLookup
	private MobileElement REQUIRED_SCHEME;
	
	@AndroidFindBy(name = "Normal")
	@CacheLookup
	private MobileElement SELECT_SCHEME;
	
	@AndroidFindBy(id = "gov.mea.psp:id/TextViewFeeAmount")
	@CacheLookup
	private MobileElement NEXT_ARROW;
	
	@AndroidFindBy(id = "gov.mea.psp:id/TextViewFeeAmountResult")
	@CacheLookup
	private MobileElement FEE_AMOUNT;
	
	
	
	
	
	
	public HomePage backButtonFromFeeCalculatorPage(){
		driver.tap(1, BACK_BUTTON, 1);
		return new HomePage(driver);
		}
	public HomePage homeButtonFromFeeCalculatorPage(){
		driver.tap(1, HOME_BUTTON, 1);
		return new HomePage(driver);
		
	}
	
	public FeeCalculatorPage selectTypeOfService(){
		driver.tap(1, SERVICE_TYPE, 1);
		return this;		
	}
	
	public FeeCalculatorPage chooseTypeOfService(){
		driver.tap(1, SERVICESTYPE_FRESH, 1);
		return this;		
	}
	
	public FeeCalculatorPage applicantAge(){
		driver.tap(1, APPLICANT_AGE, 1);
		return this;		
	}
	
	public FeeCalculatorPage selectAge(){
		driver.tap(1, SELECT_APPLICANT_AGE, 1);
		return this;		
	}
	
	public FeeCalculatorPage bookletPage(){
		driver.tap(1, BOOKLET_PAGE, 1);
		return this;		
	}
	
	public FeeCalculatorPage choosePages(){
		driver.tap(1, SELCT_PAGES, 1);
		return this;		
	}
	
	public FeeCalculatorPage schemeName(){
		driver.tap(1, REQUIRED_SCHEME, 1);
		return this;		
	}
	
	public FeeCalculatorPage chooseScheme(){
		driver.tap(1, SELECT_SCHEME, 1);
		return this;		
	}
	
	public FeeCalculatorPage submit(){
		driver.tap(1, NEXT_ARROW, 1);
		return this;		
	}
	
	public String totalFee(){
		return FEE_AMOUNT.getText();
		
	}
   public FeeCalculatorPage AssertFeeCalculation(String ExpectedFee){
	   Assert.assertEquals(FEE_AMOUNT.getText(), ExpectedFee);
	   return this;
	   
   }
}
