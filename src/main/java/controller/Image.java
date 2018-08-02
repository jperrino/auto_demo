package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Image extends BaseController {
	
	public Image(By by)
	{
		super(by);
	}
	
	public String getSource()
	{
		try
		{
			return getElement().getAttribute("src");
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}

}
