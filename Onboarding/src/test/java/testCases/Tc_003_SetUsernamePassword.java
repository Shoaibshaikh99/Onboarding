package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SetPasswordPage;
import testBase.BaseClass;

public class Tc_003_SetUsernamePassword extends BaseClass{
	
	@Test(groups="Regression")
	public void SetPassword() {
		//logger.info("***** Starting TC_003_Set Username and Password ****");
		try
		{
		SetPasswordPage sp = new SetPasswordPage(driver);
		String password = randomAlphaNumeric().toLowerCase();
		
		sp.SetPassword("A"+password);
		System.out.println(password);
		
		Boolean status = sp.verifyLoanText();
		
		Assert.assertEquals(status, true, " Registration Failed, Unable to navigate on Loan Information screen");
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
