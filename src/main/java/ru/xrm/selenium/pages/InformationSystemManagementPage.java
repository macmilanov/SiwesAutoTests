package ru.xrm.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.applogic.ApplicationManager;
import ru.xrm.selenium.model.InformationSystem;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class InformationSystemManagementPage {
    //Общие для всех реестров элементы
    @FindBy(xpath = "//button[normalize-space()='Добавить']")
    private WebElement addButton;
    @FindBy(xpath = "//button[normalize-space()='Выход']")
    private WebElement exitButton;
    @FindBy(xpath = "//label[normalize-space()='Только активные']/preceding-sibling::input[@type='checkbox']")
    private WebElement isActiveState;
    @FindBy(xpath = "//button[normalize-space()='Найти']")
    private WebElement findButton;
    @FindBy(xpath = "//button[normalize-space()='Очистить']")
    private WebElement clearFilterButton;
    @FindBy(xpath = "//a[@class='event-link' and normalize-space()='Удалить']")
    private WebElement deleteLink;
    @FindBy(xpath = "//a[@class='event-link' and normalize-space()='Редактировать']")
    private WebElement editLink;

    //Элементы реестра ИС
    @FindBy(xpath = "//input[@placeholder='Наименование ИС']")
    private WebElement informationSystemNameField;
    @FindBy(xpath = "//input[@placeholder='Мнемоника']")
    private WebElement informationSystemMnemonicField;


    private WebDriver webDriver;

    public InformationSystemManagementPage getInformationSystemManagementPage() {
        return this;
    }

    public InformationSystemManagementPage ensurePageLoaded() {
        try {
            new WebDriverWait(webDriver, 5).until(visibilityOf(addButton));
            return this;
        } catch (TimeoutException e) {
            return this;
        }
    }

    public InformationSystemManagementPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickEditLink() {
        editLink.click();
    }

    public void clickExitButton() {
        exitButton.click();
    }

    public InformationSystemManagementPage fillManagementPage(InformationSystem createdInformationSystem) {
        fillAutoCompleteTextField(createdInformationSystem.InformationSystemName, informationSystemNameField);
        fillAutoCompleteTextField(createdInformationSystem.InformationSystemMnemonic, informationSystemMnemonicField);
        if (!createdInformationSystem.IsActiveState) {
            this.isActiveState.click();
        }
        return this;
    }

    private void fillAutoCompleteTextField(String string, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(string);
        try {
            WebElement dropDownValue = webDriver.findElement(By.xpath("//div[@class='v-autocomplete-list']/div[contains(@class, 'v-autocomplete-list-item')]/div[normalize-space()='"+string+"']"));
            Thread.sleep(500);
            dropDownValue.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickFindButton() {
        findButton.click();
    }

    public void clickDeleteLink() {
        deleteLink.click();
    }
}
