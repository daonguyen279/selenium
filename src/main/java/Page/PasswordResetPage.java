package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Common.Helper;

public class PasswordResetPage {

	public static WebElement frmPasswordChange() {
		return Helper.driver.findElement(By.xpath("//form[./fieldset/legend = 'Password Change Form']"));
	}

	public static WebElement tbxNewPassword() {
		return Helper.driver.findElement(By.id("newPassword"));
	}

	public static WebElement tbxConfirmPassword() {
		return Helper.driver.findElement(By.id("confirmPassword"));
	}
	
	public static WebElement tbxResetToken() {
		return Helper.driver.findElement(By.id("resetToken"));
	}

	public static WebElement btnResetPassword() {
		return Helper.driver.findElement(By.xpath("//input[@value='Reset Password']"));
	}

	public static WebElement txtResetPasswordErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".message"));
	}

	public static WebElement txtResetPasswordTokenErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".reset-token .validation-error"));
	}

	public static WebElement txtResetPasswordConfirmPasswordErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".confirm-password .validation-error"));
	}

	public static boolean doesPassworChangeFormExist() {
		try {
			return frmPasswordChange().isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static void setResetToken(String resetToken) {
		tbxResetToken().sendKeys(resetToken);
	}

	public static void resetPasswordWith(String newPassword, String confirmPassword) {
		tbxNewPassword().sendKeys(newPassword);
		tbxConfirmPassword().sendKeys(confirmPassword);

		// scroll down to prevent the bottom bar block the submit button
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", btnResetPassword());

		btnResetPassword().click();
	}
	
	public static void resetPasswordWithRandomValues() {
		final String password = Helper.fakeValuesService.bothify("????????");
		resetPasswordWith(password, password);
	}
}
