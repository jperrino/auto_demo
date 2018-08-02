package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverInstanceManager;

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
	
	protected WebElement getElement()
	{
		return getDriver().findElement(this.locator);
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
	
	public boolean isEnabled()
	{
		try
		{
			return getElement().isEnabled();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public boolean isSelected()
	{
		try
		{
			return getElement().isSelected();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
}
