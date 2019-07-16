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
	private  WebDriver driver;
	private  Actions actions;
	public  String browser;
	private  int timeout_seconds = 5;
	
	private WebDriver createDriver()
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
	
	
	public WebDriver getDriverInstance()
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
	
	public Actions getActionInstance()
	{
		if(actions == null)
		{
			synchronized(DriverInstanceManager.class)
			{
				actions = new Actions(this.getDriverInstance());
			}
		}
		return actions;
	}

	public void wait(int seconds){

		try {
			synchronized (this.getDriverInstance())
			{
				this.getDriverInstance().wait(seconds * 1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Driver interrupted exception");
			e.printStackTrace();
		}
	}

	public void setBrowser(String browser)
	{
		this.browser = browser;
	}

	public  void setTimeOut(int seconds)
	{
		timeout_seconds = seconds;
	}
	
	public  int getTimeOut()
	{
		return timeout_seconds;
	}
	
	
	public  void closeDriver(){
		if(driver != null)
		{
			driver.quit();
			driver = null;
		}
	}

}
