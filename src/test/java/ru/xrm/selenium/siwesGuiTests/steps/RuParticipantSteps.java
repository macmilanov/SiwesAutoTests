package ru.xrm.selenium.siwesGuiTests.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.model.Participant;
import ru.xrm.selenium.pages.ParticipantAddEditPage;
import ru.xrm.selenium.pages.ParticipantManagementPage;

public class RuParticipantSteps extends ApplicationManager {
    private ApplicationManager appManager;

    public RuParticipantSteps(ApplicationManager applicationManager) {
        this.appManager = applicationManager;
    }

    @Когда("Переходим в меню \"Подсистемы и компоненты\"")
    public void participantMenuClick() {
        appManager.informationSystemManagementPage.clickParticipantMenu();
    }

    @То("Должен быть открыт реестр \"Подсистемы и компоненты\"")
    public ParticipantManagementPage openInformationSystemAddEditPage() {
        return appManager.participantManagementPage.ensurePageLoaded();
    }

    @Когда("Кликаем кнопку Добавить в реестре подсистем")
    public void clickAddParticipantButton() {
        appManager.participantManagementPage.clickAddButton();
    }

    @То("Открывается карточка создания Подсистемы")
    public ParticipantAddEditPage openParticipantAddEditPage() {
        return appManager.participantAddEditPage.ensurePageLoaded(false);
    }

    @Когда("Заполняем форму подсистемы системы случайно сгенерированными значениями {string} и кликаем кнопку Сохранить")
    public void fillInformationSystemCard(String toCreate) {
        Participant participant = appManager.selectParticipant(toCreate);
        appManager.participantAddEditPage
                .fillParticipantCard(participant)
                .clickSubmitButton();
    }

    @Когда("Вводим в фильтр данные Подсистемы {string} и проверяем найденное значение")
    public void fillManagementPageAndSearch(String toCreate) {
        Participant participant = appManager.selectParticipant(toCreate);
        appManager.participantManagementPage.fillParticipantManagementPage(participant)
                .clickFindButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualParticipant = appManager.webDriver.findElement(By.xpath("//div[@class='registry-row']/div[contains(@class,'name')]")).getText();
        Assert.assertEquals(participant.ParticipantName, actualParticipant);
    }

    @И("Кликаем на ссылку Редактировать и проверяем корректность заполнения карточки подсистемы для {string}")
    public void openParticipantCardAndCheckContent(String toCreate) {
        Participant participant = appManager.selectParticipant(toCreate);
        appManager.participantManagementPage.clickEditLink();
        appManager.participantAddEditPage.ensurePageLoaded(true);
        Participant actualParticipant = appManager.participantAddEditPage.readParticipantCard();
        Assert.assertEquals(actualParticipant, participant);
    }

    @Когда("Кликаем на кнопку \"Отменить\" на карточке подсистемы")
    public void clickCancelParticipantButton() {
        appManager.participantAddEditPage.clickCancelButton();
    }

    @То ("Нажимаем ссылку Удалить и подтверждаем удаление подсистемы {string}")
    public void deleteParticipant(String toCreate) {
        Participant participant = appManager.selectParticipant(toCreate);
        appManager.participantManagementPage.clickDeleteLink();
        appManager.deleteSystemModal.ensureLoaded();
        try {
            String participantName = appManager.deleteSystemModal.checkNameOfObjectToDelete(participant.ParticipantName);
            Assert.assertEquals(participant.ParticipantName, participantName);
        } finally {
            appManager.deleteSystemModal.confirmButtonClick();
        }
        appManager.informationSystemManagementPage.ensurePageLoaded();
    }
}
