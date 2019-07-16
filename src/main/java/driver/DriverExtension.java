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

public class DriverExtension extends DriverInstanceManager {

	public WebElement findElementWait(By by) {
		return new WebDriverWait(super.getDriverInstance(), super.getTimeOut()).until(x -> x.findElement(by));
	}

	public Iterable<WebElement> findElementsWait(By by) {
		return new WebDriverWait(super.getDriverInstance(), super.getTimeOut()).until(x -> x.findElements(by));
	}

	public boolean elementExists(By by) {
		try {
			return super.getDriverInstance().findElement(by) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean elementIsClickable(By by) {
		try {
			return ExpectedConditions.elementToBeClickable(by).apply(super.getDriverInstance()) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean elementIsVisible(By by) {
		try {
			return ExpectedConditions.visibilityOfElementLocated(by).apply(super.getDriverInstance()) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean elementIsNotVisible(By by) {

		try {
			return ExpectedConditions.invisibilityOfElementLocated(by).apply(super.getDriverInstance()) != null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void takeScreenshot(String testName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		TakesScreenshot ts = (TakesScreenshot) super.getDriverInstance();

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
