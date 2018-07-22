package driver;


import java.util.concurrent.TimeUnit;
import helpers.PropertyInstanceManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class DriverInstanceManager {
	private static WebDriver driver;
	private static Actions actions;
	public static String browser;
	private static int timeout_seconds = 5;
	
	private static WebDriver createDriver()
	{
		switch(browser.toLowerCase())
		{
		case "ff":
			System.setProperty("webdriver.gecko.driver",
								PropertyInstanceManager.getPropertyInstance().getProperty("FireFoxDriver"));
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setAcceptInsecureCerts(true);
			return new FirefoxDriver(ffOptions);
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
								PropertyInstanceManager.getPropertyInstance().getProperty("ChromeDriver"));
			ChromeOptions crOptions = new ChromeOptions();
			crOptions.addArguments("disable-infobars");
			return new ChromeDriver(crOptions);
		default:
			System.out.println("Invalid driver");
			return null;
		}
	}
	
	
	public static WebDriver getDriverInstance()
	{
		if(driver == null)
		{
			synchronized (DriverInstanceManager.class)
			{
				driver = createDriver();
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
	
	public static Actions getActionInstance()
	{
		if(actions == null)
		{
			synchronized(DriverInstanceManager.class)
			{
				actions = new Actions(getDriverInstance());
			}
		}
		return actions;
	}

	public static void setTimeOut(int seconds)
	{
		timeout_seconds = seconds;
	}
	
	public static int getTimeOut()
	{
		return timeout_seconds;
	}
	
	
	public static void closeDriver(){
		if(driver != null)
		{
			driver.quit();
			driver = null;
		}
	}

}
