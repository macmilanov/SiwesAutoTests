package ru.xrm.selenium.webdriver.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "firefox");
        switch(webdriver) {
            case "firefox":
                WebDriver firefoxDriver = new FirefoxDriver();
                setup(firefoxDriver);
                return firefoxDriver;
            case "chrome":
                WebDriver chromeDriver = new ChromeDriver();
                setup(chromeDriver);
                return chromeDriver;
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
    private static void setup(WebDriver webDriver)
    {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
