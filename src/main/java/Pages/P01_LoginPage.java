package Pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
 WebDriver driver;
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private  By emailLocator = By.id("E-mail or phone number");
    private By passwordLocator = By.id("outlined-adornment-password");
    private By rememberMeLoctor = By.name("rememberMe");
    private By loginLocator = By.xpath("//button[@type='submit']");
    private By numberLocator=By.id("phone-input");
   private By countryDropdownLocator=By.xpath("//div[@class='selected-flag']");
private By searchCodeLocator=By.xpath("//input[@type='search']");
private By selectEgyptCodeLocator=By.xpath("//li[@data-country-code='eg']");
 public P01_LoginPage addEmail(String email){
Utils.sendData(driver, emailLocator, email);
return this;}

public P01_LoginPage addnumber(String number){
Utils.sendData(driver, emailLocator, number);
return this;
}
public P01_LoginPage changenumberCode(String number){
 Utils.click(driver, countryDropdownLocator);
 Utils.sendData(driver, searchCodeLocator, "eg");
 Utils.generalWait(driver);
 Utils.click(driver, selectEgyptCodeLocator);
 Utils.sendData(driver, numberLocator, number);
 return this;
 }
    public P01_LoginPage addPassword(String password){
        Utils.sendData(driver, passwordLocator, password);
        return this;}
    public P01_LoginPage rememberME(){

        Utils.checkBox(driver, rememberMeLoctor);
        return this;}

public P02_HomePage Login(){
Utils.click(driver, loginLocator);
return new P02_HomePage(driver);
}
}
