package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	WebDriver driver;
	public ProductInfoPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"lvtHeaderText\"]")
	private WebElement productInHeader;
	
	public WebElement getProductInHeader() {
		return productInHeader;
	}

	public WebElement getProductInTf() {
		return productInTf;
	}

	@FindBy(id="mouseArea_Product Name")
	private WebElement productInTf;
	
	@FindBy(xpath="//span[@class=\"lvtHeaderText\"]")
	private WebElement productwithcategoryinHeader;
	
	public WebElement getProductwithcategoryinHeader() {
		return productwithcategoryinHeader;
	}


	public WebElement getProwithcatintf() {
		return prowithcatintf;
	}

	@FindBy(id="mouseArea_Product Category")
	private WebElement prowithcatintf;
	
	public void verifyingInHeader(String expectedproductname)
	{
	String actual = productInHeader.getText();
	if (actual.contains(expectedproductname)) {
	System.out.println("expectedproductname in header verified ");
	} else {
	System.out.println("expectedproductname in header not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingInTf(String expectedproductname)
	{
	String actual = productInTf.getText();
	if (actual.contains(expectedproductname)) {
	System.out.println("expectedproductname in textfield verified ");
	} else {
	System.out.println("expectedproductname in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingCategoryinheader(String expectedcategory)
	{
	String actual = productwithcategoryinHeader.getText();
	if (actual.contains(expectedcategory)) {
	System.out.println("expectedcategory in textfield verified ");
	} else {
	System.out.println("expectedcategory in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingCategoryInTf(String expectedCategory)
	{
	String actual = prowithcatintf.getText();
	if (actual.equalsIgnoreCase(expectedCategory)) {
	System.out.println("expectedCategory in textfield verified ");
	} else {
	System.out.println("expectedCategory in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}

}
