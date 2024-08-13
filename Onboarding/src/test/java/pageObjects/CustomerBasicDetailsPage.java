package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerBasicDetailsPage extends BasePage{

	public CustomerBasicDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebElements
	
	@FindBy(xpath = "//select[@id='b7-SalutationDropDown']")
	WebElement drpTitleEle;
	
	@FindBy(xpath = "//input[@id='b7-First_Name']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='b7-Middle_Name']")
	WebElement txtMiddleName;
	
	@FindBy(xpath = "//input[@id='b7-Last_Name']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//span[@class='input-text']//input[@id='b7-Input_Date']")
	WebElement txtDob;
	
	@FindBy(xpath = "//div[normalize-space()='Male']")
	WebElement btnGender;
	
	@FindBy(xpath = "//button[@class='btn skip dont-have-pan']")
	WebElement btnPan;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement btnIsPanAvailable;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//input[@id='b7-Input_SearchInput']")
	WebElement txtCity;
	
	//Action Methods
	
	public void EnterBasicDetails(String title,String fname,String mname,String lname,String dob,String city) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Select drpTitle = new Select(drpTitleEle);
		drpTitle.selectByVisibleText(title);
		
		txtFirstName.sendKeys(fname);
		txtMiddleName.sendKeys(mname);
		txtLastName.sendKeys(lname);
		txtDob.sendKeys(dob);
		Thread.sleep(3000);
		btnGender.click();
		btnPan.click();
		btnIsPanAvailable.click();
		btnContinue.click();
		txtCity.sendKeys(city);

	}
	
	

}
