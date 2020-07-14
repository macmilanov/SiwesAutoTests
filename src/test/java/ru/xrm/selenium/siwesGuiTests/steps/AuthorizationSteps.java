package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;
import ru.xrm.selenium.pages.InformationSystemManagementPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;
import ru.xrm.selenium.util.RandomInformationSystemGenerator;


public class AuthorizationSteps extends ApplicationManager {
    private ApplicationManager appManager;
    private InformationSystem informationSystem;

    public AuthorizationSteps(ApplicationManager applicationManager) {
        this.appManager = applicationManager;
    }

    @Дано("Открыта стартовая страница, пользователь {string} и кликаем кнопку войти")
    public void staringPageOpened(String authorizeAction) {
        Boolean bool = authorizeAction.equals("готов к авторизации");
        appManager.startingPage.openStaringPage(bool)
                .ensurePageLoaded()
                .clickEnterButton();
    }


    @Когда("Заполняются поля логина и пароля значениями {string} и {string}")
    public void fillLoginAndPasswordFiles(String login, String password) {
        appManager.keycloakLoginPage.fillLoginAndPassword(login, password);
    }

    @То("Происходит редирект на страницу авторизации Keycloak")
    public KeycloakLoginPage keycloakPageOpened() {
        return appManager.keycloakLoginPage.ensurePageLoaded();
    }

    @Когда("Заполняются поля логина и пароля значениями {string} и {string} и Кликнута кнопка \"Log in\"")
    public void fillTextField(String field, String value) {
        appManager.keycloakLoginPage.fillTextField(field, value)
                .clickLoginButton();
    }


    @То("Должен быть открыт реестр информационных систем")
    public InformationSystemManagementPage openInformationSystemManagementPage() {
        return appManager.informationSystemManagementPage.ensurePageLoaded();
    }

    @Когда("Кликаем кнопку \"Выйти\"")
    public void clickExitButton() {
        appManager.informationSystemManagementPage.clickExitButton();
    }

    @Когда("Кликаем кнопку \"Добавить\"")
    public void clickAddButton() {
        informationSystemManagementPage.ensurePageLoaded().clickAddButton();
    }

    @То("Открывается карточка создания Информационной системы")
    public InformationSystemAddEditPage openInformationSystemAddEditPage() {
        return appManager.informationSystemAddEditPage.ensurePageLoaded();
    }

    @И("Заполняем форму информационной системы случайно сгенерированными значениями и Нажимаем кнопку Сохранить")
    public void fillInformationSystemCard() {
        informationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();
        appManager.informationSystemAddEditPage.fillInformationSystemCard(informationSystem).clickSubmitButton();
    }
}
