package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class KeycloakLoginPage {

    private WebDriver webDriver;
    @FindBy(id = "username")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;;
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    public KeycloakLoginPage getKeycloakLoginPage()
    {
        return this;
    }

    public KeycloakLoginPage fillTextField (String field, String value)
    {
        webDriver.findElement(By.id(field))
                .sendKeys(value);
        return this;
    }

    public KeycloakLoginPage ensurePageLoaded()
    {
        new WebDriverWait(webDriver, 5).until(presenceOfElementLocated(By.xpath("//div[normalize-space()='Идентификация и аутентификация внутренних систем и пользователей']")));
        return this;
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }

    public KeycloakLoginPage (WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void fillLoginAndPassword(String login, String password) {
        fillTheTextFiles(login, loginField);
        fillTheTextFiles(password, passwordField);
    }

    private void fillTheTextFiles(String login, WebElement textField) {
        textField.clear();
        textField.sendKeys(login);
    }
}
