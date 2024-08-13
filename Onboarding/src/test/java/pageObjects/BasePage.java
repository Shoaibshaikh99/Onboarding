 package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {   //userneame : TEST0101 PW :Test@123
	
	WebDriver driver;
	
	//Constructor
	public BasePage(WebDriver driver) {
		
		this.driver = driver;  //WebDriver object is storing in instance variable
		PageFactory.initElements(driver, this); //PageFactory initializes driver for @FindBy Annotation
	}
	
	//Next button
	@FindBy(xpath = "//div[@class='pagination d-none d-lg-flex']//div[@class='next-highlight']//a[@href='#']")
	WebElement btnNext;
	
	public void next() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", btnNext);
		btnNext.click();
	}
	
	
    }


	

