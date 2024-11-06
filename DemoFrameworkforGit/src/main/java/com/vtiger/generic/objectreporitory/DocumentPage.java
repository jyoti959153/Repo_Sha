package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
WebDriver driver;
	
	public DocumentPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}

	
	public WebElement getCreateDocIcon() {
		return createDocIcon;
	}


	@FindBy(xpath="//img[@alt=\"Create Document...\"]")
	private WebElement createDocIcon;
}
