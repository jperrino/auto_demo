import java.io.Closeable;
import java.io.IOException;

import helpers.PropertyInstanceManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import driver.DriverExtension;
import driver.DriverInstanceManager;
import data.ExcelDataProvider;

public class BaseTest implements Closeable,ITestListener {

	@BeforeTest
	@Parameters("browser")
	public void initializeDriver(String browserName)
	{
		DriverInstanceManager.browser = browserName;
	}
	
	@DataProvider(name="searchData")
	public Object[][] dataProvider()
	{
		ExcelDataProvider edp = new ExcelDataProvider(PropertyInstanceManager
                                                    .getPropertyInstance()
                                                    .getProperty("ExcelPath"));
		int rows = edp.getRowCount(0);
		int columns = edp.getRowColumnCount(0, 0);
		
		Object[][] data = new Object[rows][columns];
		
		for(int i = 0; i<rows; i++)
		{			
			for(int j = 0; j<columns; j++)
			{
				data[i][j] = edp.getData(0, i, j);
			}
			
		}

		return data;
	}

	@AfterTest
	@Override
	public void close() throws IOException {
		DriverInstanceManager.closeDriver();
		
	}

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        DriverExtension.takeScreenshot(iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
