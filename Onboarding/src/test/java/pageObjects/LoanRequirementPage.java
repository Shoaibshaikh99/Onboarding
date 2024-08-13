package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanRequirementPage extends BasePage{
	
	public LoanRequirementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	//WebElements
	@FindBy(xpath = "//div[contains(text(),'Home Loan')]")
	WebElement btnHomeLoan;
	
	@FindBy(id = "b7-Input_TextVar2")
	WebElement txtLoanAmount;
	
	@FindBy(id = "b7-Input_Tenure")
	WebElement txtLoanTenure;
	
	@FindBy(xpath = "//div[@class='radio mb-3']")
	WebElement btnBalanceTransferNo;
	
	@FindBy(xpath = "//div[@id='b7-value']")
	WebElement txtFloat;
	
	/*@FindBy(xpath = "//div[@class='pagination d-none d-lg-flex']//div[@class='next-highlight']//a[@href='#']//span[contains(text(),'Next')]")
	WebElement btnNext; */ //not working
	
	//Action Methods
	
	public void fillLoanRequirementDetails(String loanAmount,String tenure) throws InterruptedException {
		
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.switchTo().frame("b7-Form1");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnHomeLoan);
	    //btnHomeLoan.click();
		txtLoanAmount.sendKeys(loanAmount);
		txtLoanTenure.sendKeys(tenure);
		txtFloat.click();
		btnBalanceTransferNo.click();
		Thread.sleep(2000);
	}


	
	
}
