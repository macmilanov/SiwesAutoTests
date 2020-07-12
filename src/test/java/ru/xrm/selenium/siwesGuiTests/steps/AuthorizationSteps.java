package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.model.User;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;
import ru.xrm.selenium.pages.InformationSystemManagementPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;
import ru.xrm.selenium.pages.StartingPage;
import ru.xrm.selenium.util.RandomInformationSystemGenerator;

import static ru.xrm.selenium.webdriver.webdriver.WebDriverFactory.createWebDriver;


public class AuthorizationSteps {
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

    @Дано("Открыта стартовая страница, параметр авторизации {string}")
    public void staringPageOpened(String isAuthorized) {
        Boolean bool = Boolean.parseBoolean(isAuthorized);
        startingPage.openStaringPage(bool);}


    @Когда("Кликаем кнопку \"Войти\"")
    public void enterButtonClicked() {
        startingPage.clickEnterButton();
    }

    @Когда("Заполняются поля логина и пароля значениями {string} и {string}")
    public void fillLoginAndPasswordFiles(String login, String password) {
        keycloakLoginPage.fillLoginAndPassword (login,password);
    }

    @То("Происходит редирект на страницу авторизации Keycloak")
    public KeycloakLoginPage keycloakPageOpened() {
        return keycloakLoginPage.ensurePageLoaded();
    }

    @Когда("Заполняется поле {string} значением {string}")
    public void fillTextField(String field, String value) {
        keycloakLoginPage.fillTextField(field, value);
    }


    @И("Кликнута кнопка \"Log in\"")
    public void clickLoginButton() {
        keycloakLoginPage.clickLoginButton();
    }

    @То("Должен быть открыт реестр информационных систем")
    public InformationSystemManagementPage openInformationSystemManagementPage() {
        return informationSystemManagementPage.ensurePageLoaded();
    }

    @Когда ("Кликаем кнопку \"Выйти\"")
    public void clickExitButton(){
        informationSystemManagementPage.clickExitButton();
    }

    @Когда("Кликаем кнопку Добавить")
    public void clickAddButton() {
        informationSystemManagementPage.ensurePageLoaded().clickAddButton();
    }

    @То("Открывается карточка создания Информационной системы")
    public InformationSystemAddEditPage openInformationSystemAddEditPage() {
        return informationSystemAddEditPage.ensurePageLoaded();
    }

    @Когда("Генерируем Информационную систему")
    public InformationSystem generateRandomInformationSystem() {
        return RandomInformationSystemGenerator.getRandomInformationSystem();
    }

}
