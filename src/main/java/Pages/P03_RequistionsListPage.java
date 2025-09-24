package Pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_RequistionsListPage {
    private WebDriver driver;
    private final By createButtonLocator=By.xpath("//span[contains(text(),'Create')]");
    private final By createRFPLocator=By.xpath("//span[text()='Request for Proposal (RFP)']");
    public P03_RequistionsListPage(WebDriver driver) {
    this.driver=driver;}
    public P03_RequistionsListPage clickOnCreateButton(){
        Utils.click(driver, createButtonLocator);
    return this;}
    public P04_CreateRFPStep1Page createRFP(){
        Utils.click(driver, createRFPLocator);
    return new P04_CreateRFPStep1Page(driver);}
}
