package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

public class Textbox extends BaseControl{
	
	public Textbox(By by)
	{
		super(by);
	}
	
	public String getText()
	{
		try
		{
			return getElement().getAttribute("value");
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public void sendText(String text)
	{
		try
		{
			getElement().clear();
			getElement().sendKeys(text);
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void submit()
	{
		try
		{
			getElement().sendKeys(Keys.ENTER);
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
