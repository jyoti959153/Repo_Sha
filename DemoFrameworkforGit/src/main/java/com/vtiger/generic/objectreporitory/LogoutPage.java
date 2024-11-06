package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administor;
	
	public WebElement getAdministor() {
		return administor;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;

	public void logout()
	{
	administor.click();
	signout.click();
	}

}
