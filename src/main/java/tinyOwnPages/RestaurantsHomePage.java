package tinyOwnPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class RestaurantsHomePage {
public AndroidDriver driver;

	
	public RestaurantsHomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[1]//android.widget.RelativeLayout//android.widget.TextView")
	private AndroidElement TOP_TITLE_MENU;
	
	public void getMenuTitle() throws InterruptedException{
		Thread.sleep(15000L);
		
		for(int i=0;i<=4;i++){
			
			WebElement menu = driver.findElementByXPath("//android.widget.RelativeLayout[1]//android.widget.RelativeLayout//android.widget.TextView['"+i+"']");
		String status =menu.getAttribute("selected");
		if(status.equalsIgnoreCase("true")){
			System.out.println(TOP_TITLE_MENU.getText());
			driver.swipe(676, 350, 21, 350, 1000);
		}
		}
		/*driver.swipe(676, 350, 21, 350, 1000);
		driver.swipe(676, 350, 21, 350, 1000);
		driver.swipe(676, 350, 21, 350, 1000);*/
	}
	
	
}
