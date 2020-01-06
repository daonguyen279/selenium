package Test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Helper;
import Page.BookTicketPage;
import Page.ChangePasswordPage;
import Page.ForgotPasswordPage;
import Page.LoginPage;
import Page.Mailinator;
import Page.Menu;
import Page.PasswordResetPage;
import Page.RegisterPage;

public class TestAssignment extends Base {
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

	@Test
	public void TC07_ValidRegister() {
		Menu.clickRegister();
		RegisterPage.registerWithRandomValue();
		Assert.assertTrue(RegisterPage.doesRegisterSuccessMessageExist());
	}

	@Test
	public void TC08_LoginWithUnActiveAccount() {
		Map<String, String> values = RegisterPage.navigateAndRegisterWithRandomValue();
		Menu.clickLogIn();
		LoginPage.loginWith(values.get("email"), values.get("password"));
		Assert.assertEquals(LoginPage.txtLoginErrorMessage().getText(), Constant.loginErrMessageWithInvalidValues);
	}

	@Test
	public void TC09_ChangePasswordWithWrongConfirmPassword() {
		Map<String, String> values = RegisterPage.navigateAndRegisterWithRandomValue();
		RegisterPage.activateAccount(values.get("email"));

		Menu.clickLogIn();
		LoginPage.loginWith(values.get("email"), values.get("password"));
		Menu.clickChangePassword();
		ChangePasswordPage.changePasswordWith(values.get("password"), "a123:\"/{}!@$\\", "b456:\"/{}!@$\\");
		Assert.assertEquals(ChangePasswordPage.txtChangePasswordErrorMessage().getText(),
				Constant.changePasswordErrMessage);
	}

	@Test
	public void TC10_RegisterWithUsedEmail() {
		Map<String, String> values = RegisterPage.navigateAndRegisterWithRandomValue();
		RegisterPage.activateAccount(values.get("email"));

		Menu.clickRegister();
		RegisterPage.registerWith(values.get("email"), values.get("password"), values.get("pid"));
		Assert.assertEquals(RegisterPage.txtRegisterErrorMessage().getText(),
				Constant.registerErrMessageWithRegisteredEmail);
	}

	@Test
	public void TC11_RegisterWithBlankPassAndPid() {
		Menu.clickRegister();
		RegisterPage.registerWith(Constant.validEmail, "", "");
		Assert.assertEquals(RegisterPage.txtRegisterErrorMessage().getText(),
				Constant.registerErrMessageWithInvalidValues);
		Assert.assertEquals(RegisterPage.txtRegisterPasswordErrorMessage().getText(),
				Constant.registerErrMessageInvalidPassword);
		Assert.assertEquals(RegisterPage.txtRegisterPidErrorMessage().getText(), Constant.registerErrMessageInvalidPid);
	}

	@Test
	public void TC12_ResetPasswordWithBlankResetToken() {
		Map<String, String> values = RegisterPage.navigateAndRegisterWithRandomValue();
		RegisterPage.activateAccount(values.get("email"));

		Menu.clickLogIn();
		LoginPage.clickForgotPassword();
		ForgotPasswordPage.sendInstructionsWith(values.get("email"));
		Mailinator.openLinkInLatestEmail(values.get("email"));
		Assert.assertTrue(PasswordResetPage.doesPassworChangeFormExist());
		PasswordResetPage.setResetToken("");
		PasswordResetPage.resetPasswordWithRandomValues();
		Assert.assertEquals(PasswordResetPage.txtResetPasswordErrorMessage().getText(),
				Constant.resetPasswordErrMessageWithInvalidToken);
		Assert.assertEquals(PasswordResetPage.txtResetPasswordTokenErrorMessage().getText(),
				Constant.resetPasswordTokenErrMessage);
	}

	@Test
	public void TC13_ResetPasswordWithDiffrentPassAndConfirmPass() {
		Map<String, String> values = RegisterPage.navigateAndRegisterWithRandomValue();
		RegisterPage.activateAccount(values.get("email"));

		Menu.clickLogIn();
		LoginPage.clickForgotPassword();
		ForgotPasswordPage.sendInstructionsWith(values.get("email"));
		Mailinator.openLinkInLatestEmail(values.get("email"));
		PasswordResetPage.resetPasswordWith(Helper.fakeValuesService.bothify("????????"),
				Helper.fakeValuesService.bothify("????????"));
		Assert.assertEquals(PasswordResetPage.txtResetPasswordErrorMessage().getText(),
				Constant.resetPasswordErrMessageWithInvalidToken);
		Assert.assertEquals(PasswordResetPage.txtResetPasswordConfirmPasswordErrorMessage().getText(),
				Constant.resetPasswordConfirmPasswordErrMessage);

	}

	@Test
	public void TC14_BookMutileTickets() {
		Map<String, String> values = RegisterPage.navigateAndRegisterWithRandomValue();
		RegisterPage.activateAccount(values.get("email"));
		Menu.clickLogIn();
		LoginPage.loginWith(values.get("email"), values.get("password"));
		Menu.clickBookTicket();
		BookTicketPage.selectDepartDate(10);
		BookTicketPage.selectDepartFrom("Nha Trang");
		BookTicketPage.selectArriveAt("Sài Gòn");
		BookTicketPage.selectSeatType("Soft seat with air conditioner");
		BookTicketPage.selectTicketAmount(5);
		BookTicketPage.bookTicket();
		Assert.assertEquals(BookTicketPage.txtBookTicketSuccessMessage().getText(), Constant.bookTicketSuccessMessage);
	}
}
