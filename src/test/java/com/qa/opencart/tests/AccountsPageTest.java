package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opercart.pages.AccountsPage;

public class AccountsPageTest extends BaseTest{
	AccountsPage accPage;
	
	@BeforeClass
	public void login() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test()
	public void AccountPageTittleTest() {
		String actualTittle=accPage.getAccountPageTittle();

		Assert.assertEquals(actualTittle,AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void accountPageURLTest() {
		String actualURL=accPage.getAccountPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION_VALUE));
		}
	
	@Test
	public void logoutLinkDisplayedExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkDisplayed());
	}
	
	@Test
	public void getHeaderLinkListTest() {
		int actualSize=accPage.getHeaderLinkList().size();
		Assert.assertTrue(actualSize==4);
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actAccHeadersList = accPage.getHeaderLinkList();
		List<String> expAccHeadersList = AppConstants.EXP_ACCOUNTS_HEADERS_LIST;
		Assert.assertEquals(actAccHeadersList, expAccHeadersList);
	}

}
