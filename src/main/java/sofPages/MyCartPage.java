package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class MyCartPage extends PageConfig {
		
	@AndroidFindBy(id="com.sof.revise:id/bookNameTxt")
	private AndroidElement BOOK_NAME;
	
	@AndroidFindBy(id="com.sof.revise:id/cancelBookButton")
	private AndroidElement CANCEL_BUTTON;
	
	@AndroidFindBy(id="com.sof.revise:id/priceTxt")
	private AndroidElement PRICE;
	
	@AndroidFindBy(name="Add to Cart")
	private AndroidElement ADD_TO_CART;
	
	@AndroidFindBy(name="Proceed to Payment")
	private AndroidElement PROCEED_PAYMENT_BUTTON;
	
	
	public MyCartPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public void BookName(){
		 //return returnText(BOOK_NAME);
	}
	
	
	public MyCartPage addToCart(){
		waitUntil(ExpectedConditions.elementToBeClickable(ADD_TO_CART),20);
		driver.tap(1, ADD_TO_CART, 1);
		return this;
	
	}
	
	public boolean verifyCart(){
		
		return CANCEL_BUTTON.isDisplayed();
	}
	
	
	public MyCartPage cancelButton(){
		waitUntil(ExpectedConditions.elementToBeClickable(CANCEL_BUTTON),20);
		driver.tap(1, CANCEL_BUTTON, 1);
		return this;
	
	}
	
	public PaymentPage proceedPaymentButton(){		
		waitUntil(ExpectedConditions.elementToBeClickable(PROCEED_PAYMENT_BUTTON),20);
		driver.tap(1, PROCEED_PAYMENT_BUTTON, 1);
		return new PaymentPage(driver);
	}
	
	public void bookPrice(){
		//return returnText(PRICE);
	}

}
