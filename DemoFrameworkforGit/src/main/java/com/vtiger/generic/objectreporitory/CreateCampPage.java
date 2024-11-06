package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {
	WebDriver driver;
	public CreateCampPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campTf;
	
	public WebElement getCampTf() {
		return campTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	 public void createCampaign(String campaignname)
	 {
     campTf.sendKeys(campaignname);
     saveBtn.click();
	 }

}
