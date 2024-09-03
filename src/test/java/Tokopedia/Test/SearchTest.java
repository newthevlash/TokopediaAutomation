package Tokopedia.Test;

import org.junit.Assert;
import org.testng.annotations.Test;

import Tokopedia.PageObjects.LandingPage;
import Tokopedia.TestComponents.BaseTest;

public class SearchTest extends BaseTest{

	@Test
	public void TC1_searchvalidProduct() throws InterruptedException 
	{
		landingPage.goSearch("sepeda");
		boolean match = landingPage.verifyProductSearch("Sepeda gunung");
		Assert.assertTrue(match);
	}
	
	@Test
	public void TC2_searchinvalidProduct() throws InterruptedException 
	{
		landingPage.goSearch("kdasdqwasdaefrtasd");
		boolean match = landingPage.verifyProductinvalid("Oops, produk nggak ditemukan");
		Assert.assertTrue(match);
	}
	
	@Test
	public void TC3_Searchproductwithcategory() throws InterruptedException
	{
		landingPage.goSearchCategory("elektronik");
		boolean match = landingPage.verifyProductSearch("TV");
		Assert.assertTrue(match);
	}
	
	@Test
	public void TC4_Searchproductwithsubcategoty() throws InterruptedException
	{
		landingPage.goSearchSubCategory("Dapur", "Peralatan Masak");
		boolean match = landingPage.verifyProductSearch("kompor");
		Assert.assertTrue(match);
	}
	
	@Test
	public void TC5_SearchCategorywithdetailproduct() throws InterruptedException
	{
		landingPage.goSearchProductnameCategory("elektronik", "telepon kabel");
		boolean match = landingPage.verifyProductSearch("kabel");
		Assert.assertTrue(match);
	}
}



