package testConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class TestConfig {
	
	public static  AndroidDriver driver;
	public static String gridurl="http://127.0.0.1:4444/wd/hub";
	
	/*public static String mobile_device_1="TA933071OQ";
	public static String emulator1 = "emulator-5554";
	public static String emulator2 = "emulator-5556";*/
	//private static final Logger Log = Logger.getLogger(TestConfig.class);
	private static  DesiredCapabilities capabilities = new DesiredCapabilities();

		public static void setCapabilities(String device,String automation,String appPath){
			//Log.info("setting capabilities");
			try {
				deleteAppData();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				File app = new File(appPath); 
				capabilities.setCapability("deviceName", device);
				//capabilities.setCapability("udid", device);				
				//capabilities.setCapability("automationName",automation);
				//capabilities.setCapability("appium-version", "1.2.2");
				capabilities.setCapability("platformName", "Android");
				//capabilities.setCapability("platformVersion", "4.4.2");			
			    capabilities.setCapability("app", app.getAbsolutePath());
			    capabilities.setCapability("noReset", true);
			    capabilities.setCapability(MobileCapabilityType.SUPPORTS_LOCATION_CONTEXT,"true");
			   // capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, "300");
			    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
			    //capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "300");
			   // capabilities.setCapability(MobileCapabilityType.SUPPORTS_LOCATION_CONTEXT,"");
				capabilities.setCapability("setWebContentsDebuggingEnabled","true");
				
				//Log.info(" capabilities setting done");
			}
	
	public static AndroidDriver startAppium() throws MalformedURLException, InterruptedException{
		//PropertyConfigurator.configure("Log4j.properties");
		//Log.info("initializing appium with capabilities"+capabilities);
		driver =  new AndroidDriver(new URL(gridurl), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000L);
		return driver;
	}
	public static AndroidDriver  startAppium(String runon,String deviceName, String apppath) throws MalformedURLException, InterruptedException{
		
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
		driver =  new AndroidDriver(new URL(gridurl), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	//@AfterTest
	public void quit(){
		//Log.info("quiting appium " );
		driver.quit();
	}
	
	
	
	public static void deleteAppData() throws InterruptedException, IOException{
	CommandPrompt cp = new CommandPrompt();
	//AvailabelPorts ap = new AvailabelPorts();
	
	/**
	 * start appium with default arguments
	 */
	
		cp.runCommand("adb shell pm clear com.sof.revise");
		Thread.sleep(5000);
	}
	

}
