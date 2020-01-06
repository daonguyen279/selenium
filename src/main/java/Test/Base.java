package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Common.Constant;
import Common.Helper;
import Page.Menu;

public class Base {
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
		Helper.driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		Helper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helper.driver.get(Constant.baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		Menu.clickLogout();
	}

	@AfterClass
	public void afterClass() {
		Helper.driver.quit();
	}
}
