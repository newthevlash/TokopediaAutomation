package Cucumber.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Tokped {

	WebDriver driver;
	@Given("User open the browser")
	public void user_open_the_browser()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}
	
	@And("User on tokopedia page")
	public void user_on_tokopedia_page()
	{
		driver.get("https://www.tokopedia.com/");
	}
	
	@When("User click Masuk button")
	public void user_click_Masuk_button()
	{
		driver.findElement(By.cssSelector(".css-16r70d4")).click();
	}
	
	@And("User enter valid email or phone number")
	public void user_enter_valid_email_or_phone_number()
	{
		driver.findElement(By.id("email-phone")).sendKeys("newthevlash15@gmail.com");
	}
	
	@And("User click Selanjutnya button")
	public void user_click_Selanjutnya_button()
	{
		driver.findElement(By.id("email-phone-submit")).click();
	}
	
	@And("User enter valid password")
	public void User_enter_valid_password()
	{
		driver.findElement(By.id("password-input")).sendKeys("doedoet68");
	}
	
	@And("User click Login button")
	public void user_click_Login_button()
	{
		driver.findElement(By.cssSelector("button span[aria-label='login-button']")).click();
	}
	
	@Then("User navigate to verify with email or phone number")
	public void user_navigate_to_verify_with_email_or_phone_number() throws InterruptedException
	{
		driver.getPageSource().contains("Pilih Metode Verifikasi");
		driver.findElement(By.cssSelector(".css-10e3bzf")).isDisplayed();
		
		Thread.sleep(3000);
		driver.close();
	}
	
	@And("User set password NULL")
	public void user_set_password_NULL()
	{
		driver.findElement(By.id("password-input")).clear();
	}
	
	@Then("popup error message under password field")
	public void popup_error_message_under_password_field()
	{
		driver.findElement(By.cssSelector(".css-t9c9fq.erj7th78")).isDisplayed();
	}
	
}

	

