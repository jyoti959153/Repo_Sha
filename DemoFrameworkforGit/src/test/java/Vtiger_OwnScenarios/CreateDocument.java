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
import com.vtiger.generic.objectreporitory.CreateDocPage;
import com.vtiger.generic.objectreporitory.CreateProductPage;
import com.vtiger.generic.objectreporitory.DocInfoPage;
import com.vtiger.generic.objectreporitory.DocumentPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LoginPage;
import com.vtiger.generic.objectreporitory.LogoutPage;
import com.vtiger.generic.objectreporitory.ProductInfoPage;
import com.vtiger.generic.objectreporitory.ProductPage;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateDocument 
{
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
		String documentName = eu.getDataFromExcel("doc", 1, 4) + ju.getRandomNumber();
//pre condition
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wdu.implicitylyWaitforWebPageToLoad(driver);

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(username, password);

		HomePage hp = new HomePage(driver);
		hp.getDocLink1().click();

		DocumentPage dp=new DocumentPage(driver);
		dp.getCreateDocIcon().click();

        CreateDocPage cdp=new CreateDocPage(driver);
        cdp.createDoc(documentName);
//verifying document below the header
		DocInfoPage dip=new DocInfoPage(driver);
		dip.verifyingDocumentinheader(documentName);
//verifying doc in textfield
		dip.verifyingDocumentinTf(documentName);
//logout
		LogoutPage lo=new LogoutPage(driver);
		lo.logout();
	}
}