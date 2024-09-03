package Tokopedia.Test;

import org.junit.Assert;
import org.testng.annotations.Test;

import Tokopedia.PageObjects.LoginPage;
import Tokopedia.TestComponents.BaseTest;

public class LoginTest extends BaseTest{

	@Test
	public void TC1_validateLoginSuccessFull()
	{
		LoginPage loginPage = landingPage.goLogin();
		loginPage.enterEmailorPhone("newthevlash15@gmail.com");
		loginPage.click_btnSelanjutnya();
		loginPage.enterPasword("doedoet68");
		loginPage.click_btnMasuk();
		boolean message = loginPage.verifyVerifikasiemailorPhone();
		Assert.assertTrue(message);
	}
	
	@Test
	public void TC2_validateLoginUnsuccessfullwithNOPassword()
	{
		LoginPage loginPage = landingPage.goLogin();
		loginPage.enterEmailorPhone("newthevlash15@gmail.com");
		loginPage.click_btnSelanjutnya();
		loginPage.click_btnMasuk();
		boolean message = loginPage.verifyerrorinputPassword("Kata sandi harus diisi");
		Assert.assertTrue(message);
	}
	
	@Test
	public void TC3_validateLoginUnseccessfullwithinvalidpassword()
	{
		LoginPage loginPage = landingPage.goLogin();
		loginPage.enterEmailorPhone("newthevlash15@gmail.com");
		loginPage.click_btnSelanjutnya();
		loginPage.enterPasword("dodododod213");
		loginPage.click_btnMasuk();
		boolean message = loginPage.verifyerrorinputPassword("Email atau kata sandi salah");
		Assert.assertTrue(message);
	}
	
	@Test
	public void TC4_validateLoginUnseccessfullwithinvalidemail() throws InterruptedException
	{
		LoginPage loginPage = landingPage.goLogin();
		loginPage.enterEmailorPhone("emailcobacoba@gmail.com");
		loginPage.click_btnSelanjutnya();
		Thread.sleep(3000);
		boolean message = loginPage.verifyemailinvalidornotregister();
		Assert.assertTrue(message);
	}
}
