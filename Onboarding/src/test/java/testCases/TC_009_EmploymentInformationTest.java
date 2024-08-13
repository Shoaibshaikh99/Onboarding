package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.EmploymentInformationPage;
import testBase.BaseClass;

public class TC_009_EmploymentInformationTest extends BaseClass{
	
	@Test
	public void FillEmploymentInformation() {
		try {
		EmploymentInformationPage emp = new EmploymentInformationPage(driver);
		
		emp.FillEmploymentInformation("test@tcs.com");
		
		//click next
		BasePage bp = new BasePage(driver);
		bp.next();
		
		//provide income information page
		emp.FillIncomeInformation("100000","E:\\SDET\\File Upload Files\\photo.jpg");
		bp.next();
		
		//Employer Information fill
		emp.FillEmployerInformation("T9101", "Manager","IT", "10", "02", "55", "15");
		bp.next();
		
		//Fill Employer address
		emp.FillEmployerAddress("B505","Golden Whale Road","Near Apple pvt ltd","400001");
		bp.next();
		
		//co-applicant page
		String header = emp.getConfirmationMsg();
		Assert.assertEquals(header, "Add a Co-Applicant","Header Mismatch");
		//Assert.assertTrue(true);
		
		}catch(Exception e) {
			logger.error("Test Failed: " +e.getMessage());
			Assert.fail("Test Failed: "+e.getMessage());
		}
	}

}
