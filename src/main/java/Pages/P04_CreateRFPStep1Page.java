package Pages;

import Utilities.LogsUtils;
import Utilities.Utils;
import net.bytebuddy.NamingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CreateRFPStep1Page {
    WebDriver driver;
    int random=Utils.generateRandomumber(12);
private final By titleLocator=By.xpath("//input[@name='title']");
private final By descriptionLocator=By.xpath("//textarea[@name='description']");
private final By projectDropDownLocator=By.id("react-select-2-input");
private final By projectSelectionLocator=By.id("react-select-2-option-"+random);
private final By shippingAddressDropDownLocator=By.id("react-select-3-input");
private final By shippingAddressSelectionLocator=By.id("react-select-3-option-"+random);
private final By closeDatePickerLocator=By.xpath("(//button[@aria-label='Choose date'])");
private final By deliveryDatePickerLocator=By.xpath("(//button[@aria-label='Choose date'])[2]");
private final By okButton=By.xpath("//button[text()='OK']");
private final By closeDateSelection=By.xpath("//button[text()='29']");
private final By deliveryDateSelection=By.xpath("//button[text()='30']");
private final By nextButton=By.xpath("//button[@type='submit']");
private final By requestContnetStep2Header=By.xpath("//h4[text()='Request Content']");
    public P04_CreateRFPStep1Page(WebDriver driver) {
        this.driver = driver;
    }
/*public P04_CreateRFPPage setTitle(String title){
    Utils.sendData(driver, titleLocator, title);
    LogsUtils.info("Add RFP Title");
return this;}

public P04_CreateRFPPage setDescription(String description){
    Utils.sendData(driver, descriptionLocator, description);
    LogsUtils.info("Add RFP Description");
    return this;}

public P04_CreateRFPPage openProjectDropDown() throws InterruptedException {
        Utils.click(driver, projectDropDownLocator);
        Utils.click(driver,projectSelectionLocator);

 return this;   }*/
/*public double getQuantities(String random){
List<WebElement> quantities=driver.findElements(quantityLocator);
for(int i=1;i<=quantities.size();i++){
By quantity=By.xpath(("//input[@placeholder='Quantity'])["+i+"]"));
Utils.sendData(driver, quantity, random);
return quantities;}
     *///}
public P05_CreateRFPStep2Page RFPStep1(String title, String description){
    //TODO:Set Title
    Utils.sendData(driver, titleLocator, title);
    LogsUtils.info("Add RFP Title");
    //TODO:Set Description
    Utils.sendData(driver, descriptionLocator, description);
    LogsUtils.info("Add RFP Description");
    //TODO:Open Project Dropdown
    Utils.click(driver, projectDropDownLocator);
    LogsUtils.info(" Project DropDown is opened ");
    //TODO:Select Project Value
    Utils.click(driver,projectSelectionLocator);
    LogsUtils.info(" Project is number"+random +" is selected");
    //TODO:Open Shipping Address Dropdown
   Utils.click(driver,shippingAddressDropDownLocator);
    //TODO:Select ShippingAddress Value
    Utils.click(driver,shippingAddressSelectionLocator);
    //TODO:Open deliveryDate Picker
    Utils.click(driver, deliveryDatePickerLocator);
    //TODO:Select deliveryDate value
    Utils.click(driver, deliveryDateSelection);
    //TODO:Open closeDate Picker
    Utils.click(driver, closeDatePickerLocator);
    //TODO:Select closeDate value
    Utils.click(driver, closeDateSelection);
    Utils.click(driver, okButton);
    //TODO:Click NextButton
    Utils.click(driver, nextButton);
return new P05_CreateRFPStep2Page(driver);
}
public String getStep2Header(){
    return Utils.findWebElement(requestContnetStep2Header).getText();
}
public boolean verifyNavigationFromStep1(){
    //String actualText = Utils.findWebElement(requestContnetStep2Header).getText();
    return (getStep2Header()).equals("Request Content");
}}
