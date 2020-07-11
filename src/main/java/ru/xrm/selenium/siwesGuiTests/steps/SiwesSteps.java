package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.ru.*;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.junit.After;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.applogic.NavigationHelper;
import ru.xrm.selenium.pages.InformationSystemManagementPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;
import ru.xrm.selenium.pages.StartingPage;
import static org.junit.Assert.*;
import static ru.xrm.selenium.webdriver.webdriver.WebDricerFactory.createWebDriver;
import io.cucumber.core.api.*;


public class SiwesSteps {
    private WebDriver webDriver;
    private StartingPage startingPage;
    private KeycloakLoginPage keycloakLoginPage;
    private InformationSystemManagementPage informationSystemManagementPage;
    private ApplicationManager appManager;
    private NavigationHelper navigationHelper;


    @Before
    public void startBrowser()
    {
        appManager = new ApplicationManager();
        webDriver = createWebDriver();
        startingPage = new StartingPage(webDriver);
        keycloakLoginPage = new KeycloakLoginPage(webDriver);
        informationSystemManagementPage = new InformationSystemManagementPage(webDriver);


    }

    @Дано("Открыта стартовая страница с кнопкой {string}")
        public void staringPageOpened(String buttonTitle)
        {
            startingPage.openStaringPage()
                        .ensurePageLoaded();
            //appManager.getNavigationHelper().openStaringPage();
            assertEquals(startingPage.getEnterButtonText(), buttonTitle);
        }

    @Когда("Когда нажата кнопка входа")
        public void enterButtonClicked()
        {
            startingPage.clickEnterButton();
        }

    @То("Происходит редирект на страницу авторизации Keycloak")
        public KeycloakLoginPage keycloakPageOpened()
        {
            return keycloakLoginPage.ensurePageLoaded();
        }

    @Когда("Заполняется поле логина значением {string}")
        public void fillLoginFiled (String string)
        {
            keycloakLoginPage.setLoginField(string);
        }

    @И("Заполняется поле пароля значением {string}")
        public void fillPasswordFiled (String string)
        {
            keycloakLoginPage.setPasswordField(string);
        }
    @И("Кликнута кнопка \"Log in\"")
        public void loginButtonClicked ()
    {
        keycloakLoginPage.clickLoginButton();
    }

    @То("Происходит авторизация под главным администраром и Должен быть открыт реестр информационных систем")
        public InformationSystemManagementPage openInformationSystemManagementPage()
        {
            return informationSystemManagementPage.ensurePageLoaded();
        }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            /*scenario.embed(screenshot, "image/jpeg"); */}
        webDriver.quit();}
}
