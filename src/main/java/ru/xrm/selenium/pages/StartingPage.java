package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartingPage {

        @FindBy(xpath = "//button[normalize-space()='Войти']")
        private WebElement enterButton;
        private WebDriver webDriver;

        public StartingPage ensurePageLoaded()
        {
            new WebDriverWait(webDriver, 5). until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Войти']")));
            return this;
        }

        public StartingPage (WebDriver webDriver)
        {
            this.webDriver = webDriver;
            PageFactory.initElements(webDriver, this);
        }

        public void clickEnterButton(Boolean isToAutorize)
        {
            if (isToAutorize){enterButton.click();}
        }

        public StartingPage openStaringPage(Boolean isToAutorize){
        if(isToAutorize)
        {
            webDriver.navigate().to("http://siwes.xrm.ru:10480");
        }
        return this.ensurePageLoaded();
    }
 }
