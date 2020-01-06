package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Helper;

public class ForgotPasswordPage {
	public static WebElement tbxEmail() {
		return Helper.driver.findElement(By.id("email"));
	}

	public static WebElement btnSendInstructions() {
		return Helper.driver.findElement(By.xpath("//input[@value='Send Instructions']"));
	}

	public static void sendInstructionsWith(String email) {
		tbxEmail().sendKeys(email);
		btnSendInstructions().click();
	}
}
