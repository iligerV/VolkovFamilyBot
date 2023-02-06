package ru.telegram.familyBot.constants.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Названия кнопок инлайн клавиатуры
 */

@Getter
@AllArgsConstructor
public enum InlineButtonNameEnum {
    GET_ALL_BIRTH_DATES("Напомнить дни рождения"),
    GET_ALL_EVENTS_DATES("Напомнить события");

    private final String inlineButtonName;
}
