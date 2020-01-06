package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import Page.BookTicketPage;
import Page.Menu;
import Page.LoginPage;

public class TestPractice extends Base {
	@Test
	public void TC01_ValidLogin() {
		Menu.clickLogIn();
		LoginPage.loginWith(Constant.validEmail, Constant.validPassword);
		Assert.assertEquals("Welcome" + " " + Constant.validEmail, Menu.txtLoginSuccessMessage().getText());
	}

	@Test
	public void TC02_LoginWithBlankUsername() {
		Menu.clickLogIn();
		LoginPage.loginWith("", Constant.validPassword);
		Assert.assertEquals(LoginPage.txtLoginErrorMessage().getText(), Constant.loginErrMessageWithBlankValues);
	}

	@Test
	public void TC03_LoginWithInvalidPass() {
		Menu.clickLogIn();
		LoginPage.loginWith(Constant.validEmail, Constant.invalidPassword);
		Assert.assertEquals(LoginPage.txtLoginErrorMessage().getText(), Constant.loginErrMessageWithInvalidValues);
	}

	@Test
	public void TC04_RedirectToBookTicketAfterLogin() {
		Menu.clickBookTicket();
		LoginPage.loginWith(Constant.validEmail, Constant.validPassword);		
		Assert.assertTrue(BookTicketPage.doesBookTicketFormExist());
	}
}
