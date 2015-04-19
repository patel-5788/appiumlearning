package testConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class TestConfig {
	
	public static  AndroidDriver driver;
	public static String gridurl="http://127.0.0.1:4444/wd/hub";
	private static  DesiredCapabilities capabilities = new DesiredCapabilities();

		public static void setCapabilities(String device,String automation,String appPath){
			//Log.info("setting capabilities");
			try {
				deleteAppData("clear com.sof.revise");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				File app = new File(appPath); 
				capabilities.setCapability("deviceName", device);
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app", app.getAbsolutePath());
			    capabilities.setCapability("noReset", true);
			    capabilities.setCapability(MobileCapabilityType.SUPPORTS_LOCATION_CONTEXT,"true");
			    capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, "30");
			    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
			    capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "100");
			    capabilities.setCapability(MobileCapabilityType.SUPPORTS_LOCATION_CONTEXT,"");
				capabilities.setCapability("setWebContentsDebuggingEnabled","true");
				
				//Log.info(" capabilities setting done");
			}
		
		public static void setChromeCapabilities(String device) throws InterruptedException{
			
			try {
				deleteAppData("com.android.chrome");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			capabilities.setCapability("deviceName", device);
			capabilities.setCapability("platformName", "android");
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		}
	
	
	   public static AndroidDriver  startAppium(String runon,String deviceName, String apppath) throws InterruptedException, MalformedURLException{
		
		if(runon.equalsIgnoreCase("mobile1")){
			//Log.info("starting appium node on :"+mobile_device_1);
			setCapabilities(deviceName,"Appium",apppath);
			//Log.info("started appium node on :"+mobile_device_1);
		         }
		
		if(runon.equalsIgnoreCase("mobile2")){
			//Log.info("starting appium node on :"+"emulator-5554");
			setCapabilities(deviceName,"Appium",apppath);
			//Log.info("started appium node on :"+"emulator-5554");
		
		         }
		
		
		if(runon.equalsIgnoreCase("emulator-1")){
			//Log.info("starting appium node on :"+emulator1);
			setCapabilities(deviceName,"Appium",apppath);
			//Log.info("started appium node on :"+emulator1);
		         }
		
			
		if(runon.equalsIgnoreCase("emulator-2")){
			//Log.info("starting appium node on :"+"");
			setCapabilities(deviceName,"Appium",apppath);
			//Log.info("started appium node on :"+"");
		         }
		
		if(runon.equalsIgnoreCase("chrome")){
			//Log.info("starting appium node on :"+"");
			setChromeCapabilities(deviceName);
			//Log.info("started appium node on :"+"");
		         }
		driver =  new AndroidDriver(new URL(gridurl), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	//@AfterTest
	public void quit(){
		//Log.info("quiting appium " );
		driver.quit();
	}
	
	
	
	public static void deleteAppData(String AppPkg) throws InterruptedException, IOException{
	CommandPrompt cp = new CommandPrompt();
	//AvailabelPorts ap = new AvailabelPorts();
	
	/**
	 * start appium with default arguments
	 */
	
		cp.runCommand("adb shell pm "+AppPkg);
		Thread.sleep(5000);
	}
	

}
