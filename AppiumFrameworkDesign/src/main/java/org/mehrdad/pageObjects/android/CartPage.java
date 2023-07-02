package org.mehrdad.pageObjects.android;

import java.util.List;

import org.mehrdad.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;

//	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
//	driver.findElement(By.id("android:id/button1"))
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptButton;
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
//	driver.findElement(AppiumBy.className("android.widget.CheckBox"))
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductsSum()
	{
		int count = productList.size();
		
		double totalSum = 0 ;
		
		for(int i=0; i<count; i++) 
		{
			String amountString = productList.get(i).getText();
			// $160.07
			Double price = getFormattedAmount(amountString);
			
			totalSum = totalSum + price; // 160.97 + 120 = 280.97			
			
			
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions()
	{
		longPressAction(terms);
		acceptButton.click();
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void submitOrder()
	{
		checkBox.click();
		proceed.click();
	}
	

}
