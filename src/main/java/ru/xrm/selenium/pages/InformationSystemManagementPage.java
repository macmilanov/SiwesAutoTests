package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        new WebDriverWait(webDriver, 5).until(visibilityOf(addButton));
        return this;
    }

    public InformationSystemManagementPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddButton() {
        addButton.click();
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webElement.sendKeys(Keys.TAB);
    }


    public void clickFindButton() {
        findButton.click();
    }

    public void clickDeleteLink() {
        deleteLink.click();
    }
}
