package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.pages.InformationSystemManagementPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;


public class RuAuthorizationSteps extends ApplicationManager {
    private ApplicationManager appManager;

    public RuAuthorizationSteps(ApplicationManager applicationManager) {
        this.appManager = applicationManager;
    }

    @Дано("Открыта стартовая страница, пользователь {string}")
    public void staringPageOpened(String authorizeAction) {
        Boolean bool = authorizeAction.equals("готов к авторизации и кликаем кнопку войти");
        appManager.openStaringPage(bool);
        appManager.startingPage.ensurePageLoaded().clickEnterButton(bool);
    }


    @То("Происходит редирект на страницу авторизации Keycloak")
    public KeycloakLoginPage keycloakPageOpened() {
        return appManager.keycloakLoginPage.ensurePageLoaded();
    }

    @Когда("Заполняются поля логина и пароля значениями {string} и {string} и Кликнута кнопка \"Log in\"")
    public void fillTextField(String login, String password) {
        appManager.keycloakLoginPage.fillLoginAndPassword(login, password)
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
}
