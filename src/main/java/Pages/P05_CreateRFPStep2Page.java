package Pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CreateRFPStep2Page {
    WebDriver driver;

    public P05_CreateRFPStep2Page(WebDriver driver) {
        this.driver = driver;
    }

    int randomNumber= Utils.generateRandomumber(15);
    private final By section1NameLocator=By.name("sections[0].name");
    private final By addNewSectionButton=By.xpath("//button[contains(text(),'Add New ')]");
    private final By nextButton=By.xpath("//button[@type='submit']");
    private final By addCatalogButtonLocator=By.xpath("//button[contains(text(),'Add Catalog ')]");
    private final By addCustomButtonLocator=By.xpath("//button[contains(text(),'Add Custom ')]");
    private final By addQuestionButtonLocator=By.xpath("//button[contains(text(),'Add Question ')]");
    private final By catalogItemDropdown=By.id("react-select-4-input");
    private final By catalogItemSelectionLocator=By.id("react-select-4-option-"+randomNumber);
    private final By quantityLocator=By.xpath("//input[@placeholder='Quantity']");
    private final By customItemName=By.xpath("//input[@placeholder='Item Name']");

    public P06_CreateRFPStep3Page RFPStep2(String sectionName, double quantity, String itemName) throws InterruptedException {
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
//TODO:Select CustomItem
//Utils.click(driver, addCustomButtonLocator);
//Utils.sendData(driver, customItemName, itemName);
//Utils.sendData(driver, q, );
        return new P06_CreateRFPStep3Page(driver);

    }}
