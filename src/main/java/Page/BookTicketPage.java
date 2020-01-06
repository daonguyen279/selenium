package Page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.Helper;

public class BookTicketPage {
	public static WebElement frmBookTicket() {
		return Helper.driver.findElement(By.xpath("//form[./fieldset/legend = 'Book ticket form']"));
	}

	public static WebElement sltDepartDate() {
		return Helper.driver.findElement(By.xpath("//select[@name = 'Date']"));
	}

	public static WebElement sltDepartFrom() {
		return Helper.driver.findElement(By.xpath("//select[@name = 'DepartStation']"));
	}

	public static WebElement sltArriveAt() {
		return Helper.driver.findElement(By.xpath("//select[@name = 'ArriveStation']"));
	}

	public static WebElement sltSeatType() {
		return Helper.driver.findElement(By.xpath("//select[@name = 'SeatType']"));
	}

	public static WebElement sltTicketAmount() {
		return Helper.driver.findElement(By.xpath("//select[@name = 'TicketAmount']"));
	}

	public static WebElement btnBookTicket() {
		return Helper.driver.findElement(By.xpath("//input[@value='Book ticket']"));
	}

	public static WebElement txtBookTicketSuccessMessage() {
		return Helper.driver.findElement(By.cssSelector("#content h1"));
	}

	public static boolean doesBookTicketFormExist() {
		try {
			return frmBookTicket().isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public static void selectDepartDate(int value) {
		String pattern = "M/d/yyyy";
		String date = DateTimeFormatter.ofPattern(pattern).format(LocalDate.now().plusDays(value));

		Select select = new Select(sltDepartDate());
		select.selectByVisibleText(date);
	}

	public static void selectDepartFrom(String value) {
		Select select = new Select(sltDepartFrom());
		select.selectByVisibleText(StringEscapeUtils.escapeHtml4(value));
	}

	public static void selectArriveAt(String value) {
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", sltArriveAt());
		Select select = new Select(sltArriveAt());
		select.selectByVisibleText(StringEscapeUtils.escapeHtml4(value));

	}

	public static void selectSeatType(String value) {
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", sltSeatType());
		Select select = new Select(sltSeatType());
		select.selectByVisibleText(value);

	}

	public static void selectTicketAmount(int value) {
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", sltTicketAmount());
		Select select = new Select(sltTicketAmount());
		select.selectByVisibleText(Integer.toString(value));
	}

	public static void bookTicket() {
		// scroll down to prevent the bottom bar block the submit button
		((JavascriptExecutor) Helper.driver).executeScript("arguments[0].scrollIntoView(true);", btnBookTicket());

		btnBookTicket().click();
	}
}
