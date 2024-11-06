package Vtiger_OwnScenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.generic.objectreporitory.CampInfoPage;
import com.vtiger.generic.objectreporitory.CampaignPage;
import com.vtiger.generic.objectreporitory.CreateCampPage;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.webdriverutility.StaticDriverTestUtility;

import BaseClass1.BaseTest1;
@Listeners(com.vtiger.generic.listenerutility.ListenerImplementClass.class)
public class CreateCampByBaseTest extends BaseTest1 {
	@Test(groups="SmokeTest")
	public void createCampTest() throws InterruptedException, EncryptedDocumentException, IOException {
		// fetchong the data from excel
		StaticDriverTestUtility.getTest().log(Status.INFO, "read the data from excel");
		String CampaignName = eu.getDataFromExcel("camp", 1, 3) + ju.getRandomNumber();
		System.out.println(CampaignName);
		// create campaign
		StaticDriverTestUtility.getTest().log(Status.INFO, "create campaign");
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		Thread.sleep(2000);
		hp.getCampaignLink().click();
		CampaignPage cp = new CampaignPage(driver);
		cp.getCreateCampIcon().click();
		CreateCampPage ccp = new CreateCampPage(driver);
		ccp.createCampaign(CampaignName);

// verifying campaignname in header
		CampInfoPage cip = new CampInfoPage(driver);
		cip.verifyingCampInHeader(CampaignName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "camaignname in header verified");
// verifying campaignname in texfeild
		cip.verifyingCampInTf(CampaignName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "camaign name  in textfield verified");
	}

}
