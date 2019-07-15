package pageObjects;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverInstanceManager;
import org.openqa.selenium.remote.RemoteWebElement;

public class BasePageObject implements Closeable  {

	protected By locator;
	
	public BasePageObject(By by) {
		this.locator = by;
	}
	
	protected WebDriver getDriver() {
		return DriverInstanceManager.getDriverInstance();
	}
	
	protected WebElement findElementInside(By by) {
		return getDriver().findElement(this.locator).findElement(by);
	}
	
	protected List<WebElement> findElementsInside(By by) {
		return getDriver().findElement(this.locator).findElements(by);
	}

	protected WebElement getElement()
	{
		return getDriver().findElement(this.locator);
	}

	protected List<WebElement> getElements() { return getDriver().findElements(this.locator); }
	
	@Override
	public void close() throws IOException {
		DriverInstanceManager.closeDriver();
	}

	protected WebElement castElement(RemoteWebElement e){ return (WebElement) e; }
	
	public String getUrl() {
		return getDriver().getCurrentUrl();
	}

	public String getTitle(){
		return getDriver().getTitle();
	}

	public String getInnerText() {return getDriver().findElement(this.locator).getText();}
}
