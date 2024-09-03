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
		boolean message = loginPage.verifynoinputPassword();
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
		boolean message = loginPage.verifyinvalidinputPassword();
		Assert.assertTrue(message);
	}
	
	@Test
	public void TC4_validateLoginUnseccessfullwithinvalidemail()
	{
		LoginPage loginPage = landingPage.goLogin();
		loginPage.enterEmailorPhone("emailcobacoba@gmail.com");
		loginPage.click_btnSelanjutnya();
		boolean message = loginPage.verifyemailinvalidornotregister();
		Assert.assertTrue(message);
	}
}
