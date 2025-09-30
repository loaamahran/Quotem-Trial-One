package Pages;

import Utilities.LogsUtils;
import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CreateRFPStep2Page {
    WebDriver driver;

    public P05_CreateRFPStep2Page(WebDriver driver) {
        this.driver = driver;
    }

    int randomNumber= Utils.generateRandomumber(6);
    private final By section1NameLocator=By.name("sections[0].name");
    private final By addNewSectionButton=By.xpath("//button[contains(text(),'Add New ')]");
    private final By nextButton=By.xpath("//button[@type='submit']");
    //private final By addCatalogButtonLocator=By.xpath("//button[contains(text(),'Add Catalog ')]");
    private final By addCustomButtonLocator=By.xpath("//button[contains(text(),'Add Custom ')]");
    private final By addQuestionButtonLocator=By.xpath("//button[contains(text(),'Add Question ')]");
    private final By catalogItemDropdown=By.id("react-select-4-input");
    private final By catalogItemSelectionLocator=By.id("react-select-4-option-"+randomNumber);
    private final By quantityLocator=By.xpath("//input[@placeholder='Quantity']");
    private final By customItemName=By.xpath("//input[@placeholder='Item Name']");
//TODO:Add Random Number of Sections with Random Names
public P05_CreateRFPStep2Page createSection(String sectionName){
int num=Utils.generateRandomumber(4);
for (int i=0;i<=num;i++){
    By name=By.name("sections["+i+"].name");
    Utils.click(driver,addNewSectionButton);
    Utils.sendData(driver,name,sectionName);
    LogsUtils.info("Section "+i+" Name is added"+sectionName);}



    LogsUtils.info("Number of generated sections are: "+(num+1));


 return this;
}
    public P05_CreateRFPStep2Page createItems(){
        int num=Utils.generateRandomumber(5);
        {

        for (int i=1;i<=num;i++)
        {final By addCatalogButtonLocator=By.xpath("(//button[contains(text(),'Add Catalog ')])["+i+"]");

            Utils.click(driver, addCatalogButtonLocator);

        }
    return this;

    }}
    public P06_CreateRFPStep3Page RFPStep2( double quantity, String itemName) throws InterruptedException {

        //TODO:Add Catalog Item
       // Utils.click(driver, addCatalogButtonLocator);

//TODO:Click on select catalog Item
       // Utils.click(driver, catalogItemDropdown);
        //TODO:Select Catalog Item
       // Utils.click(driver, catalogItemSelectionLocator);
        //TODO:Select Quantity
       // Utils.sendData(driver, quantityLocator, String.valueOf(quantity));
       // Utils.click(driver, nextButton);
//TODO:Select CustomItem
//Utils.click(driver, addCustomButtonLocator);
//Utils.sendData(driver, customItemName, itemName);
//Utils.sendData(driver, q, );
        return new P06_CreateRFPStep3Page(driver);

    }}
