package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.openqa.selenium.WebDriver;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.model.User;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;
import ru.xrm.selenium.pages.StartingPage;
import ru.xrm.selenium.util.RandomInformationSystemGenerator;
import ru.xrm.selenium.pages.InformationSystemManagementPage;

public class InformationSystemSteps {
    /*private WebDriver webDriver;
    private StartingPage startingPage;
    private KeycloakLoginPage keycloakLoginPage;
    private InformationSystemManagementPage informationSystemManagementPage;
    private User user;
    private InformationSystemAddEditPage informationSystemAddEditPage;

    @Когда("Кликаем кнопку Добавить")
    public void addButtonClicked() {
        informationSystemManagementPage.ensurePageLoaded().clickAddButton();
    }

    @То("Открывается карточка создания Информационной системы")
    public InformationSystemAddEditPage openInformationSystemAddEditPage() {
        return informationSystemAddEditPage.ensurePageLoaded();
    }

    @Когда("Генерируем Информационную систему")
    public InformationSystem generateRandomInformationSystem() {
        return RandomInformationSystemGenerator.getRandomInformationSystem();
    }*/
}
