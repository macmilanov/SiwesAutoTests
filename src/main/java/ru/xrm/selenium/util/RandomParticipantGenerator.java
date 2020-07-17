package ru.xrm.selenium.util;

import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.model.Participant;

import java.util.Random;

public class RandomParticipantGenerator {
    public static String[] InformationSystemName = new String[]{
                    "Администрация города Пышмы",
                    "Тестовый Универсальный Кабинет (зарегистрированный в тестовом СМЭВ)"}
    ;

    public static Participant getRandomParticipant() {
        Participant participant = new Participant();
        participant.setParticipantName(RandomStringUtil.randomRussianString(5))
                .setParticipantClientId(RandomStringUtil.randomRussianString(5))
                .setParticipantInformationSystemName(CollectionUtil.getRandomElement(InformationSystemName))
                .setIsParticipantActive(new Random().nextBoolean());
        return participant;
    }
}
