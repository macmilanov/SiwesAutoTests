package ru.xrm.selenium.applogic;

import org.openqa.selenium.WebDriver;
import ru.xrm.selenium.pages.StartingPage;

public class NavigationHelper {
    private WebDriver webDriver;
    private  ApplicationManager appManager;
    private StartingPage startingPage;


    public void openStaringPage(){
        webDriver.navigate().to(appManager.getBaseUrl());
        startingPage.ensurePageLoaded();
    }
}
