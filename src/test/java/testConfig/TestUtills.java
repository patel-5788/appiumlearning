package testConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestUtills {


	public AndroidDriver driver;
	public TestUtills(AndroidDriver driver) {
		this.driver=driver;
	}
	
	void swipeUpElement(MobileElement element, int duration){
	   // int topY = element.getLocation().getY();
	   // int bottomY = topY + element.getSize().getHeight();
	   // int centerX = element.getLocation().getX() + (element.getSize().getWidth()/2);
	   // driver.swipe(centerX, bottomY, centerX, topY, duration);
	}

}
