package controls;

import org.openqa.selenium.*;

import driver.DriverInstanceManager;

import java.util.List;

public class BaseControl {
	
	protected By locator;
	DriverInstanceManager driver;
	
	public BaseControl(By by)
	{
		this.locator = by;
	}

	protected void setDriver(DriverInstanceManager driver)
	{
		this.driver = driver;
	}
	
	protected WebDriver getDriver()
	{
		return driver.getDriverInstance();
	}
	
	protected WebElement getElement()
	{
		return getDriver().findElement(this.locator);
	}

	protected List<WebElement> getElements()
	{
		return getDriver().findElements(this.locator);
	}
	
	public boolean isDisplayed()
	{
		try
		{
			return getElement().isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
}
