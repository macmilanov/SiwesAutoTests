package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;

public class RuInformationSystemSteps extends ApplicationManager {
    private ApplicationManager appManager;

    public RuInformationSystemSteps(ApplicationManager applicationManager) {
        this.appManager = applicationManager;
    }

    @Когда("Кликаем кнопку Добавить")
    public void clickAddButton() {
        appManager.informationSystemManagementPage
                .ensurePageLoaded()
                .clickAddButton();
    }

    @То("Открывается карточка создания Информационной системы")
    public InformationSystemAddEditPage openInformationSystemAddEditPage() {
        return appManager.informationSystemAddEditPage.ensurePageLoaded(false);
    }

    @И("Заполняем форму информационной системы случайно сгенерированными значениями и Нажимаем кнопку Сохранить")
    public void fillInformationSystemCard() {
        appManager.informationSystemAddEditPage
                .fillInformationSystemCard(appManager.createdInformationSystem)
                .clickSubmitButton();
    }

    @Когда("Вводим в фильтр данные Информационной Системы и проверяем найденное значение")
    public void fillManagementPageAndSearch() {
        appManager.informationSystemManagementPage.fillManagementPage(appManager.createdInformationSystem)
                .clickFindButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualInformationSystem = appManager.webDriver.findElement(By.xpath("//div[@class='registry-row']/div[contains(@class,'name')]")).getText();
        Assert.assertEquals(appManager.createdInformationSystem.InformationSystemName, actualInformationSystem);
    }

    @И("Кликаем на ссылку Редактировать и проверяем корректность заполнения карточки")
    public void openInformationSystemCardAndCheckContent() {
        appManager.informationSystemManagementPage.clickEditLink();
        appManager.informationSystemAddEditPage.ensurePageLoaded(true);
        InformationSystem actualInformationSystem =  appManager.informationSystemAddEditPage.readInformationSystemCard();
        Assert.assertTrue(actualInformationSystem.equals(appManager.createdInformationSystem));
    }

    @И ("Кликаем на кнопку \"Отменить\"")
    public void clickCancelButton(){
        appManager.informationSystemAddEditPage.clickCancelButton();
    }

    @Когда("Нажимаем ссылку Удалить и подтверждаем удаление ИС")
    public void deleteInformationSystem() {
        appManager.informationSystemManagementPage.clickDeleteLink();
        appManager.deleteModal.ensureLoaded();
        try {
            String actualInformationSystemName = appManager.deleteModal.checkInformationSystemName(appManager.createdInformationSystem.InformationSystemName);
            Assert.assertEquals(appManager.createdInformationSystem.InformationSystemName, actualInformationSystemName);
        } finally {
            appManager.deleteModal.confirmButtonClick();
        }
        appManager.informationSystemManagementPage.ensurePageLoaded();
    }

}
