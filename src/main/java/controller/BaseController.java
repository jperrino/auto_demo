package controller;

import org.openqa.selenium.*;

import driver.DriverInstanceManager;

import java.util.List;

public class BaseController {
	
	protected By locator;
	
	public BaseController(By by)
	{
		this.locator = by;
	}
	
	protected WebDriver getDriver()
	{
		return DriverInstanceManager.getDriverInstance();
	}
	
	protected WebElement getElement() { return getDriver().findElement(this.locator); }

	protected List<WebElement> getElements() { return getDriver().findElements(this.locator); }
	
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
