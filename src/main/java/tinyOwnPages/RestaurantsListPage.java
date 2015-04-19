package tinyOwnPages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class RestaurantsListPage {
	public AndroidDriver driver;
	
	public RestaurantsListPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(id="com.flutterbee.tinyowl:id/global_search_hint_text")
	private AndroidElement RESTORENT_SEARCH_BOX;
	
	@AndroidFindBy(id="com.flutterbee.tinyowl:id/item_query_text")
	private MobileElement RESTORENT_SEARCH_BOX_MAIN;
	
	
	@AndroidFindBy(id="com.flutterbee.tinyowl:id/restaurant_name")
	private MobileElement RESTORENT_LIST;
	
	@AndroidFindBy(id="com.flutterbee.tinyowl:id/restaurant_name")
	private MobileElement FIRST_SEARCH_RESULT;
	
	
	
	public RestaurantsHomePage selectRestaurent(String RestoName) throws InterruptedException{
		driver.scrollTo(RestoName).click();		
		return new RestaurantsHomePage(driver);
		
	}
	
	public RestaurantsHomePage ssearrchRestaurent(String RestoName) throws InterruptedException{
		//RESTORENT_SEARCH_BOX.clear();
		RESTORENT_SEARCH_BOX.click();
		//RESTORENT_SEARCH_BOX_MAIN.setValue(RestoName);
		RESTORENT_SEARCH_BOX_MAIN.sendKeys(RestoName);	
		driver.sendKeyEvent(62);
		//driver.sendKeyEvent(KeyCharacterCombinationBuilder.create().character(RestoName));
		FIRST_SEARCH_RESULT.click();
		
		return new RestaurantsHomePage(driver);
		
	}
}
