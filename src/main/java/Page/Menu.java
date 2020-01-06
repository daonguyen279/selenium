package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Common.Helper;

public class Menu {
	public static WebElement lnkMyAccount() {
		return Helper.driver.findElement(By.id("account"));
	}

	public static WebElement lnkRegister() {
		return Helper.driver.findElement(By.xpath("//span[.='Register']"));
	}

	public static WebElement lnkLogIn() {
		return Helper.driver.findElement(By.xpath("//span[.='Login']"));
	}

	public static WebElement lnkChangePassword() {
		return Helper.driver.findElement(By.xpath("//span[.='Change password']"));
	}


	public static WebElement txtLoginSuccessMessage() {
		return Helper.driver.findElement(By.cssSelector(".account"));
	}

	public static WebElement lnkLogout() {
		return Helper.driver.findElement(By.xpath("//span[.='Log out']"));
	}

	public static WebElement lnkBookTicket() {
		return Helper.driver.findElement(By.xpath("//span[.='Book ticket']"));
	}

	public static void clickMyAccount() {
		lnkMyAccount().click();
	}

	public static void clickRegister() {
		lnkRegister().click();
	}

	public static void clickLogIn() {
		lnkLogIn().click();
	}
	
	public static void clickChangePassword() {
		lnkChangePassword().click();
	}

	public static void clickLogout() {
		try {
			lnkLogout().click();
		} catch (NoSuchElementException ex) {

		}
	}

	public static void clickBookTicket() {
		lnkBookTicket().click();
	}
}