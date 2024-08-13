package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.CustomerBasicDetailsPage;
import pageObjects.SetPasswordPage;
import testBase.BaseClass;

public class TC_002_AccountRegistrationTest1 extends BaseClass{
	
	@Test(groups = "Regression")
	public void VerifyBasicDetails() {
		
		//logger.info("***** Starting TC_002_AccountRegistrationTest1  ****");
		try
		{
		//Enter customer basic details
		CustomerBasicDetailsPage cb = new CustomerBasicDetailsPage(driver);
		cb.EnterBasicDetails("Mr", randomString(), randomString(),randomString(),
				"01011999", "Pune");
		
		//logger.info("***** Successfully Entered Customer Basic Details  ****");
		
		//Click on next
		BasePage bp = new BasePage(driver);
		bp.next();
		
		SetPasswordPage sp = new SetPasswordPage(driver);
		String text = sp.verifyText();
		
		Assert.assertEquals(text, "Set Username and Password", "Text Not Present");
		
		//logger.info("***** Successfully Navigated to Set Password Screen  ****");
		}catch(Exception e) {
			//logger.error("Test Failed: "+ e.getMessage());
			Assert.fail("Test Failed: "+ e.getMessage());
		}
		finally 
		{
		//logger.info("***** Finished TC_001_AccountRegistrationTest *****");
		}
	}

}
