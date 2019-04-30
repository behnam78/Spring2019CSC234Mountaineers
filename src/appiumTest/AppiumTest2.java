package appiumTest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest2 {


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
	   
	   capabilities.setCapability("appPackage", "com.example.appiumtest");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.example.appiumtest.MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}

	@Test
	public void testCal() throws Exception {
		MobileElement element = driver.findElement(By.id("com.example.appiumtest:id/editText"));
		element.click();
		element.sendKeys("Hello Mountaineers");
		driver.findElement(By.id("button")).click();
		Thread.sleep(1000);
		driver.lockDevice();	

	}
}
