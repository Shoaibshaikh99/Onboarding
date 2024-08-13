package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmAddressPage extends BasePage{
	
	public ConfirmAddressPage(WebDriver driver){
		super(driver);
	}
	
	//WebElements
	
	@FindBy(xpath = "//input[@id='b6-Input_HouseNumber']")
	WebElement txtFlatNumber;
	
	@FindBy(xpath = "//input[@id='b6-Input_Building']")
	WebElement txtBuilding;
	
	@FindBy(xpath = "//input[@id='b6-Input_Landmark']")
	WebElement txtLandmark;
	
	@FindBy(xpath = "//input[@id='b6-Input_PinCode']")
	WebElement txtPinCode;
	
	@FindBy(xpath = "//input[@id='b6-Input_Country']")
	WebElement txtCountry; //click on this textbox to just to fetch state and city through pin
	
	//Current Address Page
	@FindBy(xpath = "//div[normalize-space()='Self Owned']")
	WebElement btnPropertyOwnership;
	
	
	//Action Methods
	public void FillPermanentAddress(String flatNumber,String Building,String landmark,
			String pin) {
		
		txtFlatNumber.sendKeys(flatNumber);
		txtBuilding.sendKeys(Building);
		txtLandmark.sendKeys(landmark);
		txtPinCode.sendKeys(pin);
		txtCountry.click();
	}
	
	public void FillCurrentAddress() {
		btnPropertyOwnership.click();
	}
}
