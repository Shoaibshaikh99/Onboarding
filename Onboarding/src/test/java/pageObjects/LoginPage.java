package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElements

	@FindBy(xpath = "//input[@id='b7-Input_MobileNumber']")
	WebElement txtMobileNumber;
	
	@FindBy(xpath = "//input[@id='b7-Input_TextVar']")
	WebElement txtDob;
	
	@FindBy(xpath = "//button[@class='verify-otp OSFillParent']")
	WebElement btnSendOtp;
	
	@FindBy(css = "div[role='alert']" )
	WebElement msgOtp;
	
	@FindBy(xpath = "//div[@class='input-style-OTP']//input")
	List<WebElement> txtMobileOtpBoxes;
	
	@FindBy(xpath = "//button[normalize-space()='Verify OTP']")
	WebElement btnVerifyOtp;
	
	@FindBy(xpath = "//button[@class='verify-otp w-100 my-4 ThemeGrid_Width6']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//button[normalize-space()='Create New']")
	WebElement btnCreateNew;
	
	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement btnAccept;
	//Action Methods
	
	public void userLogin (String mobileNumber,String dob) throws InterruptedException {
		
		txtMobileNumber.sendKeys(mobileNumber);
		txtDob.sendKeys(dob);
		btnSendOtp.click();
		Thread.sleep(3000);
	}
	
	public void verifyOtp() throws InterruptedException {
		
		String otpText = msgOtp.getText(); //Your generated OTP is: 9710
		System.out.println("OTP Text is: "+otpText);
		String mobOtp = otpText.substring(24,28);//Extracting only otp from above text
		System.out.println("OTP:"+mobOtp);
		int otpCount = txtMobileOtpBoxes.size();
		
		for(int i=0;i<otpCount;i++) {
			
			// Get the corresponding otpBox and the digit from OTP
		    WebElement mOtpBox = txtMobileOtpBoxes.get(i);
		    char extOtp = mobOtp.charAt(i);
		    String mobileOtp = String.valueOf(extOtp); // Convert char to String because sendKeys accepts only String type data
		    
		    mOtpBox.sendKeys(mobileOtp); // Send the OTP digit to the current otpBox
		
		}
		
		btnVerifyOtp.click(); //Click on verify otp button after entering otp
		Thread.sleep(5000);	
	}
	
	public void clickLogin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		btnLogin.click();
		Thread.sleep(3000);
		btnCreateNew.click();
		Thread.sleep(3000);
		btnAccept.click();
	}

}
