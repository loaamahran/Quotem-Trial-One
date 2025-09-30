package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {
    static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
public static void browserSetup(String browser)
{switch(browser.toLowerCase()){
    case("chrome"):
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");

        driver.set(new ChromeDriver());

break;
    case("firefox"):
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--start--fullscreen");
driver.set(new FirefoxDriver());
        break;
    case("safari"):
        SafariOptions options2 = new SafariOptions();

        driver.set(new SafariDriver());
        break ;
    default:
driver.set(new EdgeDriver());
break;}
}
    public static WebDriver getDriver()
    {
        return driver.get();


}
public static void teardown(){
getDriver().quit();
    driver.remove();
}}
