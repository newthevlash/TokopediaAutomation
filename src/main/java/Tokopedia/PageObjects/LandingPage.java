package Tokopedia.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".css-16r70d4")
	WebElement btn_login;
	
	@FindBy(css="input[placeholder='Cari di Tokopedia']")
	WebElement input_search;
	
	@FindBy(css=".css-xml5xq")
	WebElement btn_category;
	
	@FindBy(css=".css-1okvkby")
	List<WebElement> list_Subcategory;
	
	@FindBy(css=".css-19zjbhc")
	List<WebElement> list_category;
	
	@FindBy(css=".css-ges1q2")
	List<WebElement> list_productCategory;
	
	
	public LoginPage goLogin()
	{
		btn_login.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public void goSearch(String product) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.sendKeys(input_search, product).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
	}
	
	public boolean verifyProductSearch(String product) 
	{
		boolean verify =  driver.getPageSource().contains(product);
		return verify;
	}
	
	public boolean verifyProductinvalid(String message)
	{
		boolean verify =  driver.getPageSource().contains(message);
		return verify;
	}
	
	public void goSearchCategory(String category) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(btn_category).build().perform();
		WebElement select_category = list_category.stream().filter(p->p.getText().equalsIgnoreCase(category)).findFirst().orElse(null);
		select_category.click();
		Thread.sleep(2000);
	}
	
	public void goSearchSubCategory(String category,String subcategory) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(btn_category).build().perform();
		WebElement select_category = list_category.stream().filter(p->p.getText().equalsIgnoreCase(category)).findFirst().orElse(null);
		a.moveToElement(select_category).build().perform();;
		WebElement select_subcategory = list_Subcategory.stream().filter(p->p.getText().equalsIgnoreCase(subcategory)).findFirst().orElse(null);
		select_subcategory.click();
		Thread.sleep(2000);
	}
	
	public void goSearchProductnameCategory(String category,String product) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(btn_category).build().perform();
		WebElement select_category = list_category.stream().filter(p->p.getText().equalsIgnoreCase(category)).findFirst().orElse(null);
		a.moveToElement(select_category).build().perform();
		WebElement select_product = list_productCategory.stream().filter(p->p.getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		select_product.click();
		Thread.sleep(2000);
	}
	
	public void goTOLandingPage() 
	{
		driver.get("https://www.tokopedia.com/");
	}
	
}
