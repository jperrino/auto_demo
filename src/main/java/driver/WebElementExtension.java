package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebElementExtension {

    public static WebElement findElementWait(By by) {
        return new WebDriverWait(DriverInstanceManager.getDriverInstance(), DriverInstanceManager.getTimeOut())
                .<WebElement>until(x -> x.findElement(by));
    }

//    public static <T> T findElement(T t, By by){
//        T tt = DriverInstanceManager.getDriverInstance().findElement(by);
//        return tt;
//    }

    public static WebElement findElementWait(By by, int timeout) {
        return new WebDriverWait(DriverInstanceManager.getDriverInstance(), timeout)
                .<WebElement>until(x -> x.findElement(by));
    }

    public static Iterable<WebElement> findElementsWait(By by) {
        return new WebDriverWait(DriverInstanceManager.getDriverInstance(),DriverInstanceManager.getTimeOut())
                .<Iterable<WebElement>>until(x -> x.findElements(by));
    }

    public static WebElement findElementWait(WebElement webElement, By by, int timeout) {
        return new WebDriverWait(DriverInstanceManager.getDriverInstance(), timeout)
                .<WebElement>until(x -> webElement.findElement(by));
    }

    public static Iterable<WebElement> findElementsWait(WebElement webElement, By by) {
        return new WebDriverWait(DriverInstanceManager.getDriverInstance(),DriverInstanceManager.getTimeOut())
                .<Iterable<WebElement>>until(x -> webElement.findElements(by));
    }

    public static boolean isClickable(WebElement webElement) {
        return ExpectedConditions.elementToBeClickable(webElement).apply(DriverInstanceManager.getDriverInstance()) != null;
    }

    public static void clickWait(WebElement webElement) {
        new WebDriverWait(DriverInstanceManager.getDriverInstance(),DriverInstanceManager.getTimeOut())
                .until(x -> isClickable(webElement));
        webElement.click();
    }

    public static boolean elementVisible(WebElement element, By by) {
        try {
            return element.findElement(by).isDisplayed();
        }
        catch (WebDriverException e) {
            return false;
        }
    }

    public static void innerElementInvisible(WebElement webElement, By by) {
        new WebDriverWait(DriverInstanceManager.getDriverInstance(),DriverInstanceManager.getTimeOut())
                .until(ExpectedConditions.invisibilityOf(webElement.findElement(by)));
    }

    public static boolean outerElementVisible(WebElement webelement, By by) {
        try {
            return webelement.findElement(By.xpath("..")).findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public static List<String> getElementsText(List<WebElement> webElements){
        List<String> elementsText = new ArrayList<>();

        try{
            for (WebElement e: webElements) {
                elementsText.add(e.getText().toLowerCase());
            }

            if(elementsText.size() == 1){
                elementsText = Arrays.asList(elementsText.get(0).split("\n"));
            }
            return elementsText;
        }
        catch (NoSuchElementException e){

            return null;
        }
    }
}
