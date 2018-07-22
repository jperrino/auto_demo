import driver.DriverInstanceManager;
import helpers.PropertyInstanceManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.ResultPage;

public class Test1 extends BaseTest {
	
	private GooglePage googlePage;
	private ResultPage resultPage;
	
	public Test1()
	{
		this.resultPage = new ResultPage();
		this.googlePage = new GooglePage();
	}

	@BeforeMethod
	public void goHome(){
		DriverInstanceManager.getDriverInstance()
				.navigate()
				.to(PropertyInstanceManager
						.getPropertyInstance()
						.getProperty("URL"));
	}
	
	@Test(dataProvider = "searchData")
	public void test1(String title, String link) throws InterruptedException{

		googlePage.search_txtb().sendText(title);
		googlePage.search_txtb().submit();
		googlePage.result_link(link).click();
		Assert.assertTrue(resultPage.
							getTitle().
							toLowerCase().
							contains(title),
							"Result Page Title is different from expected");
	}
}