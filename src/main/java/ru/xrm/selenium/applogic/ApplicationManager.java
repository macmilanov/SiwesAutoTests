package ru.xrm.selenium.applogic;

import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.util.PropertyLoader;

public class ApplicationManager {
    public static final int TIME_OUT_IN_SECONDS_TO_WAIT_ELEMENT = 10;
    public static final int TIME_OUT_IN_SECONDS_TO_PAGE_LOADED = 20;
    protected WebDriverWait wait;
    private NavigationHelper navHelper;
    private String baseUrl;
    private static PropertyLoader propertyLoader;

    public ApplicationManager()
    {
        propertyLoader = new PropertyLoader();
        baseUrl = propertyLoader.loadProperty("site.url");
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
