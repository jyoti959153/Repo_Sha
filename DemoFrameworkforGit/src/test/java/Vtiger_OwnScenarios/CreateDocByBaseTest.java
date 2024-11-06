package Vtiger_OwnScenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.generic.objectreporitory.CreateDocPage;
import com.vtiger.generic.objectreporitory.DocInfoPage;
import com.vtiger.generic.objectreporitory.DocumentPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.webdriverutility.StaticDriverTestUtility;

import BaseClass1.BaseTest1;
@Listeners(com.vtiger.generic.listenerutility.ListenerImplementClass.class)
public class CreateDocByBaseTest extends BaseTest1 {
	@Test(groups="SmokeTest")
	public void createDocTest() throws EncryptedDocumentException, IOException {
		// fetchong the data from excel
		StaticDriverTestUtility.getTest().log(Status.INFO, "read the data from excel ");
		String documentName = eu.getDataFromExcel("doc", 1, 4) + ju.getRandomNumber();
		//create document
		StaticDriverTestUtility.getTest().log(Status.INFO, "create document");
		HomePage hp = new HomePage(driver);
		hp.getDocLink1().click();

		DocumentPage dp = new DocumentPage(driver);
		dp.getCreateDocIcon().click();

		CreateDocPage cdp = new CreateDocPage(driver);
		cdp.createDoc(documentName);
//verifying document below the header
		DocInfoPage dip = new DocInfoPage(driver);
		dip.verifyingDocumentinheader(documentName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "document name is verified");
//verifying doc in textfield
		dip.verifyingDocumentinTf(documentName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "document name is not verified");
	}

}
