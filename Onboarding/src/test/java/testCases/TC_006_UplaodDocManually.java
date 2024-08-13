package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.CompleteYourKycVerificationPage;
import testBase.BaseClass;

public class TC_006_UplaodDocManually extends BaseClass{
	
	@Test(groups= "Regression")
	public void UploadDocManually() throws InterruptedException, AWTException {
		
		try {
			
		
		CompleteYourKycVerificationPage kyc = new CompleteYourKycVerificationPage(driver);
		
		kyc.clickVerifyManually();
		
		kyc.uploadDoc("E:\\SDET\\File Upload Files\\Aadhar.jpg");//filepath
		
		
		BasePage bp = new BasePage(driver);
		bp.next();
		
		Assert.assertTrue(true);
	
		}
		catch(Exception e){
			logger.error("Test Failed" +e.getMessage());
			Assert.fail("Test Failed: "+ e.getMessage());
		}
		}
	
	
}
