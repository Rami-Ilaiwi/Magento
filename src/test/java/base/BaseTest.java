package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Utils;

public class BaseTest {

	public static WebDriver driver;
	public static Utils utils = new Utils();
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static WebDriverWait wait;
	public static Logger log;

	@BeforeTest
	public void setup() throws IOException {
		if (driver == null) {
			fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log = LogManager.getLogger(BaseTest.class);
			String url = prop.getProperty("url");

			log.info("Navigate to url: " + url);

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log = LogManager.getLogger(BaseTest.class);
			String url = prop.getProperty("url");

			log.info("Navigate to url: " + url);

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			utils.takeScreenshot(driver, driver.getTitle());
		}
	}

	@AfterTest
	public void tearDown() {
		log.info("Teardown the browser.");
		driver.close();
	}
}
