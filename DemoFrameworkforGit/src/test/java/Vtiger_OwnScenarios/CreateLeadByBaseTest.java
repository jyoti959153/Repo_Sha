package Vtiger_OwnScenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.generic.objectreporitory.HomePage;
import com.vtiger.generic.objectreporitory.LeadInfoPage;
import com.vtiger.generic.objectreporitory.LeadPage;
import com.vtiger.generic.objectreporitory.createLeadPage;
import com.vtiger.generic.webdriverutility.StaticDriverTestUtility;

import BaseClass1.BaseTest1;
@Listeners(com.vtiger.generic.listenerutility.ListenerImplementClass.class)
public class CreateLeadByBaseTest extends BaseTest1 {
	@Test(groups="SmokeTest")
	public void createLeadTest() throws EncryptedDocumentException, IOException {
		// fetchong the data from excel
		StaticDriverTestUtility.getTest().log(Status.INFO, "read the data from excel");
		String leadName = eu.getDataFromExcel("lead", 1, 3) + ju.getRandomNumber();
		String companyName = eu.getDataFromExcel("lead", 1, 4) + ju.getRandomNumber();
		//create lead
		StaticDriverTestUtility.getTest().log(Status.INFO, "create lead");
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink1().click();
		LeadPage leadp = new LeadPage(driver);
		leadp.getLeadLink2().click();
		leadp.getCreateLeadIcon().click();
		createLeadPage clp = new createLeadPage(driver);
		clp.createLead(leadName, companyName);
// verifying lead below the header
		LeadInfoPage lip = new LeadInfoPage(driver);
		lip.verifyingLeadinheader(leadName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "lead in header is verified");
// verifying companyname
		lip.verifyingcompanyInTf(companyName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "company name is verified");
	}

	@Test(groups="RegressionTest")
	public void createLeadWithIndustryTest() throws EncryptedDocumentException, IOException {
		// fetchong the data from excel
		StaticDriverTestUtility.getTest().log(Status.INFO, "read the data from excel");
		String leadName = eu.getDataFromExcel("lead", 1, 3) + ju.getRandomNumber();
		String companyName = eu.getDataFromExcel("lead", 1, 4) + ju.getRandomNumber();
		String industryName = eu.getDataFromExcel("lead", 1, 5);
		StaticDriverTestUtility.getTest().log(Status.INFO, "create lead with industry");
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink1().click();

		LeadPage leadp = new LeadPage(driver);
		leadp.getLeadLink2().click();
		leadp.getCreateLeadIcon().click();

		createLeadPage clp = new createLeadPage(driver);
		clp.createLeadWithIndustry(leadName, companyName, industryName);
// verifying lead below the header
		LeadInfoPage lip = new LeadInfoPage(driver);
		lip.verifyingLeadinheader(leadName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "lead name is verified");
// verifying companyname
		lip.verifyingcompanyInTf(companyName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "companyName is verified");
// verifying industry
		lip.verifyingIndustry(industryName);
		StaticDriverTestUtility.getTest().log(Status.INFO, "industryName is verified");
	}

}
