package org.mehrdad;





import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.mehrdad.TestUtils.AndroidBaseTest;
import org.mehrdad.pageObjects.android.CartPage;
import org.mehrdad.pageObjects.android.FormPage;
import org.mehrdad.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest{
	
	@Test(dataProvider = "getData", groups = {"Smoke"})
//	public void FillForm(String name, String gender, String country) throws InterruptedException
	public void FillForm(HashMap<String, String> input) throws InterruptedException
	{
		Thread.sleep(1000);
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue = formPage.submitForm();
		

		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		

		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		
		Thread.sleep(3000);
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		
		cartPage.acceptTermsConditions();
	
		
		cartPage.submitOrder();
		Thread.sleep(6000);
		
		// Hybrid - Google page
		Set<String> contexts = driver.getContextHandles();
		
		for(String contextName: contexts)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore"); //chrome driver
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");		
		
	}
	
//	@BeforeMethod
//	public void preSetup()
//	{
//		formPage.setActivity();
//	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//mehrdad//testData//eCommerce.json");
//		return new Object[][] {  {"Moohoos ololey", "Female", "Belgium"}, {"Mooshololos", "Male", "Angola" }  };
		return new Object[][] {  {data.get(0)}, {data.get(1)}  };
	}
	

}
