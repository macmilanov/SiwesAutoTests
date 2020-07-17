package ru.xrm.selenium.model;

import java.util.List;
import java.util.Objects;

public class Participant {
    public String ParticipantName;
    public String ParticipantInformationSystemName;
    public Boolean IsParticipantActive;
    public String ParticipantClientId;
    public List< SmevService > ParticipantServices;

    public String getParticipantName() {
        return ParticipantName;
    }

    public String getParticipantInformationSystemName() {
        return ParticipantInformationSystemName;
    }

    public Boolean getIsParticipantActive(){
        return IsParticipantActive;
    }

    public String getParticipantClientId(){
        return ParticipantClientId;
    }

    public Participant setParticipantName(String participantName){
        this.ParticipantName = participantName;
        return this;
    }
    public Participant setParticipantClientId (String participantClientId){
        this.ParticipantClientId = participantClientId;
        return this;
    }
    public  Participant setIsParticipantActive (Boolean isParticipantActive){
        this.IsParticipantActive = isParticipantActive;
        return this;
    }
    public  Participant setParticipantInformationSystemName(String  informationSystem){
        this.ParticipantInformationSystemName = informationSystem;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant participant = (Participant) o;
        return Objects.equals(ParticipantName, participant.ParticipantName) &&
                Objects.equals(ParticipantClientId, participant.ParticipantClientId) &&
                Objects.equals(IsParticipantActive, participant.IsParticipantActive);
    }
}
