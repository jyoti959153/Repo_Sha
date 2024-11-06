package com.vtiger.generic.objectreporitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProductPage 
{
	WebDriver driver;
	
	public CreateProductPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productTf;
	

	public WebElement getProductTf() {
		return productTf;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	
	@FindBy(name="productcategory")
	private WebElement categoryDropdown;

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public void createProduct(String productname)
	{
	productTf.sendKeys(productname);
	saveBtn.click();
	}
	
	public void createProductWithCat(String productname)
	{
	productTf.sendKeys(productname);
    Select s=new Select(categoryDropdown);
    s.selectByValue("Hardware");
	saveBtn.click();
	}
}
