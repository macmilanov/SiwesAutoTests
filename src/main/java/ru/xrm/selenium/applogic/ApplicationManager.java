package ru.xrm.selenium.applogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.util.PropertyLoader;

public class ApplicationManager {
    public static final int TIME_OUT_IN_SECONDS_TO_WAIT_ELEMENT = 10;
    public static final int TIME_OUT_IN_SECONDS_TO_PAGE_LOADED = 20;
    protected WebDriverWait wait;
    private NavigationHelper navHelper;
    private String baseUrl;
    private static PropertyLoader propertyLoader;
    private WebDriver driver;

    public ApplicationManager()
    {
        navHelper = new NavigationHelper(this);
        propertyLoader = new PropertyLoader();
        baseUrl="http://siwes.xrm.ru:10480";
        //baseUrl = propertyLoader.loadProperty("site.url");      active properties не инициализиуются
    }

    public WebDriver getWebDriver()
    {
        return driver;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public NavigationHelper getNavigationHelper()
    {
        return navHelper;
    }

}
