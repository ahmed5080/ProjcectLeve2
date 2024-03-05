package products;

import base.Base;
import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTests extends Base {

    @Test
    public void testViewProduct() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        var productDetails = homePage.clickOnViewProduct();
        productDetails.clickAddHDD();
        productDetails.clickOnDropdownList("2 GB");
        productDetails.clickAddCart();

    }


}
