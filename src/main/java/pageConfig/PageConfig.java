package pageConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import nakriPages.NaukriLeftMenuPage;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageConfig{
	
	public AndroidDriver driver;
	
	public PageConfig(AndroidDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="naukriApp.appModules.login:id/hamburger")
	private AndroidElement openLeftHandMenu;
	
	
	
	
	public  NaukriLeftMenuPage  tapToOpenleftHandMenu(){
		driver.tap(1, openLeftHandMenu, 1);	
		return new NaukriLeftMenuPage(driver);
	 }
	
	
	public boolean isElementDisplayedID(String ID) {
		  List<WebElement> weList = driver.findElementsById(ID);
		  if (weList.size() != 0) {
		   return true;
		  } else {
		   return false;
		  }
		 }
	
	public boolean isElementNameDisplayed(String name) {
		  List<WebElement> weList = driver.findElementsByName(name);
		  if (weList.size() != 0) {
		   return true;
		  } else {
		   return false;
		  }
		 }
	
	
	public void switchToWebView(){
		for (String contextName : driver.getContextHandles()) {
		    System.out.println(contextName);
		    if (contextName.contains("WEBVIEW")){
		    	driver.context(contextName);
		    	System.out.println("Switched to " + contextName);
		    }
		}
	}
	
	protected void waitUntil(ExpectedCondition<?> expectedCondition, int timeoutSeconds) {
    new WebDriverWait(driver, timeoutSeconds).until(expectedCondition);
     }
	
	
	public void swipeLeft(){
	Dimension size = driver.manage().window().getSize();
	int startx = (int) (size.width * 0.8);
	int endx = (int) (size.width * 0.20);
	int starty = size.height / 2;
	driver.swipe(startx, starty, endx, starty, 1000);
	}
	public void swipeRight(){
	//appiumDriver.context("NATIVE_APP");
	Dimension size = driver.manage().window().getSize();
	int endx = (int) (size.width * 0.8);
	int startx = (int) (size.width * 0.20);
	int starty = size.height / 2;
	driver.swipe(startx, starty, endx, starty, 1000); 
	}
	
	
	public void horizontalSwipeUpToElement( AndroidElement startElement,AndroidElement endElement, int duration){
	    int startX = endElement.getLocation().getX();
	    int endX =startElement.getLocation().getX();
	    int StartY = endElement.getLocation().getY();
	    int endY = startElement.getLocation().getX();
	    driver.swipe(startX, StartY, endX, endY, duration);
	}
	
	
	/**public MobileElement scrollTo(String text) {
	    String uiScrollables = AndroidDriver.UiScrollable("new UiSelector().textContains(\"" + text + "\")");
	    return (MobileElement) driver.findElementByAndroidUIAutomator(uiScrollables);
	    		//findElementByAndroidUIAutomator(uiScrollables);
	}*/
	
	public void scrollToElement(MobileElement el1,MobileElement el2){
		TouchAction touchaction = new TouchAction(driver);
		touchaction.press(el1).moveTo(el2).release().perform();
		//touchaction.perform();
	}
	
	public void hideKeyboard(){
		//if(driver.)
	}
	

}
