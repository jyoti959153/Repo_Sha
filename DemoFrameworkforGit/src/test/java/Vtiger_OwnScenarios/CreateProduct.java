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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.generic.fileutility.ExcelUtility;
import com.vtiger.generic.fileutility.FileUtility;
import com.vtiger.generic.objectreporitory.CreateProductPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LoginPage;
import com.vtiger.generic.objectreporitory.LogoutPage;
import com.vtiger.generic.objectreporitory.ProductInfoPage;
import com.vtiger.generic.objectreporitory.ProductPage;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateProduct {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		WebDriverUtility wdu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
//fetching the data from property file
		String browser = fu.propertyFile("browser");
		String url = fu.propertyFile("url");
		System.out.println(url);
		String username = fu.propertyFile("username");
		System.out.println(username);
		String password = fu.propertyFile("password");
        System.out.println(password);
//fetchong the data from excel
		String productName = eu.getDataFromExcel("pro", 1, 3) + ju.getRandomNumber();
//pre condition
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wdu.implicitylyWaitforWebPageToLoad(driver);

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(username, password);
//creating product
		HomePage hp = new HomePage(driver);
		hp.getProductLink1().click();
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductIcon().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(productName);
//verifying product below the header
		ProductInfoPage pip=new ProductInfoPage(driver);
		pip.verifyingInHeader(productName);
//verifying productname
		pip.verifyingInTf(productName);
//logout
		LogoutPage lo=new LogoutPage(driver);
		lo.logout();
	}
}
