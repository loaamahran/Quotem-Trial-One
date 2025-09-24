package Pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_CreateRFPStep3Page {
WebDriver driver;
    private final By publicBidLocator=By.xpath("//input[@name='bid' and @value ='0']");
    private final By addCategoriesLocator=By.xpath("//button[contains(text(),'+')]");
    int i =Utils.generateRandomumber(33);
    private final By selectCategory=By.xpath("(//input[@type='checkbox'])["+i+"]");
    private final By saveCategoriesButton=By.xpath("//button[text()='Save']");
    private final By notesLocator=By.name("note");
    private final By attachFile=By.id("file-upload-documents");
    public P06_CreateRFPStep3Page(WebDriver driver) {
        this.driver = driver;
    }
    public P07_RFPDetailsPage RFPStep3(String note, String filePath){
//Utils.click(driver, publicBidLocator);
        Utils.checkBox(driver,publicBidLocator);
        Utils.checkBox(driver,addCategoriesLocator);
        Utils.checkBox(driver,selectCategory);
//Utils.click(driver, addCategoriesLocator);
//Utils.click(driver, selectCategory);
        Utils.click(driver, saveCategoriesButton);
        Utils.sendData(driver, notesLocator, note);
        Utils.checkBox(driver, attachFile);
//Utils.click(driver, attachFile);
        Utils.uploadFile(driver, attachFile, filePath);
        return new P07_RFPDetailsPage(driver);}
}
