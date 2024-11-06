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
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LeadInfoPage;
import com.vtiger.generic.objectreporitory.LeadPage;
import com.vtiger.generic.objectreporitory.LoginPage;
import com.vtiger.generic.objectreporitory.LogoutPage;
import com.vtiger.generic.objectreporitory.createLeadPage;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateLeadWithIndustry {
	public static void main(String[] args) throws IOException {
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
		String leadName = eu.getDataFromExcel("lead", 1, 3) + ju.getRandomNumber();
		String companyName = eu.getDataFromExcel("lead", 1, 4) + ju.getRandomNumber();
		String industryName = eu.getDataFromExcel("lead", 1, 5);
//pre condition
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wdu.implicitylyWaitforWebPageToLoad(driver);

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(username, password);

		HomePage hp = new HomePage(driver);
		hp.getLeadsLink1().click();

		LeadPage leadp = new LeadPage(driver);
		leadp.getLeadLink2().click();
		leadp.getCreateLeadIcon().click();

		createLeadPage clp = new createLeadPage(driver);
	    clp.createLeadWithIndustry(leadName, companyName, industryName);
// verifying lead below the header
		LeadInfoPage lip=new LeadInfoPage(driver);
		lip.verifyingLeadinheader(leadName);
// verifying companyname
		lip.verifyingcompanyInTf(companyName);
// verifying industry
        lip.verifyingIndustry(industryName);
		//LogoutPage lo=new LogoutPage(driver);
		//lo.logout();
	}
}
