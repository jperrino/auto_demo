import driver.DriverInstanceManager;
import helpers.PropertyInstanceManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.GooglePage;
import pageObjects.ResultPage;

public class Test1 extends BaseTest {
	
	private GooglePage googlePage;
	private ResultPage resultPage;

	@BeforeTest(dependsOnMethods = "initializeDriver")
	public void initializeTest()
	{
		this.resultPage = new ResultPage(driver);
		this.googlePage = new GooglePage(driver);
		//googlePage.setDriver(driver);
		//resultPage.setDriver(driver);
	}

	@BeforeMethod
	public void goHome(){
		driver.getDriverInstance()
				.navigate()
				.to(PropertyInstanceManager
						.getPropertyInstance()
						.getProperty("URL"));
	}
	
	@Test(dataProvider = "searchData")
	public void test1(String title, String link) throws InterruptedException{

		//googlePage.setDriver(driver);
		//resultPage.setDriver(driver);
		googlePage.search_txtb().sendText(title);
		googlePage.search_txtb().submit();
		googlePage.result_link(link).sendEnter();
		Assert.assertTrue(resultPage.
							getTitle().
							toLowerCase().
							contains(title),
							"Result Page Title is different from expected");
	}
}