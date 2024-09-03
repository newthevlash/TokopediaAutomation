package Tokopedia.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email-phone")
	WebElement input_emailphone;
	
	@FindBy(id="email-phone-submit")
	WebElement btn_Selanjutnya;
	
	@FindBy(id="password-input")
	WebElement input_password;
	
	@FindBy(css=".css-10e3bzf")
	WebElement span_verifikasiemailphone;
	
	@FindBy(css="span[aria-label='login-button']")
	WebElement btn_Masuk;
	
	@FindBy(css=".css-t9c9fq.erj7th78")
	WebElement messageerrorpassword;
	
	@FindBy(css=".css-xvn0u1-unf-heading.e1qvo2ff5")
	WebElement span_Emailbelumterdaftar;
	
	
	
	public void enterEmailorPhone(String emailPhone)
	{
		input_emailphone.sendKeys(emailPhone);
	}
	
	public void click_btnSelanjutnya()
	{
		btn_Selanjutnya.click();
	}
	
	public void enterPasword(String password)
	{
		input_password.sendKeys(password);
	}
	
	public void click_btnMasuk()
	{
		btn_Masuk.click();
	}
	
	public boolean verifyVerifikasiemailorPhone()
	{
		driver.getPageSource().contains("Pilih Metode Verifikasi");
		boolean displayed = span_verifikasiemailphone.isDisplayed();
		return displayed;
	}
	
	public boolean verifyerrorinputPassword(String errorMessage)
	{
		String message = messageerrorpassword.getText();
		boolean match = message.equalsIgnoreCase(errorMessage);
		return match;
	}
	
	
	
	public boolean verifyemailinvalidornotregister()
	{
		driver.getPageSource().contains("Email belum terdaftar");
		boolean displayed = span_Emailbelumterdaftar.isDisplayed();
		return displayed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
