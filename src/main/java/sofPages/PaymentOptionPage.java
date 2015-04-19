package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class PaymentOptionPage extends PageConfig{
	
	@AndroidFindBy(name="Payment Mode")
	private AndroidElement TITLE;

	@AndroidFindBy(name="Credit Card")
	private AndroidElement CC;
	
	@AndroidFindBy(accessibility="Debit Card")
	private AndroidElement DEBIT_CARD;
	
	@AndroidFindBy(name="Netbanking")
	private AndroidElement NET_BANKING;
	
	@AndroidFindBy(name="Submit")
	private AndroidElement SUBMIT;
	
	public PaymentOptionPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/*public boolean verifyTitle(){		
		return dr.findElementByAccessibilityId(TITLE).isDisplayed();
	}*/
	
	public PaymentOptionPage selectPaymentOption(String paymentmode){		
		waitUntil(ExpectedConditions.elementToBeClickable(DEBIT_CARD),20);
		driver.tap(1, DEBIT_CARD, 1);
		return this;
		
		//tapOnElementByContentDesc(paymentmode);
	}
	
	public FillPaymentDetailsPage submit(){
		waitUntil(ExpectedConditions.elementToBeClickable(SUBMIT),20);
		driver.tap(1, SUBMIT, 1);
		return new FillPaymentDetailsPage(driver);
		
	}

}
