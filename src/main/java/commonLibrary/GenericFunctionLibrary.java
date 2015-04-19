package commonLibrary;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class GenericFunctionLibrary {

	
	public AndroidDriver driver;

	public GenericFunctionLibrary(AndroidDriver driver){
		this.driver=driver;
	}
public void swipe(double startX,double startY,double endX,double endY,double duration){
	JavascriptExecutor js = (JavascriptExecutor) driver;

	HashMap<String, Double> swipeObject = new HashMap<String, Double>();

	swipeObject.put("startX", startX);

	swipeObject.put("startY", startY);

	swipeObject.put("endX",endX );

	swipeObject.put("endY", endY);

	swipeObject.put("duration", duration);

	js.executeScript("mobile: swipe", swipeObject);
}


public void swipeElement(WebElement el) {
	  String orientation = driver.getOrientation().value();

	  // get the X coordinate of the upper left corner of the element, then add the element's width to get the rightmost X value of the element
	  int leftX = el.getLocation().getX();
	  int rightX = leftX + el.getSize().getWidth();

	  // get the Y coordinate of the upper left corner of the element, then subtract the height to get the lowest Y value of the element
	  int upperY = el.getLocation().getY();
	  int lowerY = upperY - el.getSize().getHeight();
	  int middleY = (upperY - lowerY) / 2;

	  if (orientation.equals("portrait")) {
	    // Swipe from just inside the left-middle to just inside the right-middle of the element over 500ms
	      driver.swipe(leftX - 5, middleY, rightX + 5, middleY, 500);
	  }
	  else if (orientation.equals("landscape")) {
	    // Swipe from just inside the right-middle to just inside the left-middle of the element over 500ms
	    driver.swipe(rightX - 5, middleY, leftX + 5, middleY, 500);
	  }
	}
public boolean IsTestPresentOnPage(String text){
	return driver.findElementByAccessibilityId(text).isDisplayed();
}

public String takeScreenShot(String fileName) {
	// TODO Auto-generated method stub
	File file = new File(fileName + ".png");
	File tmpFile = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(tmpFile, file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return fileName;
}

public boolean IsDisplayedOnPage(String text){
	//return driver.findElementByAccessibilityId(text).isDisplayed();
List<WebElement>views = driver.findElementsByClassName("android.view.View");
   System.out.println(views.size());
   for(int i=0;i<=views.size()-1;i++){
	  String name= views.get(i).getText();
	  if(name.contains(text)){
		  return true;
	  }
		}
return false;

}

public boolean isElementDisplayed(String ID) {
	  List<WebElement> weList = driver.findElementsById(ID);
	  if (weList.size() != 0) {
	   return true;
	  } else {
	   return false;
	  }
	 }

public void swipeElement(WebElement element, double touchCount, double xDistance, double yDistance, double duration) {
	   
    // get location of element
    Point coords = element.getLocation();
    double startX = coords.x;
    double startY = coords.y;
   
    // get window size
    Dimension size = driver.manage().window().getSize();
   
    //calculate end distance
    double endX;
    double endY;
   
    //if the distance is a decimal value < 1, it's a relative screen distance
    if (Math.abs(xDistance) < 1) {
    endX = startX + (size.width * Math.abs(xDistance));
    }
    else {
    endX = startX + xDistance;
    }
    if (Math.abs(yDistance) < 1) {
    endY = startY - (size.width * Math.abs(yDistance));
    }
    else {
    endY = startY - yDistance;
    }
   
    Point endCoords = new Point((int)endX, (int)endY);
   
   // util.log("Swiping from: " + coords + " To: " + endCoords);
    System.out.println("Swiping from: " + coords + " To: " + endCoords);
   
    //set up arguments to mobile: swipe
   HashMap<String, Double> flickObject = new HashMap<String, Double>();
   flickObject.put("touchCount", touchCount);
   flickObject.put("startX", startX);
   flickObject.put("startY", startY);
   flickObject.put("endX", endX);
   flickObject.put("endY", endY);
   flickObject.put("duration", duration);

   driver.executeScript("mobile: swipe", flickObject);
    }

public void tap(int fingers,WebElement element,int duration){
	driver.tap(fingers, element, duration);
}

public void tapByLocation(int fingers,int x,int y,int duration){
	driver.tap(fingers, x, y, duration);
}



public void enterTextInTextBoxByID(String ResourceID,String text){
	System.out.println("entering text in text box");
	//Thread.sleep(3000L);
	WebElement textBox = driver.findElementById(ResourceID);
	textBox.click();
	textBox.clear();
	textBox.sendKeys(text);
	//driver.hideKeyboard();
	System.out.println("Entered  text in text box is- "+text);
	
}

public void enterTextInTextBoxByName(String Name,String text){
	System.out.println("entering text in text box");
	//Thread.sleep(3000L);
	WebElement textBox = driver.findElementById(Name);
	
	textBox.click();
	textBox.clear();
	textBox.sendKeys(text);
	//driver.hideKeyboard();
	System.out.println("Entered  text in text box is- "+text);
	
}

public void enterTextInTextBoxByContentText(String contentText,String text){
	System.out.println("entering text in text box");
	//Thread.sleep(3000L);
	WebElement textBox = driver.findElementByAccessibilityId(contentText);
	textBox.click();
	textBox.clear();
	textBox.sendKeys(text);
	//driver.hideKeyboard();
	System.out.println("Entered  text in text box is- "+text);
}

public void enterTextInTextBoxByClass(String className,String text){
	System.out.println("entering text in text box");
	//Thread.sleep(3000L);
	WebElement textBox = driver.findElementByClassName(className);
	textBox.click();
	textBox.clear();
	textBox.sendKeys(text);
	//driver.hideKeyboard();
	System.out.println("Entered  text in text box is- "+text);
}

public void tapOnElement(String ElementID,int fingers,int duration){
	WebElement element=driver.findElementById(ElementID);
	driver.tap(fingers, element, duration);
}
public void tapOnElementByName(String ElementName,int fingers,int duration){
	WebElement element=driver.findElementByName(ElementName);
	driver.tap(fingers, element, duration);
}

public void tapOnElementByContentDesc(String ContentDescText){
	driver.findElementByAccessibilityId(ContentDescText).click();
}


public void tapOnLocation(int x,int y,int fingers,int duration){
	driver.tap(fingers, x, y, duration);
}

public String returnText(String ElementID){
	return driver.findElementById(ElementID).getText();
}

public boolean isTestPresent(String text){
	
	return driver.findElementByName(text).isDisplayed();
	


}


}
