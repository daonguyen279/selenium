package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Helper;

public class Mailinator {
	static String inboxUrl = "https://www.mailinator.com/v3/#/#inboxpane";

	public static WebElement tbxInbox() {
		return Helper.driver.findElement(By.id("inbox_field"));
	}

	public static WebElement elmFirstEmail() {
		return Helper.driver.findElement(By.cssSelector("#inboxpane .table-responsive tbody tr td a"));
	}

	public static WebElement iframeMsgBody() {
		return Helper.driver.findElement(By.id("msg_body"));
	}

	public static WebElement lnkInEmail() {
		return Helper.driver.findElement(By.xpath("html/body/a"));
	}

	public static void openInbox(String email) {
		Helper.driver.get(inboxUrl);
		tbxInbox().clear();
		tbxInbox().sendKeys(email.replace("@mailinator.com", ""));
		tbxInbox().sendKeys(Keys.ENTER);
	}

	public static void clickLatestEmail() {
		new WebDriverWait(Helper.driver, 10).until(ExpectedConditions.visibilityOf(elmFirstEmail()));
		elmFirstEmail().click();
	}

	public static void openLinkInEmail() {
		new WebDriverWait(Helper.driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeMsgBody()));
		new WebDriverWait(Helper.driver, 10).until(ExpectedConditions.visibilityOf(lnkInEmail()));
		String link = lnkInEmail().getAttribute("href");
		Helper.driver.get(link);
		Helper.driver.switchTo().defaultContent();
	}
	
	public static void openLinkInLatestEmail(String email) {
		openInbox(email);
		clickLatestEmail();
		openLinkInEmail();
	}
}
