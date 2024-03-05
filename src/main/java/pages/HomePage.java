package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink= By.cssSelector(".ico-login");
    private final By viewProduct =By.xpath("//a[@href='/build-your-own-computer']");

    public LoginPage clickOnLoginLink(){
        click(loginLink,10);
        return new LoginPage(driver);
    }

    public ProductDetails clickOnViewProduct(){
        click(viewProduct,10);
        return new ProductDetails(driver);
    }


}
