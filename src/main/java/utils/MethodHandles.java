package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {
    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public MethodHandles(WebDriver driver){
        this.driver=driver;

    }

    private final By barNotification = By.cssSelector("div[id='bar-notification']");

    private final By loader = By.cssSelector(".ajax-loading-block-window");

    public WebElement webElement(By locator) {

        return driver.findElement(locator);
    }
    protected void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)
        ));
    }
    protected void invisibilityOfElement(By locator, int time){
        wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOf(webElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)
        ));
    }

    protected void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void click(By locator,int time){
        explicitWait(locator,time);
        scrollIntoView(driver,webElement(locator));
        webElement(locator).click();
    }
    protected void sendKeys(By locator,int time,String text){
        explicitWait(locator,time);
        scrollIntoView(driver,webElement(locator));
        webElement(locator).sendKeys(text);
    }
    protected boolean isDisplayed(By locator, int time){
        invisibilityOfElement(loader,10);
        explicitWait(locator,time);
        return webElement(locator).isDisplayed();
    }

    public boolean barNotificationIsDisplayed(){
        invisibilityOfElement(loader,10);
        return isDisplayed(barNotification,10);
    }



}
