package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.pages.Page;

public class RuCommonTestSteps extends ApplicationManager {
    private ApplicationManager appManager;

    public RuCommonTestSteps(ApplicationManager applicationManager) {
        this.appManager = applicationManager;
    }

//    @Когда("Кликаем на кнопку \"Отменить\"")
//    public void clickCancelButton() {
//        appManager.page.clickCancelButton();
//    }
//
//    @И("Кликаем кнопку \"Сохранить\"")
//    public void clickSubmitButton() {
//        appManager.page.clickSubmitButton();
//    }
//
//    @Когда("Кликаем кнопку \"Добавить\"")
//    public void clickAddButton() {
//        appManager.page.clickAddButton();
//    }
//
//    @Когда("Кликаем кнопку \"Выйти\"")
//    public void clickExitButton() {
//        appManager.page.clickExitButton();}

    @Когда("Кликаем кнопку {string}")
    public void clickExitButton(String buttonText) {
        appManager.page.clickButton(buttonText);}

    @И("Кликаем на ссылку \"Редактировать\"")
    public void clickEditLink() {
        appManager.page.clickEditLink();
    }

    @То("Открыт реестр {string}")
    public Page managementPageOpenned(String pageName) {
        return appManager.detectPage(pageName);
    }

}
