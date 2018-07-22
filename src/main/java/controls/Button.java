package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Button extends BaseControl {
	
	public Button(By by)
	{
		super(by);
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
