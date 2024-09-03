package Tokopedia.Test;

import org.junit.Assert;
import org.testng.annotations.Test;

import Tokopedia.PageObjects.RegistPage;
import Tokopedia.TestComponents.BaseTest;

public class RegistrationTest extends BaseTest {

	@Test
	public void validateRegistration() throws InterruptedException
	{
		RegistPage registPage = landingPage.goRegist();
		registPage.enterEmailorPhone("cobaRegist@gmail.com");
		registPage.clickbtnDaftar();
		registPage.verifycorrectEmail();
//		registPage.clickCorrectEmail();
//		boolean match = registPage.verifykodeverifikasi();
//		Assert.assertTrue(match);
	}
	
	@Test
	public void validateRegistrationEmailorPhoneNull()
	{
		RegistPage registPage = landingPage.goRegist();
		registPage.clearinpuEmailorPhone();
		boolean match = registPage.verifyerrorinputemailorPhone("Nomor Ponsel atau Email harus diisi");
		Assert.assertTrue(match);
	}
	
	@Test
	public void validateRegistrationinvalidEmail()
	{
		RegistPage registPage = landingPage.goRegist();
		registPage.enterEmailorPhone("tester@gmail");
		boolean match = registPage.verifyerrorinputemailorPhone("Format email salah");
		Assert.assertTrue(match);
	}
	
	@Test
	public void validateRegistrationinvalidphonenumbertoshort()
	{
		RegistPage registPage = landingPage.goRegist();
		registPage.enterEmailorPhone("0813");
		boolean match = registPage.verifyerrorinputemailorPhone("Nomor ponsel terlalu pendek, minimum 8 angka");
		Assert.assertTrue(match);
	}
	
	@Test
	public void validateRegistrationinvalidphonenumbertolong()
	{
		RegistPage registPage = landingPage.goRegist();
		registPage.enterEmailorPhone("0812312312451234124124124");
		boolean match = registPage.verifyerrorinputemailorPhone("Nomor ponsel terlalu panjang, maksimum 15 angka");
		Assert.assertTrue(match);
	}
	
}
