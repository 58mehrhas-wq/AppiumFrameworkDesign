package org.mehrdad;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.mehrdad.TestUtils.IOSBaseTest;
import org.mehrdad.pageObjects.iOS.AlertViews;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	
	@Test
	public void IOSBasicTest() throws InterruptedException
	{
		Thread.sleep(1000);
		// Xpath, classname, IOS, iosClassChain, IOSPredicateString, accessibility id, id
//		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		AlertViews alertViews = homePage.selectAlertViews();
		
		
		
		// Xpath - XML language - App source
//		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
//		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
		
		alertViews.fillTextLabel("Bonjour mon ami!");
//		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hallo Mein Freund!");
//		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();
		
//		String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
//		Assert.assertEquals(text, "A message should be a short, complete sentence.");
		String actualMessage = alertViews.getConfirmMessage();
//		System.out.println(text);
//		
//		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
		
		AssertJUnit.assertEquals(actualMessage, "A message should be a short, complete sentence.");
		
		
	}

}
