package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.model.InformationSystem;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

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
    private WebElement InformationSystemNameField;
    @FindBy(xpath = "//input[@placeholder='Мнемоника']")
    private WebElement InformationSystemMnemonicField;



    private WebDriver webDriver;

    public InformationSystemManagementPage getInformationSystemManagementPage() {
        return this;
    }

    public InformationSystemManagementPage ensurePageLoaded() {
        new WebDriverWait(webDriver, 5).until(presenceOfElementLocated(By.xpath("//button[normalize-space()='Добавить']")));
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
        fillTextField(createdInformationSystem.InformationSystemName, InformationSystemNameField);
        fillTextField(createdInformationSystem.InformationSystemMnemonic, InformationSystemMnemonicField);
        if (!createdInformationSystem.IsActiveState) { this.isActiveState.click(); }
        return this;
    }

    private void fillTextField(String string, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(string);
    }

    public void clickFindButton() {
        findButton.click();
    }

    public void clickDeleteLink() {
        deleteLink.click();
    }
}
