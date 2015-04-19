package sofPages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pageConfig.PageConfig;

public class FillPaymentDetailsPage extends PageConfig{
	
	@AndroidFindBy(accessibility="Debit Card Link")
	private AndroidElement DEBIT_CARD_LINK;
	
	@AndroidFindBy(accessibility="Credit Card")
	private AndroidElement CREDIT_CARD_LINK;
	
	@AndroidFindBy(accessibility="Netbanking")
	private AndroidElement NETBANKING_LINK;
	
	@AndroidFindBy(className="android.widget.EditText")
	private AndroidElement ENTER_CARD_NUMBER;
	
	@AndroidFindBy(accessibility="MM")
	private AndroidElement MONTH;
	
	@AndroidFindBy(accessibility="YY")
	private AndroidElement YEAR;
	
	@AndroidFindBy(className="android.widget.EditText")
	private List<WebElement> CCV;
	
	@AndroidFindBy(accessibility="Pay now")
	private AndroidElement PAY_NOW;
	
	@AndroidFindBy(accessibility="Cancel")
	private AndroidElement CANCEL;
	
	@AndroidFindBy(accessibility="Paytm Secure Online Payment Gateway")
	private AndroidElement PAGE;
	
	@AndroidFindBy(accessibility="Debit Card")
	private MobileElement DEBIT_CARD;
	
	@AndroidFindBy(accessibility="EXPIRY DATE")
	private MobileElement EXPIRY_DATE_LABEL;
	
	
	
	
	
	
	public FillPaymentDetailsPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public FillPaymentDetailsPage enterCardNumber(){
		waitUntil(ExpectedConditions.elementToBeClickable(DEBIT_CARD),20);
		ENTER_CARD_NUMBER.sendKeys("4854460214407752");
		driver.hideKeyboard();
		//driver.scrollTo(CANCEL.getText());
		//scrollToElement(CANCEL,ENTER_CARD_NUMBER);
		return this;
	}
	
	public FillPaymentDetailsPage expireYear(String expireYear){
		//PAGE.swipe(SwipeElementDirection.DOWN,1000);
		waitUntil(ExpectedConditions.elementToBeClickable(YEAR),20);
		//driver.tap(1, YEAR, 1);
		driver.findElementByAccessibilityId("YY").click();
		//driver.scrollTo("2025");
		//driver.scrollToExact(expireYear);
		driver.findElementByName(expireYear).click();
		scrollToElement(ENTER_CARD_NUMBER,DEBIT_CARD);

			
		return this;
	}
	
	public FillPaymentDetailsPage expireMonth(String expiremonth){
		waitUntil(ExpectedConditions.elementToBeClickable(MONTH),20);
		//driver.tap(1, MONTH, 1);
		driver.findElementByAccessibilityId("MM").click();
		//driver.scrollTo("11");
		//driver.scrollToExact(expiremonth);
		driver.findElementByName(expiremonth).click();		
		return this;
	}
	
	public FillPaymentDetailsPage enterCCV(){
		waitUntil(ExpectedConditions.visibilityOfAllElements(CCV),20);
		CCV.get(1).sendKeys("333");
		driver.hideKeyboard();
		return this;
		
	}
	
	public FillPaymentDetailsPage payNow(){
		waitUntil(ExpectedConditions.elementToBeClickable(PAY_NOW),20);
		driver.tap(1, PAY_NOW, 1);
		
		
		return this;		
	}
	
	

	/*public void payByDebitCard(String dCardNumber,String expirymonth,String Expiryyear,String CCV) throws InterruptedException{
		dr.findElementByAccessibilityId(DEBIT_CARD_LINK).click();
		enterTextInTextBoxByClass(ENTER_CARD_NUMBER, "4854460214407752");
		dr.hideKeyboard();
		dr.findElementByAccessibilityId("MM").click();
		dr.scrollToExact("11");
		dr.scrollToExact("01");
		driver.findElementByName("01").click();
		dr.findElementByAccessibilityId("YY").click();
		//tapOnElementByName("2018", 1, 1);
		dr.scrollToExact("2030");
		dr.scrollToExact("2018");
		dr.findElementByName("2018").click();
		List<WebElement>textboxes= dr.findElementsByClassName("android.widget.EditText");
		System.out.println("number of Txtboxes is="+textboxes.size());
			textboxes.get(1).sendKeys("337");
			dr.hideKeyboard();
		
	}
	
	public void proceedtoPay(){
		dr.findElementByAccessibilityId("Proceed Securely").click();
				
	}
	
	public String wrongCardNumError(){
		return dr.findElementByAccessibilityId("Invalid card number").getText();
	}
	
	*/
	public SOFHomePage verfiyCancel() throws InterruptedException{
		
		waitUntil(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Payment Mode")),20);
		Assert.assertTrue(driver.getPageSource().contains("Cancel Request by Customer"));
		driver.navigate().back();
		Thread.sleep(2000L);
		driver.navigate().back();
		Thread.sleep(2000L);
		return new SOFHomePage(driver);	}
	
	public FillPaymentDetailsPage cancel(){
		scrollToElement(EXPIRY_DATE_LABEL,CREDIT_CARD_LINK);//ENTER_CARD_NUMBER	
		waitUntil(ExpectedConditions.elementToBeClickable(CANCEL),20);
		driver.tap(1, CANCEL, 1);
		return this;
	}

}
