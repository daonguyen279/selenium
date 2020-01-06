package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Helper;

public class ChangePasswordPage {
	public static WebElement tbxCurrentPassword() {
		return Helper.driver.findElement(By.id("currentPassword"));
	}

	public static WebElement tbxNewPassword() {
		return Helper.driver.findElement(By.id("newPassword"));
	}

	public static WebElement tbxConfirmPassword() {
		return Helper.driver.findElement(By.id("confirmPassword"));
	}

	public static WebElement btnChangePassword() {
		return Helper.driver.findElement(By.xpath("//input[@value='Change Password']"));
	}

	public static WebElement txtChangePasswordErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".message"));
	}

	public static void changePasswordWith(String currentPassword, String newPassword, String confirmPassword) {
		tbxCurrentPassword().sendKeys(currentPassword);
		tbxNewPassword().sendKeys(newPassword);
		tbxConfirmPassword().sendKeys(confirmPassword);

		// scroll down to prevent the bottom bar block the submit button
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", btnChangePassword());

		btnChangePassword().click();
	}
}
