package com.yogi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class MainPage{
	
	AndroidDriver driver;
	
	public MainPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
@AndroidFindBy(id = "android:id/action_bar_title")
MobileElement LHM;
	
public void tapOnLHM(){
	driver.tap(1, LHM, 1);
	//driver.findElementByName("Settle Up").click();
	
}

}

