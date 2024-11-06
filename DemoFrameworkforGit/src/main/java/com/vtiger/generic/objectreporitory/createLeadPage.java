package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createLeadPage {
	WebDriver driver;
	public createLeadPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public WebElement getLeadTf() {
		return leadTf;
	}

	public WebElement getComapanyTf() {
		return comapanyTf;
	}

	@FindBy(name="lastname")
	private WebElement leadTf;
	
	@FindBy(name="company")
	private WebElement comapanyTf;

	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	
	public void createLead(String leadname,String companyname)
	{
	leadTf.sendKeys(leadname);
	comapanyTf.sendKeys(companyname);
	saveBtn.click();
	}
	
	public void createLeadWithIndustry(String leadname,String companyname,String industry)
	{
	leadTf.sendKeys(leadname);
	comapanyTf.sendKeys(companyname);
	Select s2=new Select(industryDropdown);
	s2.selectByValue("Education");
	saveBtn.click();
	}
}
