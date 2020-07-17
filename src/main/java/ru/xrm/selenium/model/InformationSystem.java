package ru.xrm.selenium.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

public class InformationSystem {
    public String InformationSystemName;
    public String InformationSystemToken;
    public String InformationSystemMnemonic;
    public Boolean IsActiveState;

    public String getInformationSystemName() {
        return InformationSystemName;
    }

    public String getInformationSystemToken() {
        return InformationSystemToken;
    }

    public String getInformationSystemMnemonic() {
        return InformationSystemMnemonic;
    }

    public Boolean getIsActiveState() {
        return IsActiveState;
    }

    public InformationSystem setInformationSystemName(String informationSystemName) {
        this.InformationSystemName = informationSystemName;
        return this;
    }

    public InformationSystem setInformationSystemMnemonic(String informationSystemMnemonic) {
        this.InformationSystemMnemonic = informationSystemMnemonic;
        return this;
    }

    public InformationSystem setInformationSystemToken(String informationSystemToken) {
        this.InformationSystemToken = informationSystemToken;
        return this;
    }

    public InformationSystem setIsActiveState(Boolean isActiveState) {
        this.IsActiveState = isActiveState;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationSystem system = (InformationSystem) o;
        return Objects.equals(InformationSystemName, system.InformationSystemName) &&
                Objects.equals(InformationSystemMnemonic, system.InformationSystemMnemonic) &&
                Objects.equals(IsActiveState, system.IsActiveState) &&
                Objects.equals(InformationSystemToken, system.InformationSystemToken);
    }


}
