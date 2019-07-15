package driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import helpers.PropertyInstanceManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverExtension {

	public static WebElement findElementWait(By by) {
		return new WebDriverWait(DriverInstanceManager.getDriverInstance(), DriverInstanceManager.getTimeOut()).until(x -> x.findElement(by));
	}

	public static Iterable<WebElement> findElementsWait(By by) {
		return new WebDriverWait(DriverInstanceManager.getDriverInstance(), DriverInstanceManager.getTimeOut()).until(x -> x.findElements(by));
	}

	public static boolean elementExists(By by) {
		try {
			return DriverInstanceManager.getDriverInstance().findElement(by) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean elementIsClickable(By by) {
		try {
			return ExpectedConditions.elementToBeClickable(by).apply(DriverInstanceManager.getDriverInstance()) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean elementIsVisible(By by) {
		try {
			return ExpectedConditions.visibilityOfElementLocated(by).apply(DriverInstanceManager.getDriverInstance()) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean elementIsNotVisible(By by) {

		try {
			return ExpectedConditions.invisibilityOfElementLocated(by).apply(DriverInstanceManager.getDriverInstance()) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void takeScreenshot(String testName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		TakesScreenshot ts = (TakesScreenshot) DriverInstanceManager.getDriverInstance();

		try {
			FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),
					new File(PropertyInstanceManager.
							getPropertyInstance().
							getProperty("ScreenshotFolder") + testName + "/ss" + dtf.format(LocalDateTime.now()) + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
