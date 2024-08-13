package pageObjects;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CompleteYourKycVerificationPage extends BasePage{
	
	public CompleteYourKycVerificationPage(WebDriver driver) {
		super(driver);
	}
	//All KYC related three pages taken in this class
	
	//WebElements
	
	//Digilocker_VerifyCKYC page
	@FindBy(xpath = "//span[normalize-space()='Verify Manually']")
	WebElement btnVerifyManually;
	
	//Next page - Verify Manual CKYC Page
	
	@FindBy(xpath = "//span[normalize-space()='Upload my documents']")
	WebElement btnUploadMyDocuments;
	
	//NExt page - Upload identity proof page
	@FindBy(xpath = "//select[@id='Dropdown1']")
	WebElement 	drpEle1;
	
	@FindBy(xpath = "//select[@id='Dropdown2']")
	WebElement drpEle2;
	
	@FindBy(xpath = "//div[@id='b7-Title']")
	WebElement btnUpload1;
	
	@FindBy(xpath = "//div[@id='b19-TitleWrapper']")
	WebElement btnUpload2;

	/*@FindBy(xpath = "//label[@id='b9-Upload']")
	WebElement btnMyDevice1;
	
	@FindBy(xpath = "//label[@id='b21-Upload']")
	WebElement btnMyDevice2;*/
	
	
	
	//Action Methods
	public void clickVerifyManually() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(3000);
		btnVerifyManually.click();
		btnUploadMyDocuments.click();
	}
	
	public void uploadDoc(String filePath) throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);
		//Upload Proof of identity
		Select drp1 = new Select(drpEle1);
		drp1.selectByValue("0");
		
		btnUpload1.click();
		//Thread.sleep(1000);
		/*input[@type='file'] - This tag and attribute should be there in the DOM for any upload
		file functionality.It is mandatory to have this tag and attribute, if not present uploading
		doc through automation  will not work. Then we should enable that hidden tag and attribute
		using below javaScript code*/
		WebElement fileInput1 = driver.findElement(By.xpath("//input[@type='file']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput1);
		fileInput1.sendKeys(filePath);
		//btnMyDevice1.sendKeys(filePath1);//Upload doc*
		Thread.sleep(8000);
		
		//Upload Proof of address
		Select drp2 = new Select(drpEle2);
		drp2.selectByValue("0");
		btnUpload2.click();
		WebElement fileInput2 = driver.findElement(By.xpath("//input[@type='file']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput2);
		fileInput2.sendKeys(filePath);
		//Thread.sleep(2000);
		//btnMyDevice2.sendKeys(filePath);
	}
	
	
	
	
	
	
}
