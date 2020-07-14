package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.xrm.selenium.applogic.ApplicationManager;

public class InitializationAndTeardown extends ApplicationManager {
    private ApplicationManager appManager;
    public InitializationAndTeardown(ApplicationManager appManager){
        this.appManager = appManager;
    }

    @Before
    public void startBrowser(){
        appManager.startBrowser();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) appManager.webDriver).getScreenshotAs(OutputType.BYTES);
        }
        appManager.webDriver.close();
    }
}
