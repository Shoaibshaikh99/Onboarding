package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.MobileEmailVerificationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	//Onboarding
	@Test(groups = "Regression")
	public void Verify_Account_Registration() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		try
		{
			MobileEmailVerificationPage me = new MobileEmailVerificationPage(driver);
			
			String number = randomNumber();
			me.verifyMobile(number);
			System.out.println(number);
			logger.info("*** Mobile Number Verified Successfully");
			me.verifyEmail(randomString()+"@gmail.com");
			logger.info("*** Mobile Number Verified Successfully");
			me.acceptConsent();
			
			//Next button
			BasePage bp = new BasePage(driver);
			bp.next();
			
			String pageTitle = me.getConfirmationMsg();//getConfirmationMsg() this method returns string hence need to store returning value in string
			Assert.assertEquals(pageTitle, "REGISTRATION", " Page Title Mismatch");
			logger.info("*** Page Title Verified Successfully");
			
		}catch(Exception e) {
			logger.error("Test Failed: "+ e.getMessage());
			Assert.fail("Test Failed: "+ e.getMessage());
		}
		finally 
		{
		logger.info("***** Finished TC_001_AccountRegistrationTest *****");
		}
	}
}
