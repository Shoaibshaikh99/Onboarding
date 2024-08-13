package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmploymentInformationPage extends BasePage{
	
	public EmploymentInformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='col-6 col-md-4 col-lg-6 col-xl-4 mb-3']//div[@class='radio']")
	WebElement btnSalaried;
	
	@FindBy(xpath = "//input[@id='b6-Input_Email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='b6-Input_SearchInput2']")
	WebElement txtEmployerName;
	
	@FindBy(xpath = "//input[@id='b6-MonthlyIncome']")
	WebElement txtSalary;
	
	@FindBy(xpath = "(//span[@class='font-regular'][normalize-space()='Upload Salary Slip'])[1]")
	WebElement btnUploadSalarySlip;

	@FindBy(xpath = "//input[@id='b6-Input_EmpIdNumber']")
	WebElement txtEmpId;
	
	@FindBy(xpath = "//input[@id='b6-Input_Designation']")
	WebElement txtDesignation;
	
	@FindBy(xpath = "//input[@id='b6-Input_Department']")
	WebElement txtDepartment;
	
	@FindBy(xpath = "//input[@id='b6-Input_DurationYear']")
	WebElement txtYear;
	
	@FindBy(xpath = "//input[@id='b6-Input_DurationMonth']")
	WebElement txtMonth;
	
	@FindBy(xpath = "//input[@id='b6-Input_RetirementAge']")
	WebElement txtRetirementAge;
	
	@FindBy(xpath = "//input[@id='b6-Input_TotalExperience']")
	WebElement txtTotalExp;
	
	//Emoloyer Address Page
	@FindBy(xpath = "(//input[@id='b6-Input_Place'])[1]")
	WebElement srchEmployerName;
	
	@FindBy(xpath = "//div[@class='list list-group RubikLight OSFillParent']//div")
	List<WebElement> drpOptions;
	
	@FindBy(xpath = "(//input[@id='b6-InputFlatNumber'])[1]")
	WebElement txtOfficeNo;
	
	@FindBy(xpath = "(//input[@id='b6-InputAreaName'])[1]")
	WebElement txtStreet;
	
	@FindBy(xpath = "(//input[@id='b6-InputNearbyLandmark'])[1]")
	WebElement txtLandmark;
	
	@FindBy(xpath = "(//input[@id='b6-InputEnterPINCode'])[1]")
	WebElement txtPincode;
	
	//Add-Co applicant page
	@FindBy(xpath = "//h3[@class='title mb-1']")
	WebElement msgConfirmation;
	
	//Action Methods
	
	public void FillEmploymentInformation(String email) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		btnSalaried.click();
		txtEmail.sendKeys(email);
		txtEmployerName.click();
	}
	
	public void FillIncomeInformation(String salary,String salSlipPath) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtSalary.sendKeys(salary);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnUploadSalarySlip);
		//btnUploadSalarySlip.click();
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);
		
		fileInput.sendKeys(salSlipPath);
		Thread.sleep(2000);
	}
	
	public void FillEmployerInformation(String empId,String designation,String department,
			String yr,String month,String retAge,String exp) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtEmpId.sendKeys(empId);
		txtDesignation.sendKeys(designation);
		txtDepartment.sendKeys(department);
		txtYear.sendKeys(yr);
		txtMonth.sendKeys(month);
		txtRetirementAge.sendKeys(retAge);
		txtTotalExp.sendKeys(exp);

	}
	
	public void FillEmployerAddress(String officeNo,String street,String landmark,String pin) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*srchEmployerName.sendKeys(empName);
		Thread.sleep(2000);
		for(WebElement option : drpOptions) {
			
			String values = option.getText();
			
			if(values.equalsIgnoreCase(empName)) {
				
				option.click();
			}
		}*/
		txtOfficeNo.sendKeys(officeNo);
		txtStreet.sendKeys(street);
		txtLandmark.sendKeys(landmark);
		txtPincode.sendKeys(pin);
		
		
	}
	public String getConfirmationMsg() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
		String txt = msgConfirmation.getText();
		return txt;
		
		}catch (Exception e) {
			return (e.getMessage());
		}
	}

}
