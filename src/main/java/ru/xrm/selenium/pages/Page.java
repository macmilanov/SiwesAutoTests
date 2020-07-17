package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Page {
    public WebDriver webDriver;
    //Общие Элементы реестров
    @FindBy(xpath = "//button[normalize-space()='Добавить']")
    protected WebElement addButton;
    @FindBy(xpath = "//button[normalize-space()='Выход']")
    protected WebElement exitButton;
    @FindBy(xpath = "//label[normalize-space()='Только активные']/preceding-sibling::input[@type='checkbox']")
    protected WebElement isActiveState;
    @FindBy(xpath = "//button[normalize-space()='Найти']")
    protected WebElement findButton;
    @FindBy(xpath = "//button[normalize-space()='Очистить']")
    protected WebElement clearFilterButton;
    @FindBy(xpath = "//a[@class='event-link' and normalize-space()='Удалить']")
    protected WebElement deleteLink;
    @FindBy(xpath = "//a[@class='event-link' and normalize-space()='Редактировать']")
    protected WebElement editLink;
    @FindBy(xpath = "//li[normalize-space()='Информационные системы']")
    protected WebElement informationSystemMenu;
    @FindBy(xpath = "//li[normalize-space()='Подсистемы и компоненты']")
    protected WebElement participantMenu;
    @FindBy(xpath = "//li[normalize-space()='Виды сведений']")
    protected WebElement smevServiceMenu;
    @FindBy(xpath = "//li[normalize-space()='Учетные записи администраторов']")
    protected WebElement userMenu;

    //Общие элементы карточек
    @FindBy(xpath = "//button[normalize-space()='Сохранить']")
    protected WebElement submitButton;
    @FindBy(xpath = "//button[normalize-space()='Отменить']")
    protected WebElement cancelButton;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected void fillAutoCompleteTextField(String string, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(string);
        try {
            WebElement dropDownValue = webDriver.findElement(By.xpath("//div[@class='v-autocomplete-list']/div[contains(@class, 'v-autocomplete-list-item')]/div[normalize-space()='" + string + "']"));
            Thread.sleep(500);
            dropDownValue.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Page ensurePageLoaded() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.or(
                visibilityOf(submitButton),
                elementToBeClickable(isActiveState)));
        return this;
    }

    protected void fillTextField(String string, WebElement webElement) {
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webElement.sendKeys(Keys.BACK_SPACE);
        webElement.sendKeys(string);
    }

    public void clickButton(String buttonText) {
        switch (buttonText) {
            case "Добавить":
                addButton.click();
                break;
            case "Найти":
                findButton.click();
                break;
            case "Отменить":
                cancelButton.click();
                break;
            case "Выход":
                exitButton.click();
                break;
            case "Сохранить":
                submitButton.click();
                break;
        }
    }

    public void clickDeleteLink() {
        deleteLink.click();
    }

    public void clickEditLink() {
        editLink.click();
    }

    public void clickFindButton() {
        findButton.click();
    }

    public void clickInformationSystemMenu() {
        informationSystemMenu.click();
    }

    public void clickParticipantMenu() {
        participantMenu.click();
    }

    public void clickSmevServiceMenu() {
        smevServiceMenu.click();
    }

    public void clickUserMenu() {
        userMenu.click();
    }

}
