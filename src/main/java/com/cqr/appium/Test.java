package com.cqr.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class Test {
	private static IOSDriver driver;
	private static boolean isInstall = true;

	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	public static void test1() throws InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability("appium-version", "1.7.2");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("newCommandTimeout", 60000);
		capabilities.setCapability("launchTimeout", 60000);
		capabilities.setCapability("browserName", "safari");

		if (isInstall) {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "apps");
			File app = new File(appDir, "TestApp-iphonesimulator.app");
			System.out.println("---->" + app.getAbsolutePath());
			capabilities.setCapability("app", app.getAbsolutePath());
		}

		// support Chinese
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		try {
			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//			driver.get("http://www.google.com");
//			driver.get("http://www.baidu.com");
//			driver.get("http://www.baidu.com");
			
			
			
			WebElement inputbox1 =driver.findElementByName("TextField1");
	        inputbox1.sendKeys("12");
	        
	        WebElement inputbox2 =driver.findElementByName("TextField2");
	        inputbox2.sendKeys("65");
	        
	        WebElement calcButton=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAButton[1]");
	        
	        calcButton.click();
	        WebElement result=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIAStaticText[1]");
	        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("**********************Cheers Li Appium Testing ******************************");
		// wd.close();
	}

	public static boolean enterText(IOSDriver driver, By selector, String text) {
		if (text == null) {
			System.out.println("      the input data is NULL, please check if the excel file contains the corresponding data column.");
			return false;
		}
		WebElement inputbox1 = driver.findElementByName("TextField1");
		inputbox1.sendKeys("12");
		return true;
	}

	public static boolean clickButton(IOSDriver driver, By selector, String text) {
		WebElement calcButton = driver.findElementByName("TextField1");
		calcButton.click();
		return true;
	}

}
