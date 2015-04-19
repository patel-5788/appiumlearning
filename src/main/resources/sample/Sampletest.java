package sample;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Popup;

public class Sampletest {
	
	public WebDriver driver;
	
	
	@Test
	public void testtest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer_Win32_2.42.0\\IEDriverServer.exe");
		//driver= new FirefoxDriver();
		//driver = new ChromeDriver();
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get("https://tat.mrtedtalentlink.com/");
		Thread.sleep(5000L);
		driver.findElement(By.id("idCompany")).sendKeys("QC Auto-Tat");
		driver.findElement(By.id("idUsername")).sendKeys("selenium");
		driver.findElement(By.id("idPassword")).sendKeys("Talentlink.2");
		driver.findElement(By.id("c9_submit")).click();
		
		//Thread.sleep(25000L);
		
		driver.get("https://tat.mrtedtalentlink.com/com/com_inbox.cfm");
		//Thread.sleep(25000L);
		driver.findElement(By.xpath("//a[contains(text(),'Calendar')]")).click();
		//Thread.sleep(25000L);
		driver.findElement(By.xpath("//td[contains(text(),'27')]")).click();
		driver.findElement(By.xpath("//td[contains(text(),'22')]")).click();
		//Thread.sleep(5000L);	
		driver.switchTo().frame(0);
		Thread.sleep(5000L);
		WebElement element = driver.findElement(By.xpath("//a[contains(@title,'seleniumTests_20150119_031556_0581')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		js.executeScript("arguments[0].click();", element);  
		
		/*if(driver.findElement(By.xpath("//a[contains(@title,'seleniumTests_20150119_031556_0581')]")).isEnabled()){
		driver.findElement(By.xpath("//a[contains(@title,'seleniumTests_20150119_031556_0581')]")).click();
		}else{
			List<WebElement> concurrent =driver.findElements(By.xpath(""));
			
			for(int i=0;i<=concurrent.size()-1;i++){
				concurrent.get(i).click();
				if(isElementDisplayed("//a[contains(@title,'seleniumTests_20150119_031556_0581')]")){
					driver.findElement(By.xpath("//a[contains(@title,'seleniumTests_20150119_031556_0581')]")).click();
					break;
					}
			}
		}*/
		Thread.sleep(5000L);
		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		Thread.sleep(5000L);
		      String actual =driver.findElement(By.xpath("//td[text()='Date']/following-sibling::td")).getText();                                      // perform operations on popup
              String expected ="Monday 2014/12/29 08:00 - 08:30 (Europe/London)";
              System.out.println("actual="+actual+ "and expected="+expected);
              driver.findElement(By.xpath("//input[@value='Close']")).click();
              Thread.sleep(5000L);
		driver.switchTo().window(parentWindowHandler);
		
		
		
		
		
		
	}

	

		public boolean isElementDisplayed(String xPath) throws InterruptedException {
			Thread.sleep(2000L);
			List<WebElement> weList = driver.findElements(By.xpath(xPath));
				Thread.sleep(2000L);
			if (weList.size() != 0) {
				return true;
			} else {
				return false;
			}
		}
	}

