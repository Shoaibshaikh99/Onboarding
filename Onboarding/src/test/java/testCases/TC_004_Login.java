package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_004_Login extends BaseClass{
	
	@Test(groups= "Sanity")
	public void LoginTest() throws InterruptedException {
		try {
		LoginPage lp = new LoginPage(driver);
		
		lp.userLogin("9444444444", "01-01-1996");//
		/*9284313462 -01-01-1996  ,9111111111 - 01-01-1999,9222222222-01-01-1998,
		 * 9333333333 - 01-01-1997,9444444444 - 01-01-1996*/
		lp.verifyOtp();
		lp.clickLogin();
		
		}catch(Exception e) {
			logger.error("Test Failed" +e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
	}

}
