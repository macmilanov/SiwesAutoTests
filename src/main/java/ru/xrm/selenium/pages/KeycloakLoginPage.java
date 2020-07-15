package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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
        try{
        new WebDriverWait(webDriver, 5).until(visibilityOf(loginButton));
        return this;}
        catch (TimeoutException e)
        {
            return this;
        }
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


    public KeycloakLoginPage fillLoginAndPassword (String login, String password) {
        fillTheTextFiles(login, loginField);
        fillTheTextFiles(password, passwordField);
        return this;
    }

    private KeycloakLoginPage fillTheTextFiles(String login, WebElement textField) {
        textField.clear();
        textField.sendKeys(login);
        return this;
    }

}
