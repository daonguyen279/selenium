package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Helper;

public class LoginPage {
	public static WebElement tbxUserName() {
		return Helper.driver.findElement(By.id("username"));
	}

	public static WebElement tbxPassword() {
		return Helper.driver.findElement(By.id("password"));
	}

	public static WebElement btnLogIn() {
		return Helper.driver.findElement(By.xpath("//input[@value='login']"));
	}
	
	public static WebElement lnkForgotPassword() {
		return Helper.driver.findElement(By.xpath("//a[@href = '/Account/ForgotPassword.cshtml']"));
	}

	/*
	 * public static WebElement txt_EmailErrorMessage() { return
	 * Helper.driver.findElement(By.cssSelector(".validation-error")); }
	 * 
	 * public static WebElement txt_PassErrorMessage() { return
	 * Helper.driver.findElement(By.cssSelector(".validation-error")); }
	 */

	public static WebElement txtLoginErrorMessage() {
		return Helper.driver.findElement(By.cssSelector(".message"));
	}

	public static void loginWith(String Username, String Password) {
		tbxUserName().sendKeys(Username);
		tbxPassword().sendKeys(Password);
		btnLogIn().click();
	}

	public static void clickForgotPassword() {
		lnkForgotPassword().click();
	}
}
