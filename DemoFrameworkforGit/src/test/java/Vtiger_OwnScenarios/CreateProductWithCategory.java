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
import com.vtiger.generic.objectreporitory.CreateProductPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LoginPage;
import com.vtiger.generic.objectreporitory.LogoutPage;
import com.vtiger.generic.objectreporitory.ProductInfoPage;
import com.vtiger.generic.objectreporitory.ProductPage;
import com.vtiger.generic.webdriverutility.JavaUtility;
import com.vtiger.generic.webdriverutility.WebDriverUtility;

public class CreateProductWithCategory {

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

//fetching the data from excel
		String productName = eu.getDataFromExcel("pro", 1, 3) + ju.getRandomNumber();
		String categoryName = eu.getDataFromExcel("pro", 4, 4);
		System.out.println(categoryName);
//pre condition
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wdu.implicitylyWaitforWebPageToLoad(driver);

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(username, password);

		HomePage hp = new HomePage(driver);
		hp.getProductLink1().click();

		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductIcon().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProductWithCat(productName);

		// verify product in header
		ProductInfoPage pip = new ProductInfoPage(driver);
		pip.verifyingInHeader(productName);

		// verify category in textfield
		pip.verifyingCategoryInTf(categoryName);

		// logout
		LogoutPage lo = new LogoutPage(driver);
		lo.logout();
	}
}
