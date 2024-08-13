package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileEmailVerificationPage extends BasePage{

	public MobileEmailVerificationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebElements
	@FindBy(xpath = "//a[normalize-space()='Start My Application']")
	WebElement lnkStartMyApplication;
	
	@FindBy(xpath = "//button[normalize-space()='Resident Indian']")
	WebElement btnRI;
	
	@FindBy(xpath = "//span[@class='font-semi-bold font-size-xs ThemeGrid_MarginGutter']")
	WebElement lnkEkyc;
	
	@FindBy(xpath = "(//a[normalize-space()='Skip'])[1]")
	WebElement lnkSkip;
	
	@FindBy(xpath = "//input[@id='b6-MobileNumber_RI']")
	WebElement txtNumber;
	
	@FindBy(xpath = "//a[@id='b6-VerifyRIMobileLink']")
	WebElement lnkVerifyMobile;
	
	@FindBy(css = "div[role='alert']" )
	WebElement msgOtp;
	
	@FindBy(xpath = "//div[@id='b6-OTPContainer3']//input")
	List<WebElement> txtMobileOtpBoxes;
	
	@FindBy(xpath = "//button[normalize-space()='Verify OTP']")
	WebElement btnVerifyOtp;
	
	@FindBy(xpath = "//input[@id='b6-EmailAddressRI']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//span[@class='verfifyemailtxt']")
	WebElement lnkVerifyEmail;
	
	@FindBy(xpath = "//div[@id='b6-OTPContainer4']//input")
	List<WebElement> txtEmailOtpBoxes;
	
	@FindBy(xpath = "//h2[@class='termslink']//a")
	WebElement lnkTerms;
	
	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement btnAccept;
	
	@FindBy(xpath = "//input[@id='b6-b40-Checkbox1']")
	WebElement chkConsent1;
	
	@FindBy(xpath = "//input[@id='b6-b40-Checkbox2']")
	WebElement chkConsent2;
	
	/*@FindBy(xpath = "//div[@class='pagination d-none d-lg-flex']//div[@class='next-highlight']//a[@href='#']")
	WebElement btnNext;*/
	
	//temp
	@FindBy(xpath = "//div[@id='b5-PageTitle']")
	WebElement pageTitle;
	
	//Action Methods
	
	public void verifyMobile(String number) throws InterruptedException {
		
		lnkStartMyApplication.click();
		btnRI.click();
		lnkEkyc.click();
		Thread.sleep(5000);
		lnkSkip.click();
		txtNumber.sendKeys(number);
		Thread.sleep(3000);
		lnkVerifyMobile.click();
		Thread.sleep(3000);
		
		String otpText = msgOtp.getText(); //Your OTP is:9710
		String mobOtp = otpText.substring(12,16);//Extracting only otp from above text
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
	
	public void verifyEmail(String email) throws InterruptedException {
		
		txtEmail.sendKeys(email);
		lnkVerifyEmail.click();
		Thread.sleep(3000);
		
		String emailText = msgOtp.getText();
		String emailOtp = emailText.substring(13,17);
		int otpCount = txtEmailOtpBoxes.size();
		
		for(int i=0;i<otpCount;i++) {
			WebElement eOtpBox = txtEmailOtpBoxes.get(i);
			char extOtp = emailOtp.charAt(i);
			String eOtp = String.valueOf(extOtp);
			eOtpBox.sendKeys(eOtp);
		}
		
		btnVerifyOtp.click();
		Thread.sleep(5000);
	}
	
	public void acceptConsent() {
		
		lnkTerms.click();
		btnAccept.click();
		chkConsent1.click();
		chkConsent2.click();
		//btnNext.click();
	}
	
	public String getConfirmationMsg() {
		try {
			String txt = pageTitle.getText();
			return txt;
			// OR return(msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}	
	
}
