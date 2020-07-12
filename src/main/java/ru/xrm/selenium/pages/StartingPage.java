package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.function.BooleanSupplier;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class StartingPage {

        @FindBy(xpath = "//button[normalize-space()='Войти']")
        private WebElement enterButton;
        private WebDriver webDriver;
        private static String enterButtonText;

        public String getEnterButtonText()
        {
            return enterButton.getText();
        }


        public StartingPage ensurePageLoaded()
        {
            new WebDriverWait(webDriver, 5). until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Войти']")));
            return this;
        }

        public StartingPage getStartingPage()
        {
            return this;
        }

        public StartingPage (WebDriver webDriver)
        {
            this.webDriver = webDriver;
            PageFactory.initElements(webDriver, this);
        }

        public void clickEnterButton()
        {
            enterButton.click();
        }

        public StartingPage openStaringPage(Boolean isAuthorized){
        if(isAuthorized)
        {
            webDriver.navigate().to("http://siwes.xrm.ru:10480");
        }
        return this.ensurePageLoaded();
    }
 }
