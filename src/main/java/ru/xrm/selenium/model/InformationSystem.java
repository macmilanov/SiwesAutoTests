package ru.xrm.selenium.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class InformationSystem {
    public String InformationSystemName;
    public String InformationSystemToken;
    public String InformationSystemMnemonic;
    public Boolean IsActiveState;

    public String getInformationSystemName()
    {
        return InformationSystemName;
    }
    public String getInformationSystemToken()
    {
        return InformationSystemToken;
    }
    public String getInformationSystemMnemonic()
    {
        return InformationSystemMnemonic;
    }
    public Boolean getIsActiveState()
    {
        return IsActiveState;
    }

    public InformationSystem setInformationSystemName(String informationSystemName)
    {
        this.InformationSystemName = informationSystemName;
        return this;
    }

    public InformationSystem setInformationSystemMnemonic(String informationSystemMnemonic)
    {
        this.InformationSystemMnemonic = informationSystemMnemonic;
        return this;
    }

    public InformationSystem setInformationSystemToken(String informationSystemToken)
    {
        this.InformationSystemToken = informationSystemToken;
        return this;
    }

    public InformationSystem setIsActiveState(Boolean isActiveState)
    {
        this.IsActiveState = isActiveState;
        return this;
    }

}
