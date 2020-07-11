package ru.xrm.selenium.applogic;

import org.openqa.selenium.WebDriver;
import ru.xrm.selenium.pages.StartingPage;

public class NavigationHelper {
    private WebDriver webDriver;
    private StartingPage startingPage;

    private final String baseUrl;
    private WebDriver driver;

    public NavigationHelper(ApplicationManager appManager)
    {
        this.baseUrl = appManager.getBaseUrl();
        this.driver = appManager.getWebDriver();
    }

    public void openStaringPage(){
        webDriver.navigate().to(baseUrl);
        startingPage.ensurePageLoaded();
    }
}
