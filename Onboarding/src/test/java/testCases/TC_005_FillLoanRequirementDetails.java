package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LoanRequirementPage;
import testBase.BaseClass;

public class TC_005_FillLoanRequirementDetails extends BaseClass{
	
	@Test(groups="Master")
	public void fillLoanInformation() {
		logger.info(" Starting TC_004_FillLoanRequirementDetails ");
		
		try {
			LoanRequirementPage lr = new LoanRequirementPage(driver);
			
			lr.fillLoanRequirementDetails("40000","11");
						
			BasePage bp = new BasePage(driver);
			Thread.sleep(3000);
			bp.next();
			//Click next on Great Almost done. Check ckyc page
			Thread.sleep(2000);
			bp.next();
			
			Assert.assertTrue(true);
			
		}
		catch(Exception e) 
		{
			logger.error("Test Failed: "+ e.getMessage());
			Assert.fail("Test Failed: "+ e.getMessage());
		}
		logger.info(" Finished TC_004_FillLoanRequirementDetails ");
	}
}
