package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.model.Participant;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ParticipantAddEditPage extends Page {
    @FindBy(xpath = "//label[normalize-space()='Наименование подсистемы или отдельного компонента ЕИСЖС']/following-sibling::input[@class='control']")
    private WebElement participantName;
    @FindBy(xpath = "//dib[@class='vs__selected-options']/input[@class='vs__search']")
    private WebElement participantInformationSystem;
    @FindBy(xpath = "//label[normalize-space()='Подсистема/компонент активен']/preceding-sibling::input[@type='checkbox']")
    private WebElement isActiveState;
    @FindBy(xpath = "//input[@placeholder='clientId из keycloak']")
    private WebElement participantClientId;

    public ParticipantAddEditPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public ParticipantAddEditPage ensurePageLoaded(Boolean pageToEdit) {
        try {
            WebElement pageTitle = pageToEdit ? webDriver.findElement(By.xpath("//h2[normalize-space()='Изменение подсистемы/компонента ЕИСЖС']"))
                    : webDriver.findElement(By.xpath("//h2[normalize-space()='Добавление подсистемы/компонента ЕИСЖС']"));
            new WebDriverWait(webDriver, 5).until(ExpectedConditions.or(
                    visibilityOf(pageTitle),
                    visibilityOf(submitButton),
                    elementToBeClickable(isActiveState)));
            return this;
        } catch (TimeoutException e) {
            return this;
        }
    }

    public ParticipantAddEditPage fillParticipantCard(Participant participant) {
        fillTextField(participant.ParticipantName, participantName);
        if (participant.IsParticipantActive) {
            if (!isActiveState.isSelected()) {
                this.isActiveState.click();
            }
        } else {
            if (isActiveState.isSelected()) {
                this.isActiveState.click();
            }
        }
        fillTextField(participant.ParticipantClientId, participantClientId);
        selectInformationSystem(participant.ParticipantInformationSystemName, participantInformationSystem);
        return this;
    }

    private void selectInformationSystem(String systemName, WebElement systemField) {
        systemField.clear();
        systemField.sendKeys(systemName);
        try {
            WebElement dropDownValue = webDriver.findElement(By.xpath("//ul[@role='listbox']/li[normalize-space()='" + systemName + "']"));
            Thread.sleep(500);
            dropDownValue.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Participant readParticipantCard() {
        {
            return new Participant()
                    .setParticipantName(participantName.getAttribute("value"))
                    .setParticipantClientId(participantClientId.getAttribute("value"))
                    .setParticipantInformationSystemName(participantInformationSystem.getAttribute("value"))
                    .setIsParticipantActive(webDriver.findElement(By.xpath("//label[normalize-space()='Подсистема/компонент активен']/preceding-sibling::input[@type='checkbox']")).isSelected());
        }
    }
}
