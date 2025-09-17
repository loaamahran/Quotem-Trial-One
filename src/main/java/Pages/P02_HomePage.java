package Pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {
    private WebDriver driver;
    public P02_HomePage(WebDriver driver) {
  this.driver=driver;  }
private By requisitionsTabLocator=By.xpath("//a[@href='/business/purchase-requests']");
 public P03_RequistionsListPage getRequistionsList(){
     Utils.click(driver, requisitionsTabLocator);
   return new P03_RequistionsListPage(driver);
 }
 public boolean verifyURL(String expected){
  return driver.getCurrentUrl().equals(expected);
 }
}
