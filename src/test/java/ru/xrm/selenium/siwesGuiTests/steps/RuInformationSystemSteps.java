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


    @То("Открывается карточка создания Информационной системы")
    public InformationSystemAddEditPage openInformationSystemAddEditPage() {
        return appManager.informationSystemAddEditPage.ensurePageLoaded(false);
    }

    @И("Заполняем форму информационной системы случайно сгенерированными значениями {string}")
    public void fillInformationSystemCard(String systemToCreate) {
        InformationSystem informationSystem = appManager.selectInformationSystem(systemToCreate);
        appManager.informationSystemAddEditPage
                .fillInformationSystemCard(informationSystem);
    }

    @Когда("Вводим в фильтр данные Информационной Системы {string}")
    public void fillManagementPageAndSearch(String systemToCreate) {
        appManager.informationSystemManagementPage.fillSystemManagementPage(appManager.selectInformationSystem(systemToCreate));
    }

    @То("Проверяем найденное значение Информационной Системы {string}")
    public void checkFoundInformationSystem(String systemToCreate) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualInformationSystem = appManager.webDriver.findElement(By.xpath("//div[@class='registry-row']/div[contains(@class,'name')]")).getText();
        Assert.assertEquals(appManager.selectInformationSystem(systemToCreate).InformationSystemName, actualInformationSystem);
    }

    @И("Проверяем корректность заполнения карточки информационной системы для {string}")
    public void openInformationSystemCardAndCheckContent(String systemToCreate) {
        InformationSystem informationSystem = appManager.selectInformationSystem(systemToCreate);
        appManager.informationSystemAddEditPage.ensurePageLoaded(true);
        InformationSystem actualInformationSystem = appManager.informationSystemAddEditPage.readInformationSystemCard();
        Assert.assertEquals(actualInformationSystem, informationSystem);
    }


    @Когда("Нажимаем ссылку Удалить и подтверждаем удаление ИС {string}")
    public void deleteInformationSystem(String systemToCreate) {
        InformationSystem informationSystem = appManager.selectInformationSystem(systemToCreate);
        appManager.informationSystemManagementPage.clickDeleteLink();
        appManager.deleteSystemModal.ensureLoaded();
        try {
            String actualInformationSystemName = appManager.deleteSystemModal.checkNameOfObjectToDelete(informationSystem.InformationSystemName);
            Assert.assertEquals(informationSystem.InformationSystemName, actualInformationSystemName);
        } finally {
            appManager.deleteSystemModal.confirmButtonClick();
        }
        appManager.informationSystemManagementPage.ensurePageLoaded();
    }
}
