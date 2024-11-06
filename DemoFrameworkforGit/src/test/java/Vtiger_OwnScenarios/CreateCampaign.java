package Vtiger_OwnScenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import com.vtiger.generic.fileutility.ExcelUtility;
import com.vtiger.generic.fileutility.FileUtility;
import com.vtiger.generic.objectreporitory.CampInfoPage;
import com.vtiger.generic.objectreporitory.CampaignPage;
import com.vtiger.generic.objectreporitory.CreateCampPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LoginPage;
import com.vtiger.generic.objectreporitory.LogoutPage;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateCampaign {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		WebDriverUtility wdu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
//fetching the data from property file
		String browser = fu.propertyFile("browser");
		String url = fu.propertyFile("url");
		String username = fu.propertyFile("username");
		String password = fu.propertyFile("password");

//fetchong the data from excel
		String CampaignName = eu.getDataFromExcel("camp", 1, 3) + ju.getRandomNumber();
		System.out.println(CampaignName);
//pre condition
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wdu.implicitylyWaitforWebPageToLoad(driver);

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(username, password);
// create campaign
		HomePage hp=new HomePage(driver);
		hp.getMoreLink().click();
		Thread.sleep(2000);
		hp.getCampaignLink().click();
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampIcon().click();
	    CreateCampPage ccp=new CreateCampPage(driver);
	    ccp.createCampaign(CampaignName);
	    
// verifying campaignname in header
        CampInfoPage cip=new CampInfoPage(driver);
		cip.verifyingCampInHeader(CampaignName);
// verifying campaignname in texfeild
		cip.verifyingCampInTf(CampaignName);
//logout		
		LogoutPage lo=new LogoutPage(driver);
		lo.logout();
	}
}
