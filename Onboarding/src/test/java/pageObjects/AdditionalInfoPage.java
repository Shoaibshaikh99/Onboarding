package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdditionalInfoPage extends BasePage{
	
	public AdditionalInfoPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElements

	@FindBy(xpath = "//input[@id='b6-Input_FatherFirstName']")
	WebElement txtFFirstName;
	
	@FindBy(xpath = "//input[@id='b6-Input_FatherMiddleName']")
	WebElement txtFMiddleName;
	
	@FindBy(xpath = "//input[@id='b6-Input_FatherLastName']")
	WebElement txtFLastName;
	
	@FindBy(xpath = "//input[@id='b6-Input_MotherFirstName']")
	WebElement txtMFirstName;
	
	@FindBy(xpath = "//input[@id='b6-Input_MotherMiddleName']")
	WebElement txtMMiddleName;
	
	@FindBy(xpath = "//input[@id='b6-Input_MotherLastName']")
	WebElement txtMLastName;

	@FindBy(xpath = "//div[normalize-space()='Single']")
	WebElement btnMaritalStatus;
	
	@FindBy(xpath = "//select[@id='b6-HighestQualification']")
	WebElement drpHighestQualEle;
	
	@FindBy(xpath = "//select[@id='b6-Dropdown2']")
	WebElement drpCategoryEle;
	
	@FindBy(xpath = "//select[@id='b6-HighestQualification2']")
	WebElement drpReligionEle;
	
	// Capture Snap Page
	@FindBy(xpath = "//input[@type='file]'")
	WebElement btnUploadPhoto;
	
	@FindBy(xpath = "//button[normalize-space()='Done']")
	WebElement btnDone;
	
	//Action Methods
	
	public void FillFatherName(String fName,String mName,String lName) {
		
		txtFFirstName.sendKeys(fName);
		txtFMiddleName.sendKeys(mName);
		txtFLastName.sendKeys(lName);
	}
	
	public void FillMotherName(String fName,String mName,String lName) {
		txtMFirstName.sendKeys(fName);
		txtMMiddleName.sendKeys(mName);
		txtMLastName.sendKeys(lName);
		btnMaritalStatus.click();
	}
	
	public void HighestQual_Category_Religion(String highestQual,String category,String religion) {
		
		//Highest Qualitifcation dropdown
		Select qual = new Select(drpHighestQualEle);
		qual.selectByVisibleText(highestQual);
		
		//Select category dropdown
		Select cat = new Select(drpCategoryEle);
		cat.selectByVisibleText(category);
		
		//Select religion dropdown
		Select rel = new Select(drpReligionEle);
		rel.selectByVisibleText(religion);

	}
	
	public void UploadPhoto(String photoPath) throws InterruptedException {
		
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);
		
		fileInput.sendKeys(photoPath);
		btnDone.click();
		Thread.sleep(2000);
	}
	
	
}
