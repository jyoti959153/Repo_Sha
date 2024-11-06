package Vtiger_OwnScenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.generic.objectreporitory.CreateProductPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LogoutPage;
import com.vtiger.generic.objectreporitory.ProductInfoPage;
import com.vtiger.generic.objectreporitory.ProductPage;
import com.vtiger.generic.webdriverutility.StaticDriverTestUtility;

import BaseClass1.BaseTest1;
@Listeners(com.vtiger.generic.listenerutility.ListenerImplementClass.class)
public class CreateProductByBaseTest extends BaseTest1 {
	@Test(groups="SmokeTest")
	public void createProduct() throws EncryptedDocumentException, IOException {
		// fetchong the data from excel
		StaticDriverTestUtility.getTest().log(Status.INFO, "read  the data from excel");
		String productName = eu.getDataFromExcel("pro", 1, 3) + ju.getRandomNumber();

		// creating product
		StaticDriverTestUtility.getTest().log(Status.INFO, "create product");
		HomePage hp = new HomePage(driver);
		hp.getProductLink1().click();
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductIcon().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(productName);
		// verifying product below the header
		ProductInfoPage pip = new ProductInfoPage(driver);
		pip.verifyingInHeader(productName);
		StaticDriverTestUtility.getTest().log(Status.INFO,"poduct in header is verified");
		// verifying productname
		pip.verifyingInTf(productName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "lead in textfield is verified");

	}

	@Test(groups="RegressionTest")
	public void createProductWithCategory() throws EncryptedDocumentException, IOException {
//fetching the data from excel
		StaticDriverTestUtility.getTest().log(Status.INFO, "read  the data from excel");
		String productName = eu.getDataFromExcel("pro", 1, 3) + ju.getRandomNumber();
		String categoryName = eu.getDataFromExcel("pro", 4, 4);
		// creating product with category
		StaticDriverTestUtility.getTest().log(Status.INFO, "create product with category");
		HomePage hp = new HomePage(driver);
		hp.getProductLink1().click();

		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductIcon().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProductWithCat(productName);

		// verify product in header
		ProductInfoPage pip = new ProductInfoPage(driver);
		pip.verifyingInHeader(productName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "product is verified");

		// verify category in textfield
		pip.verifyingCategoryInTf(categoryName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "category in textfield is verified");
	}

}
