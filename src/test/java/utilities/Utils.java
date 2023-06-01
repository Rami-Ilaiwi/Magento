package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	public String getRandomEmail() {
		return "testuser" + System.currentTimeMillis() + "@example.com";
	}

	public void takeScreenshot(WebDriver driver, String name) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("logs/screenshots/" + name + ".png"));
	}
}
