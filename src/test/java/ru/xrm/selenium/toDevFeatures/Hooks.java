package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.xrm.selenium.model.User;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;
import ru.xrm.selenium.pages.InformationSystemManagementPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;
import ru.xrm.selenium.pages.StartingPage;

import static ru.xrm.selenium.webdriver.webdriver.WebDriverFactory.createWebDriver;

public class Hooks {
    private WebDriver webDriver;
    private StartingPage startingPage;
    private KeycloakLoginPage keycloakLoginPage;
    private InformationSystemManagementPage informationSystemManagementPage;
    private User user;
    private InformationSystemAddEditPage informationSystemAddEditPage;

    @Before
    public void startBrowser() {
        webDriver = createWebDriver();
        startingPage = new StartingPage(webDriver);
        keycloakLoginPage = new KeycloakLoginPage(webDriver);
        informationSystemManagementPage = new InformationSystemManagementPage(webDriver);
        informationSystemAddEditPage = new InformationSystemAddEditPage(webDriver);
        user = new User();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }
        webDriver.close();
    }
}
