package ru.telegram.familyBot.constants.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum InlineButtonList {
    WORK_WITH_DATE(EnumSet.of(InlineButtonNameEnum.GET_ALL_BIRTH_DATES, InlineButtonNameEnum.GET_ALL_EVENTS_DATES));

    private final EnumSet<InlineButtonNameEnum> inlineButtonList;
}
