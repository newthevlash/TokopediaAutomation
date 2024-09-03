package Tokopedia.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistPage {

	WebDriver driver;
	public RegistPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-phone-email")
	WebElement input_emailphone;
	
	@FindBy(css=".css-kt8ee4")
	WebElement btn_daftar;
	
	@FindBy(css=".css-280ezp")
	WebElement span_MasukanKode;
	
	@FindBy(css=".css-vhz208")
	WebElement btn_yaBenar;
	
	@FindBy(css=".css-1ev3ixb")
	WebElement message_correctemail;
	
	@FindBy(css=".css-ajjrzl")
	WebElement inputed_email;
	
	@FindBy(css=".css-y0w6gg")
	WebElement messaageerror_emailorphone;
	
	
	
	public void clearinpuEmailorPhone()
	{
		input_emailphone.sendKeys(Keys.SPACE);
		input_emailphone.sendKeys(Keys.BACK_SPACE);
	}
	public void enterEmailorPhone(String emailPhone)
	{
		input_emailphone.sendKeys(emailPhone);
	}
	
	public void clickbtnDaftar() throws InterruptedException
	{
		btn_daftar.click();
		Thread.sleep(2000);
	}
	
	public void verifycorrectEmail()
	{
		inputed_email.isDisplayed();
		message_correctemail.isDisplayed();
	}
	
	public void clickCorrectEmail() throws InterruptedException
	{
		btn_yaBenar.click();
		Thread.sleep(30000);
	}
	
	public boolean verifykodeverifikasi()
	{
		driver.getPageSource().contains("Masukkan Kode Verifikasi");
		boolean displayed = span_MasukanKode.isDisplayed();
		return displayed;
	}
	
	public boolean verifyerrorinputemailorPhone(String errormessage) 
	{
		boolean match = messaageerror_emailorphone.getText().contains(errormessage);
		return match;
	}
	
}
