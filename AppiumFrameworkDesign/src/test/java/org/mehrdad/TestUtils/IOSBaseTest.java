package org.mehrdad.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.mehrdad.pageObjects.iOS.HomePage;
import org.mehrdad.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest extends AppiumUtils{
	
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException 
	{
//		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 8 Plus");
		options.setApp("/Users/mehrdadfhassani/Library/Developer/Xcode/DerivedData/UIKitCatalog-bzpcfrtoiceghbhgwkuqytglpgya/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
//		options.setApp("//Users/mehrdadfhassani//eclipse-workspace//Appium2//src/test//java//resources//TestApp 3.app");
		
		options.setPlatformVersion("16.4");
		//Appium - Webdriver Agent -> IOS Apps.
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);

	}
	

	
	



	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//stop server
//		service.stop();
	}

}
