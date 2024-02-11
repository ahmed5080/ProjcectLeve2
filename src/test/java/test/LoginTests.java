package test;

import base.Base;
import org.testng.annotations.DataProvider;
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

    @Test
    public void testInvalidEmail() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        var loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidEmail.Email);
        loginPage.insertPassword(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidEmail.Password);
        loginPage.clickOnLoginButton();
    }

    @DataProvider
    public Object[][] dataProviderForEmail() throws FileNotFoundException {
        return dataModel().Login1;
    }

    @Test(dataProvider = "dataProviderForEmail")
    public void testSuccessfulLogin(String username,String password) {
        var loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
    }

}
