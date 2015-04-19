package sofPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageConfig.PageConfig;

public class BookListPage extends PageConfig{
		
	@AndroidFindBy(id="android:id/text1")
	private AndroidElement CLASS_DROPDOWN;
	
	@AndroidFindBy(name="Buy")
	private AndroidElement BUY_BUTTON;
	
	@AndroidFindBy(id="com.sof.revise:id/bookName")
	private AndroidElement BOOK_NAME;
	
	
	public BookListPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/*public String verifySelectedClass(){
		//return returnText(CLASS_DROPDOWN);
	}
	*/
	public MyCartPage buyButton(){
		waitUntil(ExpectedConditions.elementToBeClickable(BUY_BUTTON),20);
		driver.tap(1, BUY_BUTTON, 1);
		return new MyCartPage(driver);
	}
	
	/*public void selectClassPopup(String classname){
		tapOnElement("android:id/text1", 1, 1);
		tapOnElementByName(classname, 1, 1);
		tapOnElementByName("OK", 1, 1);
		
	}
	
	public void openTestButton(){
		
		
		boolean abc=  IsDisplayedOnPage("Open");
		if(abc==false){
			System.out.println("inside test");
			downloadFreeBook();
			dr.findElementByName("Class 1").click();	
			tapOnElementByName("Class 2", 1, 1);
			//Therad.sleep(10000L);
			dr.findElementByName("Class 2").click();
			dr.findElementByName("Class 2").click();
		}
		tapOnElementByName("Open", 1, 1);
	}
	
	
	
	public String bookName(){
		 return returnText(BOOK_NAME);
	}
	
	public void downloadFreeBook() {
		tapOnElementByName("Free", 1, 1);
		tapOnElementByName("Yes", 1, 1);
		
		
*/	

}

