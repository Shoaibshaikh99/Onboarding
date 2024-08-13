package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetPasswordPage extends BasePage{

	public SetPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebElements
	@FindBy(xpath = "//span[normalize-space()='Set Username and Password']")
	WebElement confmsg;
	
	@FindBy(xpath = "//input[@id='b5-Input_NewPassword']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='b5-Input_ConfirmPassword']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//button[@class='btn btn-primary ThemeGrid_Width12']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//span[@class='title mb-1 h3-big']")
	WebElement confLoanMsg;
	
	//Action Methods
	public String verifyText() {
		String confMsg = confmsg.getText();
		return confMsg;
	}
	
	public void SetPassword(String pwd) throws InterruptedException {
		txtPassword.sendKeys(pwd);
		txtConfirmPassword.sendKeys(pwd);
		System.out.println("Password : "+pwd);
		Thread.sleep(3000);
		btnSubmit.click();
	}
	
	public Boolean verifyLoanText() {
		Boolean status = confLoanMsg.isDisplayed();
		
		return status;
		
	}

}
