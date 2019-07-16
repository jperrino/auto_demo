package pageObjects;
import driver.DriverInstanceManager;
import org.openqa.selenium.By;

public class ResultPage extends BasePageObject {

    public ResultPage(DriverInstanceManager driver)
    {
        super(By.xpath(""));
        super.setDriver(driver);
    }
/*
    public void setDriver(DriverInstanceManager driver)
    {
        super.setDriver(driver);
    }
 */

}
