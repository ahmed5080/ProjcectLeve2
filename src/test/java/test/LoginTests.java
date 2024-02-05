package test;

import base.Base;
import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests extends Base {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        var loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(readDataFromJson.readJsonFile().Login.ValidCredentials.Email);
        loginPage.insertPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
        loginPage.clickOnLoginButton();
    }
}
