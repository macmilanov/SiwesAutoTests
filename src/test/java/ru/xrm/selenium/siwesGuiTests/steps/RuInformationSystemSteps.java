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
    private InformationSystem informationSystem;

    public RuInformationSystemSteps (ApplicationManager applicationManager){
        this.appManager = applicationManager;
    }
    @Когда("Кликаем кнопку \"Добавить\"")
    public void clickAddButton() {
        appManager.informationSystemManagementPage
                .ensurePageLoaded()
                .clickAddButton();
    }

    @То("Открывается карточка создания Информационной системы")
    public InformationSystemAddEditPage openInformationSystemAddEditPage() {
        return appManager.informationSystemAddEditPage.ensurePageLoaded();
    }

    @И("Заполняем форму информационной системы случайно сгенерированными значениями и Нажимаем кнопку Сохранить")
    public void fillInformationSystemCard() {
        appManager.informationSystemAddEditPage
                .fillInformationSystemCard(appManager.createdInformationSystem)
                .clickSubmitButton();
    }

    @Когда ("Вводим в фильтр данные Информационной Системы и нажимаем кнопку Искать")
    public void fillManagementPageAndSearch(){
        appManager.informationSystemManagementPage.fillManagementPage(appManager.createdInformationSystem)
                .clickFindButton();
        String foundInformationSystem = appManager.webDriver.get
                get();t(By.xpath("//div[@class='registry-row']/div[@class='name']/following-sibling::div[@class='event']")).toString();
        Assert.assertEquals(appManager.createdInformationSystem.InformationSystemName, foundInformationSystem);
    }

    @То ("В списке найдена Информационная система")
    public void informationSystemIsPresented(){

    }

    @Когда ("Нажимаем ссылку Удалить")
    public void deleteInformationSystem(){
        appManager.informationSystemManagementPage.clickDeleteLink();
    }
}
