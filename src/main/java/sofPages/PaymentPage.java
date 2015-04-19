package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class PaymentPage extends PageConfig{
	
	@AndroidFindBy(id="com.sof.revise:id/totalPaymentTxt")
	private AndroidElement TOTAL_PAYMENT;
	
	@AndroidFindBy(name="Make Payment")
	private AndroidElement MAKE_PAYMENT;
	
	public PaymentPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/*public boolean verifyPageTitle(){
		return isTestPresent("Payments");
	}
	
	public String totalAmount(){
		return returnText(TOTAL_PAYMENT);
	}*/
	
	public PaymentOptionPage makePayment(){
		waitUntil(ExpectedConditions.elementToBeClickable(MAKE_PAYMENT),20);
		driver.tap(1, MAKE_PAYMENT, 1);
		return new PaymentOptionPage(driver);
	}

}
