package Pages;

import Utilities.LogsUtils;
import Utilities.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CreateRFPPage {
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
private final By section1NameLocator=By.name("sections[0].name");
private final By addNewSectionButton=By.xpath("//button[contains(text(),'Add New ')]");
private final By nextButton=By.xpath("//button[@type='submit']");
private final By addCatalogButtonLocator=By.xpath("//button[contains(text(),'Add Catalog ')]");
private final By addCustomButtonLocator=By.xpath("//button[contains(text(),'Add Custom ')]");
private final By addQuestionButtonLocator=By.xpath("//button[contains(text(),'Add Question ')]");
private final By catalogItemDropdown=By.id("react-select-4-input");
    private final By catalogItemSelectionLocator=By.id("react-select-4-option-"+random);
private final By quantityLocator=By.xpath("//input[@placeholder='Quantity']");
    public P04_CreateRFPPage(WebDriver driver) {
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

public P04_CreateRFPPage RFPStep1(String title,String description){
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
    //TODO:Open delivertDate Picker
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
return this;
}
   public P04_CreateRFPPage RFPStep2(String sectionName,double quantity) throws InterruptedException {
//TODO:Add Section Name
 Utils.sendData(driver, section1NameLocator, sectionName);
 //TODO:Add Catalog Item
Utils.click(driver, addCatalogButtonLocator);

//TODO:Click on select catalog Item
       Utils.click(driver, catalogItemDropdown);
 //TODO:Select Catalog Item
  Utils.click(driver, catalogItemSelectionLocator);
  //TODO:Select Quantity
  Utils.sendData(driver, quantityLocator, String.valueOf(quantity));
Utils.click(driver, nextButton);
return this;
    }

}
