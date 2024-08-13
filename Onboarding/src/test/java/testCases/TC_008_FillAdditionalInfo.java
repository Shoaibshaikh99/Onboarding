package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdditionalInfoPage;
import pageObjects.BasePage;
import testBase.BaseClass;

public class TC_008_FillAdditionalInfo extends BaseClass
{

	@Test
	public void FillAdditionalInfo() {
		
		try {
		AdditionalInfoPage add = new AdditionalInfoPage(driver);
		
		add.FillFatherName("Robert","James","Bennett");
		add.FillMotherName("Elizabeth","Anne","Bennett");
		add.HighestQual_Category_Religion("BACHELOR OF COMPUTER SCIENCE","GENERAL","CHRISTIAN");
		
		//click on next
		BasePage bp = new BasePage(driver);
		bp.next();
		
		//Upload photo
		add.UploadPhoto("E:\\SDET\\File Upload Files\\photo.jpg");
		bp.next();
		Assert.assertTrue(true);
		
		} catch(Exception e) {
			logger.error("Test Failed" +e.getMessage());
			Assert.fail("Test Failed"+e.getMessage());
		}
	}
	

}
