package ru.xrm.selenium.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.model.Participant;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ParticipantManagementPage extends Page {
    @FindBy(xpath = "//input[@placeholder='Наименование подсистемы/компонента']")
    private WebElement participantName;
    @FindBy(xpath = "//h2[normalize-space()='Подсистемы и отдельные компоненты ЕИСЖС']")
    private WebElement pageTitle;

    public ParticipantManagementPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public ParticipantManagementPage ensurePageLoaded() {
        try {
            new WebDriverWait(webDriver, 15).until(ExpectedConditions.or(
                    visibilityOf(addButton),
                    visibilityOf(pageTitle),
                    visibilityOf(editLink)));
            return this;
        } catch (TimeoutException e) {
            return this;
        }
    }

    public ParticipantManagementPage fillParticipantManagementPage(Participant participant) {
        fillAutoCompleteTextField(participant.ParticipantName, participantName);
        if (!participant.IsParticipantActive) {
            this.isActiveState.click();
        }
        return this;
    }
}
