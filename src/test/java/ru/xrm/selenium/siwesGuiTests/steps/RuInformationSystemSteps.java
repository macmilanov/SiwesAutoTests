package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String actualInformationSystem = appManager.webDriver.findElement(By.xpath("//div[@class='registry-row']/div[contains(@class,'name')]")).getText();
        Assert.assertEquals(appManager.createdInformationSystem.InformationSystemName, actualInformationSystem);
    }


    @Когда ("Нажимаем ссылку Удалить и подтверждаем удаление ИС")
    public void deleteInformationSystem(){
        appManager.informationSystemManagementPage.clickDeleteLink();
        appManager.deleteModal.ensureLoaded();
        String modalContent = appManager.webDriver.findElement(By.xpath("//h2[normalize-space()='Подтвердить']/div[contains()='Вы действительно хотите удалить информационную систему']")).getText();
        Pattern systemNamePattern = Pattern.compile(".+");
        Matcher systemNameExtractor = systemNamePattern.matcher(modalContent);
        Assert.assertEquals(appManager.createdInformationSystem.InformationSystemName, systemNameExtractor.group(1));
        appManager.deleteModal.confirmButtonClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        appManager.informationSystemManagementPage.ensurePageLoaded();
    }
}
