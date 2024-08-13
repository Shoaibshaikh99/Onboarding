package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.ConfirmAddressPage;
import testBase.BaseClass;

public class TC_007_FillPermanentAddress extends BaseClass{
	
	@Test(groups= {"Sanity","Regression"})
	public void FillPermanentAddress() {
		
		try {
		//1.ConfrimAddressPage
		ConfirmAddressPage add = new ConfirmAddressPage(driver);
		
		add.FillPermanentAddress("B403","Eiffel Tower","Near PVR talkies","400001");
		
		//click on next
		BasePage bp = new BasePage(driver);
		bp.next();
		
		//2.ConfirmCurrentAddressPage
		add.FillCurrentAddress();
		bp.next();
		
		Assert.assertTrue(true);
		
		}
		catch(Exception e) {
			logger.error("Test Failed" +e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
	}

}
