package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocPage {
	WebDriver driver;
	public CreateDocPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public WebElement getDocTf() {
		return docTf;
	}

	@FindBy(name="notes_title")
	private WebElement docTf;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	public void createDoc(String Docname)
	{
	docTf.sendKeys(Docname);
	saveBtn.click();
	}
	}



