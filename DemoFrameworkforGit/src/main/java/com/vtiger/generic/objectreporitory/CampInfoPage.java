package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampInfoPage {
	WebDriver driver;
	public CampInfoPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement campInHeader;
	
	public WebElement getCampInHeader() {
		return campInHeader;
	}

	public WebElement getCampInTf() {
		return campInTf;
	}

	@FindBy(id="mouseArea_Campaign Name")
	private WebElement campInTf;

	public void verifyingCampInHeader(String expectedCamp)
	{
	String actual = campInHeader.getText();
	if (actual.contains(expectedCamp)) {
	System.out.println("expectedCamp in textfield verified ");
	} else {
	System.out.println("expectedCamp in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingCampInTf(String expectedCamp)
	{
	String actual = campInTf.getText();
	if (actual.contains(expectedCamp)) {
	System.out.println("expectedCamp in textfield verified ");
	} else {
	System.out.println("expectedCamp in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
}
