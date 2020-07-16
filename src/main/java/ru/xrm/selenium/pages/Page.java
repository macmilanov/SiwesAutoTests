package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    protected void fillTextField(String string, WebElement webElement) {
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webElement.sendKeys(Keys.BACK_SPACE);
        webElement.sendKeys(string);
    }

    public void clickFindButton() {
        findButton.click();
    }

    public void clickDeleteLink() {
        deleteLink.click();
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

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
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


}
