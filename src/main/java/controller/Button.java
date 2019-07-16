package controller;

import driver.DriverInstanceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Button extends BaseController {
	
	public Button(By by)
	{
		super(by);
	}

	public Button(By by, DriverInstanceManager driver)
	{
		super(by);
		super.setDriver(driver);
	}

	public void click()
	{
		try
		{
			getElement().click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public String getText()
	{
		try
		{
			return getElement().getText();
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}

}
