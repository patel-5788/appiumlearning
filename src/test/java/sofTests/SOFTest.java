package sofTests;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sofPages.BookListPage;
import sofPages.SOFHomePage;
import testConfig.TestConfig;

import com.yogi.HomePage;

public class SOFTest{
	public AndroidDriver driver;
	
	@Parameters({"RunOn","deviceName","ApplicationPath"})
	@BeforeTest
	public void init(String runon,String deviceName, String apppath) throws MalformedURLException, InterruptedException{
		driver=TestConfig.startAppium(runon,deviceName, apppath);
}

@ AfterTest(alwaysRun= true)
public void tearDown(){
	driver.quit();
}	


//@Test(priority=1)
public void registertTest() throws InterruptedException{
   Thread.sleep(10000L);
   
   System.out.println("this is test");
   new HomePage(driver)
   .taoOnLoginButton()
   .registrationLink()
   .enterEmail("aravind.patel5845888@ness.com")
   .enterPassword("9993712760")
   .enterConfirmPassword("9993712760")
   .submitButton()
   .confirmationBoxOK()
   .taoOnLogoutButton()
   ;
}

@Test(priority=2)
public void loginTest() throws InterruptedException{
 Thread.sleep(10000L);
  new SOFHomePage(driver)
     .loginButton()
     .enterEmail("aravind.patel5845888@ness.com")
     .enterPassword("9993712760")
     .submitButton()
     .gridMenu(0)
     .selectClassPopup("Class 1")
     .buyButton()
     .addToCart()
     .proceedPaymentButton()
     .makePayment()
     .selectPaymentOption("Credit card")
     .submit()
     .enterCardNumber()
     .expireMonth("03")
     .expireYear("2017")
     .enterCCV()
     .payNow()
     .cancel()
     .verfiyCancel()
     .logout();
 Thread.sleep(2000L);
   
      
}

/*//@Test(priority=3)
public void gridMenu() throws InterruptedException{
  Thread.sleep(5000L);
   homepage.gridMenu(0);
   homepage.selectClassPopup("Class 1");
   //Thread.sleep(2000L);
   //Assert.assertTrue("Class not selected",homepage.isTestPresent("Class 1"));
   booklist.buyButton();
  
   
}

// @Test(priority=4)
public void addToCard() throws InterruptedException{
  
 // Assert.assertTrue("My cart page no opened",homepage.isTestPresent("My Cart"));
  //Assert.assertEquals(booklist.bookName(), cart.BookName());
  cart.addToCart();
  Assert.assertTrue("book not added to cart ",cart.verifyCart());
  cart.proceedPaymentButton();
  
}
  //@Test(priority=5)
  public void makePayment() throws InterruptedException{
	  //Assert.assertTrue("payment page not displayed",payment.verifyPageTitle());
	 //Assert.assertEquals("price not matched", payment.totalAmount(),cart.bookPrice());
	  payment.makePayment();
	 
	  
	  
  }
  
 // @Test(priority=6)
  public void paymentMode() throws InterruptedException{
	 // Thread.sleep(5000L);
	 // Assert.assertTrue("payment mode page not found",paymentoption.verifyTitle());
	 // paymentoption.selectPaymentOption("Credit card");
	 // paymentoption.submit();
	 
	  
  }	  
  
//@Test(priority=7)
   public void proceedPayment() throws InterruptedException{
	   filldetails.payByDebitCard("4854460214407752","01","2018","123");
	  // filldetails.proceedtoPay();
	   //Assert.assertEquals("error message not present", "Invalid card number",filldetails.wrongCardNumError());
	   filldetails.cancel();
	   //Thread.sleep(5000L);
	   Assert.assertTrue("cancellation message not appearing",filldetails.verfiyCancel());
	   driver.sendKeyEvent(4);
	   driver.sendKeyEvent(4);
	
		
   //}

   
//@Test(priority=8)
public void logOut() throws InterruptedException{
  
   homepage.logoutButton();
   homepage.logoutCancel();   
   homepage.logoutButton();
   homepage.logoutConfirmation();
   //Assert.assertTrue("User not logged out ", homepage.isTestPresent("Login"));
   
}
  */
   
@AfterMethod(alwaysRun=true)
public void after(){
	driver.quit();
}
}