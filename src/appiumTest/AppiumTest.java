package appiumTest;





import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumTest {


	AndroidDriver<MobileElement> driver;
    
	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("udid", "emulator-5554");
		capabilities.setCapability("BROWSER_NAME", "Android"); 
		capabilities.setCapability("VERSION", "7.0"); 
		capabilities.setCapability("deviceName","Galaxy Nexus API 24");
		capabilities.setCapability("platformName","Android");
	   
	   capabilities.setCapability("appPackage", "com.android.calculator2");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}

	@Test
	public void testCal() throws Exception {
	 //assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

		
		MobileElement element1 = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
		element1.click();
		MobileElement element3 = driver.findElement(By.id("com.android.calculator2:id/op_add"));
		element3.click();
		MobileElement element2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		element2.click();
		MobileElement element4 = driver.findElement(By.id("com.android.calculator2:id/eq"));
		element4.click();
		MobileElement results=driver.findElement(By.id("com.android.calculator2:id/result"));
		assertEquals(results.getText(), "5");
	}
}
