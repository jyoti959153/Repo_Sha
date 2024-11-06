package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
WebDriver driver;
	
	public LeadInfoPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement leadinheader;
	
	public WebElement getLeadinheader() {
		return leadinheader;
	}


	public WebElement getLeadinTf() {
		return leadinTf;
	}


	public WebElement getCompanyinTf() {
		return companyinTf;
	}

	@FindBy(id="mouseArea_Last Name")
	private WebElement leadinTf;
	
	
	@FindBy(id="mouseArea_Company")
	private WebElement companyinTf;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryInTf;

	public WebElement getIndustryInTf() {
		return industryInTf;
	}
	
	public void verifyingLeadinheader(String expectedlead)
	{
	String actual = leadinheader.getText();
	if (actual.contains(expectedlead)) {
	System.out.println("expectedlead in textfield verified ");
	} else {
	System.out.println("expectedlead in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingcompanyInTf(String expectedcompany)
	{
	String actual = companyinTf.getText();
	if (actual.contains(expectedcompany)) {
	System.out.println("expectedcompany in textfield verified ");
	} else {
	System.out.println("expectedcompany in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}
	
	public void verifyingIndustry(String expectedIndustry)
	{
	String actual = industryInTf.getText();
	if (actual.contains(expectedIndustry)) {
	System.out.println("expectedIndustry in textfield verified ");
	} else {
	System.out.println("expectedIndustry in textfield not verified");
	}
	//Assert.assertEquals(actual, expectedCamp);
	}

}
