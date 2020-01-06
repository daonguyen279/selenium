package Common;

import java.util.Locale;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class Helper {
	public static WebDriver driver;

	public static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
	public static Faker faker = new Faker();
}
