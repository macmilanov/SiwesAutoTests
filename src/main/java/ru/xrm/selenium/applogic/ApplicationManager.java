package ru.xrm.selenium.applogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.model.Participant;
import ru.xrm.selenium.pages.*;
import ru.xrm.selenium.util.PropertyLoader;
import ru.xrm.selenium.util.RandomInformationSystemGenerator;
import ru.xrm.selenium.util.RandomParticipantGenerator;

public class ApplicationManager {
    public WebDriver webDriver;
    public StartingPage startingPage;
    public KeycloakLoginPage keycloakLoginPage;
    public InformationSystemManagementPage informationSystemManagementPage;
    public InformationSystemAddEditPage informationSystemAddEditPage;
    public DeletionModalWindow deleteSystemModal;
    public InformationSystem createdInformationSystem;
    public InformationSystem editedInformationSystem;
    public Participant createdParticipant;
    public Participant editedParticipant;
    public String baseUrl;
    public static PropertyLoader loader;
    public Page page;
    public ParticipantManagementPage participantManagementPage;
    public ParticipantAddEditPage participantAddEditPage;
    public SmevServiceManagementPage smevServiceManagementPage;
    public SmevServiceAddEditPage smevServiceAddEditPage;
    public UserAddEditPage userAddEditPage;
    public UserManagementPage userManagementPage;

    public void startBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver(options);
        loader = new PropertyLoader();
        loader.setActiveProfileProperties(System.getProperty("profile-id"));
        baseUrl = loader.loadProperty("site.url");
        page = new Page(webDriver);
        startingPage = new StartingPage(webDriver);
        keycloakLoginPage = new KeycloakLoginPage(webDriver);
        informationSystemManagementPage = new InformationSystemManagementPage(webDriver);
        informationSystemAddEditPage = new InformationSystemAddEditPage(webDriver);
        participantAddEditPage = new ParticipantAddEditPage(webDriver);
        participantManagementPage = new ParticipantManagementPage(webDriver);
        deleteSystemModal = new DeletionModalWindow(webDriver);
        createdInformationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();
        editedInformationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();
        createdParticipant = RandomParticipantGenerator.getRandomParticipant();
        editedParticipant = RandomParticipantGenerator.getRandomParticipant();
    }

    public void openStaringPage(Boolean isToAutorize) {
        if (isToAutorize) {
            webDriver.navigate().to(baseUrl);
        }
    }

    public InformationSystem selectInformationSystem(String systemToCreate) {
        InformationSystem informationSystem;
        informationSystem = systemToCreate.equals("для создания") ? this.createdInformationSystem
                : this.editedInformationSystem;
        return informationSystem;
    }

    public Participant selectParticipant(String systemToCreate) {
        Participant participant;
        participant = systemToCreate.equals("для создания") ? this.createdParticipant
                : this.editedParticipant;
        return participant;
    }

    public Page detectPage(String pageName) {
        Page returnedPage = new Page(this.webDriver);
        switch (pageName) {
            case "Информационные системы":
                returnedPage =  this.informationSystemManagementPage.ensurePageLoaded();
                break;

            case "Подсистемы и компоненты":
                returnedPage =  this.participantManagementPage.ensurePageLoaded();
                break;

            case "Виды сведеий":
                returnedPage =  this.smevServiceManagementPage;
                break;

            case "Учетные записи":
                returnedPage = this.userManagementPage;
                break;

        }
        return returnedPage;
    }
}
