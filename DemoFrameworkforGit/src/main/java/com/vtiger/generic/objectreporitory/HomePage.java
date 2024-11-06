package com.vtiger.generic.objectreporitory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement productLink1;

	public WebElement getProductLink1() {
		return productLink1;
	}
	
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement leadsLink1;

	public WebElement getLeadsLink1() {
		return leadsLink1;
	}
	
	public WebElement getDocLink1() {
		return docLink1;
	}

	@FindBy(xpath="//a[text()='Documents']")
	private WebElement docLink1;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignLink;
	
	public void precondition(String url)
	{
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
  
}

