package tinyOwnPages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class MainPage {
public AndroidDriver driver;
	
	public MainPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement LOCATION_EDITBOX;
	//id="com.flutterbee.tinyowl:id/actionview_location_name"
	//android.widget.EditText
	@AndroidFindBy(id="com.flutterbee.tinyowl:id/locality_title")
	private MobileElement SELECT_LOCATION;
	



public MainPage editLocation(String location) throws InterruptedException{
	/*LOCATION_EDITBOX.clear();
	LOCATION_EDITBOX.sendKeys(location);*/
	
	//driver.findElementById("com.flutterbee.tinyowl:id/actionview_location_name").clear();
	driver.findElementById("com.flutterbee.tinyowl:id/actionview_location_name").click();
	driver.sendKeyEvent(29);driver.sendKeyEvent(42);driver.sendKeyEvent(32);driver.sendKeyEvent(36);
	//driver.wait(5000L);	
	return this;
}


public RestaurantsListPage selectFirstLocation(){
	SELECT_LOCATION.click();
	return new RestaurantsListPage(driver);
}
}