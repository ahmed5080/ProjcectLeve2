package login;

import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class T {


    ReadDataFromJson readDataFromJson;
    @Test
    public void T1() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().URL);

    }
    @Test
    public void T2() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        System.out.println(
                readDataFromJson.readJsonFile().Login.ValidCredentials.Email);
        System.out.println(
                readDataFromJson.readJsonFile().Login.ValidCredentials.Password);


    }
    @Test
    public void T3() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidUsername.Username);
        System.out.println(
                readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidUsername.Password);


    }
    @Test
    public void T4() throws FileNotFoundException {
        readDataFromJson=new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidPassword.Username);
        System.out.println(
                readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidPassword.Password);


    }
}
