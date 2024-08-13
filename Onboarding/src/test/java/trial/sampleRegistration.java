package trial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleRegistration {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://extuatos.hdfc.com/SPOTOFFER_FE/Landingpage?IsSpotOffer=false");
		
		driver.findElement(By.xpath("//a[normalize-space()='Start My Application']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Resident Indian']")).click();
		driver.findElement(By.xpath("//span[@class='font-semi-bold font-size-xs ThemeGrid_MarginGutter']")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Skip'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='b6-MobileNumber_RI']")).sendKeys("9239816999");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='b6-VerifyRIMobileLink']")).click();
		
		WebElement alertElement1 = driver.findElement(By.cssSelector("div[role='alert']"));//".feedback-message-text"));
		
		Thread.sleep(3000);
		String MobileText = alertElement1.getText();
		
		System.out.println("Alert Text: "+MobileText);
		
		String mobOtp = MobileText.substring(12,16); //Your OTP is:9710
		System.out.println("Extracted OTP :"+ mobOtp);
		
		List<WebElement> otpEle1 = driver.findElements(By.xpath("//div[@id='b6-OTPContainer3']//input"));
		
		int otpCount = otpEle1.size();
		
		for(int i=0;i<otpCount;i++) {
			
			// Get the corresponding otpBox and the digit from OTP
		    WebElement mOtpBox = otpEle1.get(i);
		    char extOtp = mobOtp.charAt(i);
		    String mobileOtp = String.valueOf(extOtp); // Convert char to String because sendKeys accepts only String type data
		    
		    mOtpBox.sendKeys(mobileOtp); // Send the OTP digit to the current otpBox
		
		}
		driver.findElement(By.xpath("//button[normalize-space()='Verify OTP']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='b6-EmailAddressRI']")).sendKeys("ajddf@gmail.com");
		driver.findElement(By.xpath("//span[@class='verfifyemailtxt']")).click();
		
		WebElement alertElement2 = driver.findElement(By.cssSelector("div[role='alert']"));
		Thread.sleep(3000);
		String emailText  = alertElement2.getText();
		System.out.println("Alert Text: "+emailText);
		
		String emailOtp = emailText.substring(13,17);
		System.out.println("Extracted OTP :"+ emailOtp);
		
		List<WebElement> otpEle2 = driver.findElements(By.xpath("//div[@id='b6-OTPContainer4']//input"));
		
		for(int i=0;i<otpCount;i++) {
			WebElement eOtpBox = otpEle2.get(i);
			char extOtp = emailOtp.charAt(i);
			String eOtp = String.valueOf(extOtp);
			eOtpBox.sendKeys(eOtp);
		}
		driver.findElement(By.xpath("//button[normalize-space()='Verify OTP']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//h2[@class='termslink']//a")).click();
		
	}

}
