package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocInfoPage {
WebDriver driver;
	
	public DocInfoPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	public WebElement getDocInHeader() {
		return docInHeader;
	}

	public WebElement getDocInTf() {
		return docInTf;
	}

	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement docInHeader;
	
	@FindBy(id="mouseArea_Title")
	private WebElement docInTf;

	public void verifyingDocumentinheader(String expectedDocument)
	{
	String actual = docInHeader.getText();
	if (actual.contains(expectedDocument)) {
	System.out.println("expectedDocument in textfield verified ");
	} else {
	System.out.println("expectedDocument in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingDocumentinTf(String expectedDocument)
	{
	String actual = docInTf.getText();
	if (actual.contains(expectedDocument)) {
	System.out.println("expectedDocument in textfield verified ");
	} else {
	System.out.println("expectedDocument in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
}
