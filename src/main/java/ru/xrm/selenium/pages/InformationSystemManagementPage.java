package ru.xrm.selenium.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.model.InformationSystem;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class InformationSystemManagementPage extends Page {
    @FindBy(xpath = "//input[@placeholder='Наименование ИС']")
    private WebElement informationSystemNameField;
    @FindBy(xpath = "//input[@placeholder='Мнемоника']")
    private WebElement informationSystemMnemonicField;
    @FindBy(xpath = "//h2[normalize-space()='Информационные системы, зарегистрированные в СМЭВ']")
    private WebElement pageTitle;

    private InformationSystemManagementPage getInformationSystemManagementPage() {
        return this;
    }

    public InformationSystemManagementPage ensurePageLoaded() {
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

    public InformationSystemManagementPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public InformationSystemManagementPage fillSystemManagementPage(InformationSystem createdInformationSystem) {
        fillAutoCompleteTextField(createdInformationSystem.InformationSystemName, informationSystemNameField);
        fillAutoCompleteTextField(createdInformationSystem.InformationSystemMnemonic, informationSystemMnemonicField);
        if (!createdInformationSystem.IsActiveState) {
            this.isActiveState.click();
        }
        return this;
    }
}
