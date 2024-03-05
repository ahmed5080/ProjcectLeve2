package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.MethodHandles;

public class ProductDetails extends MethodHandles {
    public ProductDetails(WebDriver driver) {

        super(driver);
    }
    Select select;
    private final By addCart=By.id("add-to-cart-button-1");

    private final By addHDD= By.id("product_attribute_3_6");
    private final By dropdownList=By.id("product_attribute_2");
    private final By selectValue = By.xpath("//option[@value='2']");
    private final By barNotification = By.cssSelector("div[id='bar-notification']");

    private final By loader = By.cssSelector(".ajax-loading-block-window");



    public void clickAddCart(){
        click(addCart,10);

    }
    public void clickAddHDD(){
        click(addHDD,10);
    }
    public void clickOnDropdownList(String visibleText){
        select=new Select(driver.findElement(dropdownList));
        select.selectByVisibleText(visibleText);
    }
    public String getSelect(){
        return driver.findElement(selectValue).getText();
    }

    public String getValidationMessage(){
        return driver.findElement(barNotification).getText();

    }


}
