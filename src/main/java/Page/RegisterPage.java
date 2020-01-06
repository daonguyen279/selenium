package Page;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Common.Helper;

public class RegisterPage {
	public static WebElement tbxEmail() {
		return Helper.driver.findElement(By.id("email"));
	}

	public static WebElement tbxPassword() {
		return Helper.driver.findElement(By.id("password"));
	}

	public static WebElement tbxConfirmPassword() {
		return Helper.driver.findElement(By.id("confirmPassword"));
	}

	public static WebElement tbxPid() {
		return Helper.driver.findElement(By.id("pid"));
	}

	public static WebElement btnRegister() {
		return Helper.driver.findElement(By.xpath("//input[@value='Register']"));
	}

	public static WebElement txtRegisterSuccessMessage() {
		return Helper.driver.findElement(By.xpath("//h1[.='Thank you for registering your account']"));
	}

	public static WebElement txtRegisterErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".message"));
	}

	public static WebElement txtRegisterPasswordErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".password .validation-error"));
	}

	public static WebElement txtRegisterPidErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".pid-number .validation-error"));
	}

	public static void registerWith(String email, String password, String pid) {
		tbxEmail().sendKeys(email);
		tbxPassword().sendKeys(password);
		tbxConfirmPassword().sendKeys(password);
		tbxPid().sendKeys(pid);

		// scroll down to prevent the bottom bar block the submit button
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", btnRegister());

		btnRegister().click();
	}

	@SuppressWarnings("serial")
	public static Map<String, String> registerWithRandomValue() {
		final String email = Helper.fakeValuesService.bothify("????##@mailinator.com");
		final String password = Helper.fakeValuesService.bothify("????????");
		final String pid = Helper.fakeValuesService.bothify("????????");
		tbxEmail().sendKeys(email);
		tbxPassword().sendKeys(password);
		tbxConfirmPassword().sendKeys(password);
		tbxPid().sendKeys(pid);

		// scroll down to prevent the bottom bar block the submit button
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", btnRegister());

		btnRegister().click();

		return new HashMap<String, String>() {
			{
				put("email", email);
				put("password", password);
				put("pid", pid);
			}
		};
	}

	public static Map<String, String> navigateAndRegisterWithRandomValue() {
		Menu.clickRegister();
		return registerWithRandomValue();
	}

	public static void activateAccount(String email) {
		Mailinator.openInbox(email);
		Mailinator.clickLatestEmail();
		Mailinator.openLinkInEmail();
	}

	public static boolean doesRegisterSuccessMessageExist() {
		try {
			return txtRegisterSuccessMessage().isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
